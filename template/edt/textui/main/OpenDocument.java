package edt.textui.main;

import java.io.IOException;

import edt.core.App;
import pt.utl.ist.po.ui.Menu;
import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;
import pt.utl.ist.po.ui.InvalidOperation;
import edt.core.Document;

/* FIXME: import core classes here */

/**
 * Command for opening an existing document in the editor.
 */
public class OpenDocument extends Command<App> {

    /**
     * Constructor.
     * 
     * @param ent the target entity.
     */
    public OpenDocument(App app) {
        super(MenuEntry.OPEN, app);
    }

    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute() throws InvalidOperation {
        
        Form f = new Form();
        InputString inS = new InputString(f, Message.openFile());
        f.parse();

        App app = new App();

        Document document = new Document();

        app.setDocument(document);
        document = app.getDocument();

        document.setFilename(inS.value());

        document.loadDocument();

        entity().setDocument(document);
    }
}
