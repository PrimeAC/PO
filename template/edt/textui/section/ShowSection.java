package edt.textui.section;

import edt.core.Section;
import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;

/* FIXME: import core classes here */

/**
 * Command for showing the content of current section.
 */
public class ShowSection extends Command<Section> {

    /**
     * Constructor.
     * 
     * @param ent the target entity.
     */
    public ShowSection(Section section) {
        super(MenuEntry.SHOW_CONTENT, section);
    }

    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute() {
        
        Display display = new Display();
        
        display.add(entity().getHeadLine());//titulo doc 
        display.addNewLine(entity().getContent());//paragrafos e seccoes 
        display.display();
     }
}
