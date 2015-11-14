package edt.textui.main;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import edt.textui.main.Message;
/*import edt.core.Author;*/
import edt.core.Document;
/* FIXME: import core classes here */

/**
 * Command for showing the metadata of the current document in the editor.
 */
public class ShowMetadata extends Command<App> {

    /**
     * Constructor.
     * 
     * @param ent the target entity.
     */
    public ShowMetadata(App app) {
        super(MenuEntry.SHOW_METADATA, app);
    }

    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute() {
        Display display = new Display();
        /*Author autor = new Author();*/
        Document documento = new Document();

        if(documento == NULL) {
            System.out.println("Nada para imprimir");
        }
        display.add(documento.getFilename());
        /*display.add( autor.getName()"\\/"+autor.getEmail());*/
        display.display();
    }
}
