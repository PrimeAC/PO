package edt.textui.main;

import java.util.*;
import java.lang.*;

import edt.core.App;
import edt.core.Document;
import edt.core.Author;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import edt.textui.main.Message;

/**
 * Command for showing the metadata of the current document in the editor.
 */
public class ShowMetadata extends Command<App> {

    /**
     * Constructor.
     * 
     * @param app the target entity
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
        Set<String> keys = entity().getDocument().getAuthors().keySet();

        doc = entity().getDocument();

        display.add(Message.documentTitle(doc.getTitle()));

        for (String i : keys) {
            display.addNewLine(Message.author(doc.getAuthors().get(i).getName(), doc.getAuthors().get(i).getEmail()));
        }

        display.addNewLine(Message.documentSections(doc.getSubsections().size()));

        display.addNewLine(Message.documentBytes(doc.getSize()));

        display.addNewLine(Message.documentIdentifiers(doc.getTextElement().size()));
        
        display.display();
    }
}
