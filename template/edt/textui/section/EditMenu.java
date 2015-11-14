package edt.textui.section;

import pt.utl.ist.po.ui.Menu;
import pt.utl.ist.po.ui.Command;
import edt.core.App;

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
    public EditMenu(App app) {
        super(MenuEntry.TITLE,
              new Command<?>[] { 
                      new ChangeTitle(app),
                      new ListSections(app),
                      new ShowSection(app),
                      new SelectSection(app),
                      new InsertSection(app),
                      new IndexSection(app),
                      new RemoveSection(app),
                      new InsertParagraph(app),
                      new IndexParagraph(app),
                      new ChangeParagraph(app),
                      new RemoveParagraph(app),
                      });
    }
}
