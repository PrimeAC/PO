package edt.textui.section;
import edt.core.App;
import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;
import pt.utl.ist.po.ui.InputInteger;

/* FIXME: import core classes here */

/**
 * Command for indexing ia subsection (nomear secção 2.2.6) the current section .
 */
public class IndexSection extends Command<App> {

    /**
     * Constructor.
     * 
     * @param ent the target entity.
     */
    public IndexSection(App app) {
        super(MenuEntry.NAME_SECTION, app);
    }

    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute() {
        /* FIXME: implement command */
    }
}
