package edt.textui.main;

import edt.core.App;
import edt.core.Document;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;
import pt.utl.ist.po.ui.InvalidOperation;

import java.io.IOException;


/**
 * Command for saving the current document in the editor.
 */
public class SaveDocument extends Command<App> {

    /**
     * Constructor.
     * 
     * @param app the target entity.
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
        Document document = new Document();

        if (entity().getDocument().getFilename()!=null) {   
            String filename = entity().getDocument().getFilename(); 
            
            if (!(entity().getDocument()).equals(document.loadDocument(filename))) {
                entity().getDocument().saveDocument();
            }
        }
        else {
            Form f = new Form();
            InputString inS = new InputString(f, Message.newSaveAs());
            f.parse();

            entity().getDocument().setFilename(inS.value());
            entity().getDocument().saveDocument();
        }
    }   
}

