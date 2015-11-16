package edt.core;

import pt.utl.ist.po.ui.Display;
import edt.textui.main.Message;
import pt.utl.ist.po.ui.InvalidOperation;

import java.util.*;
import java.io.*;
import java.lang.*;

public class Document extends Section implements Serializable {

	private String _filename;

	private List<TextElement> _textElement = new ArrayList<>();

	private TreeMap<String, Author> _authors = new TreeMap<>();

	
	public void addAuthor(Author author) {
		_authors.put(author.getName(), author); 

	}

	public List<TextElement> getTextElement(){
		return _textElement;
	}

	public TreeMap<String, Author> getAuthors() {
		return _authors;

	}

	public TextElement getTextElement(String id) {

		for(TextElement i : _textElement){
			if(i.getKey().equals(id)){
				return i;
			}
		}
		return null;
		
	}

	public Boolean equals(Document doc){
		
		Set<String> keys = this.getAuthors().keySet();
		//System.out.println("entrei no equals");
		if (this.getFilename().equals(doc.getFilename())){
			for (TextElement i : _textElement){
				if (!(i.getContent().equals(doc.getContent()))) {
					//System.out.println("i.getContent()");
					return false;
				}
			}
			 
			for(String i : keys) {
				
				try{
					if (!(this.getAuthors().get(i).equals(doc.getAuthors().get(i)))) {
						//System.out.println("i.getAuthors()");
						return false;
					}
				}
				catch (NullPointerException e) {
					//System.out.println("null pointer exception");
					return false;
				}
			}
			return true;

		}
		//System.out.println("filename diferente");
		return false;
	}

	public void indexElement(String id , TextElement ele) {
		ele.setKey(id);
		_textElement.add(ele);
	}

	//public String getHeadLine() {}

	public void removeFromIndex(TextElement ele) {
		_textElement.remove(ele);
	}

	public Document loadDocument(String filename) {

		Document doc = new Document();
		try {

			FileInputStream filestream = new FileInputStream(filename);

			ObjectInputStream is = new ObjectInputStream(filestream);

			doc = (Document) is.readObject();
			is.close();
		}
		catch(IOException e) {
			Display display = new Display();
			display.add(Message.fileNotFound());
			display.display();
		}
		catch(Exception e) {
			Display display = new Display();
			display.add("Failed to load file!");
			display.display();
		}
		return doc;		
}

	public void saveDocument() {

		try{

			FileOutputStream filestream = new FileOutputStream(getFilename());

			ObjectOutputStream os = new ObjectOutputStream(filestream);

			os.writeObject(this);

			os.close();
		}
		catch(IOException e){
			Display display = new Display();
			display.add("Error at file output stream");
			display.display();
		}
		catch(Exception e) {
			Display display = new Display();
			display.add("Failed to save file!");
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