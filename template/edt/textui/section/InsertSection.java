package edt.textui.section;

import edt.core.App;
import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputInteger;
import pt.utl.ist.po.ui.InputString;

/* FIXME: import core classes here */

/**
 * Command for adding a subsection to current section.
 */
public class InsertSection extends Command<App> {

    /**
     * Constructor.
     * 
     * @param ent the target entity.
     */
    public InsertSection(App app) {
        super(MenuEntry.INSERT_SECTION, app);
    }

    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute() {
        /* FIXME: implement command */
    }
}
