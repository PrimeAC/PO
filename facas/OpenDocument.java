package edt.textui.main;

import pt.utl.ist.po.ui.Menu;
import pt.utl.ist.po.ui.InputString;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.InvalidOperation;

import edt.core.Manager;
import edt.core.Document;
/* FIXME: import core classes here */

/**
 * Command for opening an existing document in the editor.
 */
public class OpenDocument extends Command<Manager>{

    /**
     * Constructor.
     * 
     * @param ent the target entity.
     */
    public OpenDocument(Manager app) {
        super(MenuEntry.OPEN, app);
    }

    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute() throws InvalidOperation {
        /* FIXME: implement command */
        Form f = new Form();
        InputString filename = new InputString(f, Message.openFile());
        f.parse();
        Display display = new Display();
        Document doc = new Document();
        doc = doc.loadDocument(filename.value());
        if (doc != null) {
            entity().setDocument(doc.loadDocument(filename.value()));
            menu().entry(2).visible();
            menu().entry(3).visible();
            menu().entry(4).visible();
            menu().entry(5).visible();
            menu().entry(6).visible();
            menu().entry(7).visible(); 
        }
        else{
            display.add(Message.fileNotFound());
            display.display();
        }
    }
}
