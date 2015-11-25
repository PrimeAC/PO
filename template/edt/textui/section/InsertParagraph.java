package edt.textui.section;

import edt.core.Section;
import edt.core.Paragraph;
import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;
import pt.utl.ist.po.ui.InputInteger;

/* FIXME: import core classes here */

/**
 * Command for adding a paragraph to the current section.
 */
public class InsertParagraph extends Command<Section> {

    /**
     * Constructor.
     * 
     * @param ent the target entity.
     */
    public InsertParagraph(Section section) {
        super(MenuEntry.INSERT_PARAGRAPH, section);
    }

    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute() {
        Paragraph paragraph;

        Form f = new Form();
        InputInteger inI = new InputInteger(f, Message.requestParagraphId());
        InputString inS = new InputString(f, Message.requestParagraphContent());
        f.parse();

        paragraph = new Paragraph(inS.value()); 

        entity().addParagraph(inI.value(), paragraph);
    }
}
