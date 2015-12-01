package edt.textui.section;

import edt.core.Section;
import edt.core.VisitorContent;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;

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
        VisitorContent visitor = new VisitorContent();
        
        display.addNewLine(entity().accept(visitor));//paragrafos e seccoes 
        display.display();
     }
}
