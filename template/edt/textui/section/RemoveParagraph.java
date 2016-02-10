package edt.textui.section;

import edt.core.Section;
import edt.core.Document;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputInteger;

/**
 * Command for removing a paragraph of the current section.
 */
public class RemoveParagraph extends Command<Section> {

    private Document _document;
    /**
     * Constructor.
     * 
     * @param ent the target entity.
     */
    public RemoveParagraph(Section section, Document document) {
        super(MenuEntry.REMOVE_PARAGRAPH, section);
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
        InputInteger inI = new InputInteger(f, Message.requestParagraphId());
        f.parse();
        
        if (entity().getParagraph(inI.value())==null){
            display.add(Message.noSuchParagraph(inI.value()));
            display.display();
            return;
        }

        _document.removeFromIndex(entity().getParagraph(inI.value()));
        entity().removeParagraph(inI.value(), _document);
    }
}
