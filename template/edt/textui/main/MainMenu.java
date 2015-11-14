package edt.textui.main;

import edt.core.App;
import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Menu;

/* FIXME: import core classes here */

/**
 * Represents the main menu of this application. This is the first menu
 * shown to the users.
 ***/

public class MainMenu extends Menu {

    public MainMenu(App app) {
        super(MenuEntry.TITLE,
              new Command<?>[] { 
                      new NewDocument(app),
                      new OpenDocument(app),
                      new SaveDocument(app),
                      new ShowMetadata(app),
                      new AddAuthor(app),
                      new ListTopSections(app),
                      new ShowTextElement(app),
                      new EditSection(app),
                      });
    }
}
