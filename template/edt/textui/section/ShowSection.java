package edt.textui.section;

import edt.core.App;
import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;

/* FIXME: import core classes here */

/**
 * Command for showing the content of current section.
 */
public class ShowSection extends Command<App> {

    /**
     * Constructor.
     * 
     * @param ent the target entity.
     */
    public ShowSection(App app) {
        super(MenuEntry.SHOW_CONTENT, app);
    }

    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute() {
        
        Display display = new Display();
        
        display.add(entity().getDocument().getHeadLine());//titulo doc 
        display.addNewLine(entity().getDocument().getContent());//paragrafos e seccoes 
        display.display();
     }
}
