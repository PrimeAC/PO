package edt.textui.main;

import java.util.*;
import java.lang.*;
import edt.core.App;
import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import edt.textui.main.Message;
import edt.core.Document;
import edt.core.Author;
/* FIXME: import core classes here */

/**
 * Command for showing the metadata of the current document in the editor.
 */
public class ShowMetadata extends Command<App> {

    /**
     * Constructor.
     * 
     * @param ent the target entity.
     */
    public ShowMetadata(App app) {
        super(MenuEntry.SHOW_METADATA, app);
    }

    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute() {
        Display display = new Display();
        //Document document = new Document();
        App document = new App();


        display.add(Message.documentTitle(document.getDocument().getTitle()));

        for(Author i : document.getDocument().getAuthors().keySet()) {
            display.add(Message.author(i.getName(), i.getEmail()));
        }

        display.add(Message.documentSections(document.getDocument().getSubsections().size()));

        display.add(Message.documentBytes(document.getDocument().getSize()));

        display.add(Message.documentIdentifiers(document.getDocument().getTextElement().size()));
        
        display.display();
    }
}
