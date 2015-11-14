package edt.textui.main;

import pt.utl.ist.po.ui.Menu;
import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.InvalidOperation;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;

import edt.core.*;

//import edt.core.Manager;
//import edt.core.Document;
/* FIXME: import core classes here */

/**
 * Command for saving the current document in the editor.
 */
public class SaveDocument extends Command<Manager>{

    /**
     * Constructor.
     * 
     * @param ent the target entity.
     */
    public SaveDocument(Manager app) {
        super(MenuEntry.SAVE, app);
    }

    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute() throws InvalidOperation {
        /* FIXME: implement command */
        String filename = entity().getDocument().getFilename();
        Document doc = new Document();
        doc = doc.loadDocument(filename);
        if(!entity().getDocument().equals(doc)){
            if(filename == null){
                Form f = new Form();
                InputString file = new InputString(f, Message.newSaveAs());
                f.parse();
                entity().getDocument().setFilename(file.value());
                filename = file.value();
            }
            entity().getDocument().saveDocument(filename);
        }
    }
}