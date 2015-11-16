package edt.textui;

import edt.core.App;
import edt.core.Document;

import edt.textui.main.MainMenu;
import edt.parser.Parser;





import edt.core.Section;


import static pt.utl.ist.po.ui.UserInteraction.IO;
/**
 * Themain class of the edt application.
 **/
public class Editor {

    public static void main(String[] args) {
        Document document;

	    App app =  new App();
        try {
	        Parser parser = new Parser();
	        String filename = System.getProperty("import");

	        document = parser.parse(filename);
	    }
	    catch (Exception e){
	    	document = new Document();
	    }
	   	
	   	app.setDocument(document);

	   	Section sec = new Section("CONAS");

	   	document.addSection(0, sec);
	   	document.addSection(1,sec);

        MainMenu menu = new MainMenu(app);
    
        menu.open();
        IO.close();
    }
}
