package edt.textui.section;

import edt.core.Section;
import edt.core.Document;
import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputInteger;
import pt.utl.ist.po.ui.InputString;

/* FIXME: import core classes here */

/**
 * Command for adding a subsection to current section.
 */
public class InsertSection extends Command<Section> {

    /**
     * Constructor.
     * 
     * @param ent the target entity.
     */
    public InsertSection(Section section) {
        super(MenuEntry.INSERT_SECTION, section);
    }

    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute() {
        Section section;

        Form f = new Form();
        InputInteger inI = new InputInteger(f, Message.requestSectionId());
        InputString inS = new InputString(f, Message.requestSectionTitle());
        f.parse();

        section = new Section(inS.value());

        entity().addSection(inI.value(), section);
    }
}
