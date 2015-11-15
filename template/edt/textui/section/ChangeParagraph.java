package edt.textui.section;

import edt.core.App;
import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputInteger;
import pt.utl.ist.po.ui.InputString;

/* FIXME: import core classes here */

/**
 * Command for changing the content of a paragraph of the current section.
 */
public class ChangeParagraph extends Command<App> {

    /**
     * Constructor.
     * 
     * @param ent the target entity.
     */
    public ChangeParagraph(App app) {
        super(MenuEntry.EDIT_PARAGRAPH, app);
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
