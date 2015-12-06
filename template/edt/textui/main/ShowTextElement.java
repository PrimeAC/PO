package edt.textui.main;

import edt.core.App;
import edt.core.Document;
import edt.core.TextElement;
import edt.core.Section;
import edt.core.VisitorContent;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;


/**
 * Command for showing the text element with a given identifier of the current document in the editor.
 */
public class ShowTextElement extends Command<App> {

    /**
     * Constructor.
     * 
     * @param app the target entity.
     */
    public ShowTextElement(App app) {
        super (MenuEntry.SHOW_TEXT_ELEMENT, app);
    }

    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute() {

        Display display = new Display();
        Form f = new Form();
        VisitorContent visitor = new VisitorContent();

        InputString inS = new InputString(f, Message.requestElementId());
        f.parse();
        System.out.println(entity().getDocument().getTextElement().size());
        if (entity().getDocument().getTextElement().containsKey(inS.value())) {
            
            display.add(entity().getDocument().getTextElement(inS.value()).accept(visitor));

        }
        else {
            display.add(Message.noSuchTextElement(inS.value()));
        }

        display.display();
    }
}
