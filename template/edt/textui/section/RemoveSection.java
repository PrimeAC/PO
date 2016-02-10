package edt.textui.section;

import edt.core.Section;
import edt.core.Document;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputInteger;

/**
 * Command for removing a subsection of the current section.
 */
public class RemoveSection extends Command<Section> {

    private Document _document; 

    /**
     * Constructor.
     * 
     * @param ent the target entity.
     */
    public RemoveSection(Section section, Document document) {
        super(MenuEntry.REMOVE_SECTION, section);
        _document = document;
    }

    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute() {
        
        Form f = new Form();
        InputInteger inI = new InputInteger(f, Message.requestSectionId());
        f.parse();

       
        entity().removeSection(inI.value(), _document);
    }
}
