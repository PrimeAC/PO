package edt.textui.section;

import edt.core.Section;
import edt.core.Document;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputInteger;
import pt.utl.ist.po.ui.InputString;

/**
 * Command for indexing a paragraph (nomear um parágrafo 2.2.9) of the current section.
 */
public class IndexParagraph extends Command<Section> {

    private Document _document;

    /**
     * Constructor.
     * 
     * @param ent the target entity.
     */
    public IndexParagraph(Section section, Document document) {
        super(MenuEntry.NAME_PARAGRAPH, section);
        _document=document;
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
        InputString inS = new InputString(f, Message.requestUniqueId());
        f.parse();

        if (inI.value()<0 || inI.value()>entity().getParagraph().size()){
            display.add(Message.noSuchParagraph(inI.value()));
            display.display();
            return;
        }

        
        if (inS.value().equals("")) {
            if (_document.getTextElement().containsKey(entity().getParagraph(inI.value()).getKey())) {
                _document.removeFromIndex(entity().getParagraph(inI.value()));
                return;
            }
            else {
                entity().getParagraph(inI.value()).setKey("");
                return;
            }
        }
        

        if (entity().getParagraph(inI.value()).getKey().length()>0) {
            _document.getTextElement().remove(entity().getParagraph(inI.value()).getKey());

            entity().getParagraph(inI.value()).setKey(inS.value());
            _document.getTextElement().put(inS.value(),entity().getParagraph(inI.value()));
            display.add(Message.paragraphNameChanged());

            display.display();
        }

        if (_document.getTextElement().containsKey(inS.value())) {
            _document.removeFromIndex(_document.getTextElement(inS.value()));
            entity().getParagraph(inI.value()).setKey(inS.value());
            _document.getTextElement().put(inS.value(),entity().getParagraph(inI.value()));
            return;
        }

        else {
            entity().getParagraph(inI.value()).setKey(inS.value());
            _document.getTextElement().put(inS.value(),entity().getParagraph(inI.value()));
            return;
        }

    }
}
