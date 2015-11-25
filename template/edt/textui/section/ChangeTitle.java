package edt.textui.section;
import edt.core.App;
import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;

/* FIXME: import core classes here */

/**
 * Command for changing the title of the current section.
 */
public class ChangeTitle extends Command<App> {

    /**
     * Constructor.
     * 
     * @param ent the target entity.
     */
    public ChangeTitle(App app) {
        super(MenuEntry.CHANGE_TITLE, app);
    }

    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute() {
        
        Form f = new Form();
        InputString inS = new InputString(f, Message.requestSectionTitle());
        f.parse();

        entity().getDocument().setTitle(inS.value());
    }
}
