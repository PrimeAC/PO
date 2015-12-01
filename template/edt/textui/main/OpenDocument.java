package edt.textui.main;

import java.io.IOException;

import edt.core.App;
import edt.core.Document;

import pt.utl.ist.po.ui.Menu;
import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;
import pt.utl.ist.po.ui.InvalidOperation;

/**
 * Command for opening an existing document in the editor.
 */
public class OpenDocument extends Command<App> {

    /**
     * Constructor.
     * 
     * @param app the target entity.
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
        Document document = new Document();
        Display display = new Display();

        Form f = new Form();
        InputString inS = new InputString(f, Message.openFile());
        f.parse();

        if (entity().getDocument().loadDocument(inS.value()) != null)
            entity().setDocument(document.loadDocument(inS.value()));
        else {
            display.add(Message.fileNotFound());
            display.display();
        } 

    
    }
}
