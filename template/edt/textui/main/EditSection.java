package edt.textui.main;

import edt.core.App;
import pt.utl.ist.po.ui.Menu;
import pt.utl.ist.po.ui.Command;
import edt.textui.section.EditMenu;

import static pt.utl.ist.po.ui.UserInteraction.IO;
import edt.textui.section.EditMenu;

/* FIXME: import core classes here */

/**
 * Command for editing the current document in the editor.
 */
public class EditSection extends Command<App> {

    /**
     * Constructor.
     * 
     * @param ent the target entity.
     */
    public EditSection(App app) {
        super(MenuEntry.OPEN_DOCUMENT_EDITOR, app);
    }

    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute() {

        App app =  new App();
        EditMenu menu = new EditMenu(app);

        menu.open();
        IO.close();
        
    }
}

