package edt.textui.main;

import edt.core.App;
import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;
import edt.core.Document;
import edt.core.TextElement;

/* FIXME: import core classes here */

/**
 * Command for showing the text element with a given identifier of the current document in the editor.
 */
public class ShowTextElement extends Command<App> {

    /**
     * Constructor.
     * 
     * @param ent the target entity.
     */
    public ShowTextElement(App app) {
        super(MenuEntry.SHOW_TEXT_ELEMENT, app);
    }

    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute() {

        Display display = new Display();
        Document document = new Document();

        Form f = new Form();
        InputString inS = new InputString(f, Message.requestElementId());
        f.parse();

        document = getDocument();

        if(document.getTextElement(inS.value())!=null) {
            display.add(document.getTextElement(inS.value()).getContent());
        }
        else {
            display.add(Message.noSuchTextElement(document.getTextElement(inS.value()).getKey()));
        }

        display.display();
    }
}
