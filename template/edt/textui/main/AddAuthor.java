package edt.textui.main;

import pt.utl.ist.po.ui.Menu;
import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;

/* FIXME: import core classes here */

/**
 * Command for adding an author to the current document in the editor.
 */
public class AddAuthor extends Command<App> {

    /**
     * Constructor.
     * 
     * @param ent the target entity.
     */
    public AddAuthor(App app) {
        super(MenuEntry.ADD_AUTHOR, app);
    }

    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute() {
        String name;
        String email;
        Form f = new Form();
        InputString inS = new InputString(f, Message.requestAuthorName());
        f.parse();

        name = inS.getValue();

        InputString inS = new InputString(f, Message.requestEmail());

        email = inS.getValue();

        Author author = new Author(name, email);

        addAuthor(author);
    }
}
