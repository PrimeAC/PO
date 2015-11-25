package edt.textui.section;
import edt.core.App;
import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputInteger;
import pt.utl.ist.po.ui.InputString;

/* FIXME: import core classes here */

/**
 * Command for indexing a paragraph (nomear um parágrafo 2.2.9) of the current section.
 */
public class IndexParagraph extends Command<App> {

    /**
     * Constructor.
     * 
     * @param ent the target entity.
     */
    public IndexParagraph(App app) {
        super(MenuEntry.NAME_PARAGRAPH, app);
    }

    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute() {
        Display display = new Display();

        Form f = new Form();
        InputInteger inI = new InputInteger(f, Message.requestParagraphId());
        InputString inS = new InputString(f, Message.requestParagraphId());
        f.parse();

        if (entity().getDocument().getParagraph(inI.value()) == null){
            display.add(Message.noSuchParagraph(inI.value()));
        }

        else {
            entity().getDocument().getParagraph(inI.value()).setKey(inS.value());
            display.add(Message.paragraphNameChanged());
        }

        display.display();
    }
}
