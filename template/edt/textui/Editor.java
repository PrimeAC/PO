package edt.textui;

import edt.core.App;
import edt.core.Document;

import edt.textui.main.MainMenu;
import edt.parser.Parser;

import java.io.*;

import edt.core.Section;


import static pt.utl.ist.po.ui.UserInteraction.IO;
/**
 * Themain class of the edt application.
 **/
public class Editor {

    public static void main(String[] args) {
        Document document;
	    App app =  new App(); 
        MainMenu menu = new MainMenu(app);

        try {
	        Parser parser = new Parser();
	        String filename = System.getProperty("import");

	        document = parser.parse(filename);
	    }
	    catch (Exception e){
	    	document = new Document();
	    }
	   	app.setDocument(document);

        menu.open();
        IO.close();
    }
}
