package edt.textui.main;

import java.util.SortedSet;

import pt.utl.ist.po.ui.Menu;
import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import edt.core.Document;
import edt.core.Section;

/* FIXME: import core classes here */

/**
 * Command for showing the top sections of the current document in the editor.
 */
public class ListTopSections extends Command<App> {

    /**
     * Constructor.
     * 
     * @param ent the target entity.
     */
    public ListTopSections(App app) {
        super(MenuEntry.SHOW_INDEX, app);
    }

    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute() {
        Document document = new Document();
        int i;

        for(: document.)

    }
}
