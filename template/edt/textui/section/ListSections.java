package edt.textui.section;

import edt.core.App;
import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;

/* FIXME: import core classes here */

/**
 * Command for listing all subsections of the current section.
 */
public class ListSections extends Command<App> {

    /**
     * Constructor.
     * 
     * @param ent the target entity.
     */
    public ListSections(App app) {
        super(MenuEntry.LIST_SECTIONS, app);
    }

    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute() {
        
    }
}
