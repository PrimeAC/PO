package edt.textui.section;

import edt.core.Section;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;

/**
 * Command for listing all subsections of the current section.
 */
public class ListSections extends Command<Section> {

    /**
     * Constructor.
     * 
     * @param ent the target entity.
     */
    public ListSections(Section section) {
        super(MenuEntry.LIST_SECTIONS, section);
    }

    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute() {
        Display display = new Display();

        display.add(entity().getAllTitles(0));
        display.display();
        
    }
}
