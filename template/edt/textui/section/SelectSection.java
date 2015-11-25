package edt.textui.section;

import edt.core.App;
import edt.core.Document;
import edt.core.Section;
import pt.utl.ist.po.ui.Menu;
import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputInteger;

import edt.textui.main.EditSection;

/* FIXME: import core classes here */

/**
 * Command for selecting a subsection of the current section and edit it.
 */
public class SelectSection extends Command<App> {

    /**
     * Constructor.
     * 
     * @param ent the target entity.
     */
    public SelectSection(App app) {
        super(MenuEntry.SELECT_SECTION, app);
    }

    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute() {
        Document document = new Document();
        Display display = new Display();

        Form f = new Form();
        InputInteger inI = new InputInteger(f, Message.requestSectionId());
        f.parse();

        document = (Document) entity().getDocument().getSection(inI.value());

        if ( document != null) {
            entity().setDocument(document);
            display.addNewLine(Message.newActiveSection(inI.value()));
        }
        else {
            display.addNewLine(Message.noSuchSection(inI.value()));
        }
    }
}
