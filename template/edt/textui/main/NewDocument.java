package edt.textui.main;

import edt.core.App;

import pt.utl.ist.po.ui.Menu;
import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputInteger;
import edt.core.Document;

/* FIXME: import core classes here */

/**
 * Command for creating a new document in the editor.
 */
public class NewDocument extends Command<App> {

    /**
     * Constructor.
     * 
     * @param ent the target entity.
     */
    public NewDocument(App app) {
        super(MenuEntry.NEW, app);
    }

    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute() {
        App application = new App();
        Document doc = new Document();

        application.setDocument(doc);
        
    }
}
