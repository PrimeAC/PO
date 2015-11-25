package edt.textui.section;

import edt.core.Section;
import edt.core.Document;
import pt.utl.ist.po.ui.Menu;
import pt.utl.ist.po.ui.Command;
import edt.core.Section;

import edt.textui.section.*;

/* FIXME: import core classes here */

/**
 * Represents the edit menu of this application. This menu
 * shows the option to edit the selected section.
 ***/

public class EditMenu extends Menu {
    /**
     * Builds an EditMenu object. It has all available options for editing
     * a section.
     *
     * @param doc
     * @param section
     **/
    public EditMenu(Section section, Document document) {
        super(MenuEntry.TITLE,
              new Command<?>[] { 
                      new ChangeTitle(section),
                      new ListSections(section),
                      new ShowSection(section),
                      new SelectSection(section, document),
                      new InsertSection(section),
                      new IndexSection(section, document),
                      new RemoveSection(section, document),
                      new InsertParagraph(section),
                      new IndexParagraph(section, document),
                      new ChangeParagraph(section),
                      new RemoveParagraph(section, document),
                      });
    }
}
