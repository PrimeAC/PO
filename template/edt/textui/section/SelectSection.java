package edt.textui.section;

import edt.textui.main.EditSection;

import edt.core.Section;
import edt.core.Document;

import pt.utl.ist.po.ui.Menu;
import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputInteger;

/**
 * Command for selecting a subsection of the current section and edit it.
 */
public class SelectSection extends Command<Section> {

    private Document _document;

    /**
     * Constructor.
     * 
     * @param ent the target entity.
     */
    public SelectSection(Section section, Document document) {
        super(MenuEntry.SELECT_SECTION, section);
        _document = document;
    }

    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute() {
        EditMenu menu;
        Display display = new Display();

        Form f = new Form();
        InputInteger inI = new InputInteger(f, Message.requestSectionId());
        f.parse();

        if (entity().getSection(inI.value()) != null) {
            display.add(Message.newActiveSection(inI.value()));
            display.display();

            menu =  new EditMenu(entity().getSection(inI.value()), _document);

            menu.open();
        }
        else {
            display.add(Message.noSuchSection(inI.value()));
            display.display();
        }

        
        
    }
}
