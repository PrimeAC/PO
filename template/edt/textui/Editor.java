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
        //System.out.println("1");
	    App app =  new App();
        try {
	        Parser parser = new Parser();
	        String filename = System.getProperty("import");
	        //System.out.println(filename);

	        document = parser.parse(filename);
	        //System.out.println(document.getTitle());
	    }
	    catch (Exception e){
	    	//System.out.println("2");
	    	document = new Document();
	    }
	   	//System.out.println("3");
	   	app.setDocument(document);

	   	//Section sec = new Section("CONAS");
	   	//document.setTitle("CONA");

	   	//document.addSection(0, sec);
	   	//document.addSection(1,sec);

        MainMenu menu = new MainMenu(app);
    
        menu.open();
        IO.close();
    }
}
