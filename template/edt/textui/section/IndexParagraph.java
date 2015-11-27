package edt.textui.section;

import edt.core.Section;
import edt.core.Document;
import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputInteger;
import pt.utl.ist.po.ui.InputString;

/* FIXME: import core classes here */

/**
 * Command for indexing a paragraph (nomear um parágrafo 2.2.9) of the current section.
 */
public class IndexParagraph extends Command<Section> {

    private Document _document;

    /**
     * Constructor.
     * 
     * @param ent the target entity.
     */
    public IndexParagraph(Section section, Document document) {
        super(MenuEntry.NAME_PARAGRAPH, section);
        _document=document;
    }

    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute() {
        Display display = new Display();

        Form f = new Form();
        InputInteger inI = new InputInteger(f, Message.requestParagraphId());
        InputString inS = new InputString(f, Message.requestUniqueId());
        f.parse();

        if (inI.value()<0 || inI.value()>entity().getParagraph().size()){
            display.add(Message.noSuchParagraph(inI.value()));
            display.display();
            return;
        }

        if (entity().getParagraph(inI.value()).getKey().length()>0) {
            System.out.println(entity().getParagraph(inI.value()).getKey());
            _document.getTextElement(entity().getParagraph(inI.value()).getKey()).setKey("");
            entity().getParagraph(inI.value()).setKey("");
            System.out.println(entity().getParagraph(inI.value()).getKey());
        }


        else {
            entity().getParagraph(inI.value()).setKey(inS.value());
            _document.getTextElement().put(inS.value(),entity().getParagraph(inI.value()));
            return;
        }

        entity().getParagraph(inI.value()).setKey(inS.value());
        _document.getTextElement().put(inS.value(),entity().getParagraph(inI.value()));
        display.add(Message.paragraphNameChanged());

        display.display();
    }
}
