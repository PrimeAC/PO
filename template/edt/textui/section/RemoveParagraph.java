package edt.textui.section;

import edt.core.App;
import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputInteger;

/* FIXME: import core classes here */

/**
 * Command for removing a paragraph of the current section.
 */
public class RemoveParagraph extends Command<App> {

    /**
     * Constructor.
     * 
     * @param ent the target entity.
     */
    public RemoveParagraph(App app) {
        super(MenuEntry.REMOVE_PARAGRAPH, app);
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
