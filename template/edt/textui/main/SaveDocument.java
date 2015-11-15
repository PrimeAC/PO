package edt.textui.main;

import edt.core.App;
import edt.core.Document;
import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;
import pt.utl.ist.po.ui.InvalidOperation;

import java.io.IOException;

/* FIXME: import core classes here */

/**
 * Command for saving the current document in the editor.
 */
public class SaveDocument extends Command<App> {

    /**
     * Constructor.
     * 
     * @param ent the target entity.
     */
    public SaveDocument(App app) {
        super(MenuEntry.SAVE, app);
    }

    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute() throws InvalidOperation {
        
        String filename = entity().getDocument().getFilename();
        App app = new App();
        Document document = new Document();
        app.setDocument(document);
        document= app.getDocument();
        document.setFilename(filename);
        document.loadDocument();

        //document.setFilename(filename);
        
        if(!(entity().getDocument()).equals(app.getDocument())){
            if (filename==null) {

                Form f = new Form();
                InputString inS = new InputString(f, Message.newSaveAs());
                f.parse();

                entity().getDocument().setFilename(inS.value());

            } 
            entity().getDocument().saveDocument();

        }
    }
}

