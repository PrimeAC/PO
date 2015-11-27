package edt.textui.section;

import edt.core.Section;
import edt.core.Document;
import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;
import pt.utl.ist.po.ui.InputInteger;

/* FIXME: import core classes here */

/**
 * Command for indexing ia subsection (nomear secção 2.2.6) the current section .
 */
public class IndexSection extends Command<Section> {

    private Document _document;

    /**
     * Constructor.
     * 
     * @param ent the target entity.
     */
    public IndexSection(Section section, Document document) {
        super(MenuEntry.NAME_SECTION, section);
        _document = document;
    }

    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute() {
        Display display = new Display();

        Form f = new Form();
        InputInteger inI = new InputInteger(f, Message.requestSectionId());
        InputString inS = new InputString(f, Message.requestUniqueId());
        f.parse();

        if (inI.value()<0 || inI.value()>entity().getSubsections().size()){
            display.add(Message.noSuchSection(inI.value()));
            display.display();
            return;
        }

        if (_document.getTextElement().containsKey(inS.value())) {
            _document.getTextElement(inS.value()).setKey("");

        }

        if (entity().getSection(inI.value()).getKey().equals("")) {
            entity().getSection(inI.value()).setKey(inS.value());
            _document.getTextElement().put(inS.value(),entity().getSection(inI.value()));
            return;
        }

        entity().getSection(inI.value()).setKey(inS.value());
        _document.getTextElement().put(inS.value(),entity().getSection(inI.value()));
        display.add(Message.sectionNameChanged());

        display.display();
    }
}
