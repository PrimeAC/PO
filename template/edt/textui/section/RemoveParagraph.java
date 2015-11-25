package edt.textui.section;

import edt.core.Section;
import edt.core.Document;
import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputInteger;

/* FIXME: import core classes here */

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
        
        Form f = new Form();
        InputInteger inI = new InputInteger(f, Message.requestParagraphId());
        f.parse();

        entity().removeParagraph(inI.value(), _document);
    }
}
