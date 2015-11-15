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
        Document doc = new Document();
        App document = new App();
        Set<String> keys = document.getDocument().getAuthors().keySet();

        doc = document.getDocument();

        display.add(Message.documentTitle(doc.getTitle()));

        for(String i : keys) {
            display.add(Message.author(doc.getAuthors().get(i).getName(), doc.getAuthors().get(i).getEmail()));
        }

        display.add(Message.documentSections(doc.getSubsections().size()));

        display.add(Message.documentBytes(doc.getSize()));

        display.add(Message.documentIdentifiers(doc.getTextElement().size()));
        
        display.display();
    }
}
