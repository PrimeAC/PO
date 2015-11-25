package edt.textui.section;

import edt.core.App;
import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputInteger;

/* FIXME: import core classes here */

/**
 * Command for removing a subsection of the current section.
 */
public class RemoveSection extends Command<App> {

    /**
     * Constructor.
     * 
     * @param ent the target entity.
     */
    public RemoveSection(App app) {
        super(MenuEntry.REMOVE_SECTION, app);
    }

    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute() {
        
        Form f = new Form();
        InputInteger inI = new InputInteger(f, Message.requestSectionId());
        f.parse();

        entity().getDocument().removeSection(inI.value(), entity().getDocument());
    }
}
