package edt.textui.section;

import edt.core.Section;
import edt.core.Paragraph;
import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputInteger;
import pt.utl.ist.po.ui.InputString;

/* FIXME: import core classes here */

/**
 * Command for changing the content of a paragraph of the current section.
 */
public class ChangeParagraph extends Command<Section> {

    /**
     * Constructor.
     * 
     * @param ent the target entity.
     */
    public ChangeParagraph(Section section) {
        super(MenuEntry.EDIT_PARAGRAPH, section);
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
        InputString inS = new InputString(f, Message.requestParagraphContent());
        f.parse();

        if (entity().getParagraph(inI.value()) == null ) {
            display.add(Message.noSuchParagraph(inI.value()));
            display.display();
        }

        else {
            entity().getParagraph(inI.value()).setText(inS.value());
        }
   }
}
