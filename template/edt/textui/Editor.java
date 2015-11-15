package edt.textui;

import edt.core.App;
import edt.core.Document;

import edt.textui.main.MainMenu;

import static pt.utl.ist.po.ui.UserInteraction.IO;
/**
 * Themain class of the edt application.
 **/
public class Editor {

    public static void main(String[] args) {
        
        App app =  new App();
        Document doc = new Document();

        app.setDocument(doc);
        MainMenu menu = new MainMenu(app);
    
        menu.open();
        IO.close();
    }
}
