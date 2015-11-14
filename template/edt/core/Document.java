package edt.core;

import pt.utl.ist.po.ui.Display;

import java.util.*;
import java.io.*;

public class Document extends Section {

	private String _filename;

	private List<TextElement> _textElement = new ArrayList();

	private TreeMap<String, Author> _authors = new TreeMap<String, Author>();

	public void addAuthor(Author author) {

		_authors.put(author.gerName(), author); 

	}

	public TreeMap getAuthors() {
		return _authors;

	}

	public TextElement getTextElement(String id) {

		for(TextElement i : _textElement){
			if(i.getKey().equals(id)){
				return i;
			}
		}
		System.out.println("Text Element not Found!\n");
	}

	public void indexElement(String id , TextElement ele) {
		ele.setKey(id);
		_textElement.add(ele);
	}

	//public String getHeadLine() {}

	public void removeFromIndex(TextElement ele) {
		remove(ele);
	}

	public void loadDocument() {

		try {

			FileInputStream filestream = new FileInputStream(getFilename());

			ObjectInputStream is = new ObjectInputStream(filestream);

			Document doc = (Document) is.readObject();

			setDocument(doc);
		}
		catch(Exception e) {
			Display display = new Display();
			display.add(Message.fileNotFound());
			display.display();
		}
}

	public void saveDocument() {

		try{

			FileOutputStream filestream = new FileOutputStream(getFilename());

			ObjectOutputStream os = new ObjectOutputStream(filestream);

			os.writeObject(this);
		}
		catch(Exception e){
			Display display = new Display();
			display.add("Error at file output stream");
			display.display();
		}

	}

	public String getFilename() {
		return _filename;
	}
	public void setFilename(String filename ) {
		_filename=filename;
	}
	
}