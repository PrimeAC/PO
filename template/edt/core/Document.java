package edt.core;

import java.util.*;
import java.io.*;
import java.lang.*;

public class Document extends Section implements Serializable {

	private String _filename;

	private HashMap<String,TextElement> _textElement = new HashMap<>();

	private TreeMap<String, Author> _authors = new TreeMap<>();

	
	public void addAuthor(Author author) {
		_authors.put(author.getName(), author); 

	}

	public HashMap<String,TextElement> getTextElement() {
		return _textElement;
	}

	public TreeMap<String, Author> getAuthors() {
		return _authors;

	}

	public TextElement getTextElement(String id) {
		
		return _textElement.get(id);
		
	}

	public Boolean equals(Document doc) {
		Set<String> authorKeys = this.getAuthors().keySet();
		
		if (this.getFilename().equals(doc.getFilename())) {

			for (String i : _textElement.keySet()) {

				try {
					if (!(this.getTextElement().get(i).equals(doc.getTextElement().get(i)))) {
						return false;
					}
				}

				catch (NullPointerException e) {
					return false;
				}
				
			}
			 
			for (String i : authorKeys) {
				
				try {
					if (!(this.getAuthors().get(i).equals(doc.getAuthors().get(i)))) {
						return false;
					}
				}

				catch (NullPointerException e) {
					return false;
				}
			}
			return true;
		}
		return false;
	}

	public void indexElement(String id , TextElement ele) {
		ele.setKey(id);
		_textElement.put(id, ele);
	}

	public String getHeadLine() {
		if (_title == null) {
			return "{}";
		}

		return "{"+_title+"}"; 
	}

	public void removeFromIndex(TextElement ele) {

		for (String i : _textElement.keySet()) {
			if (_textElement.get(i).equals(ele)) {
				_textElement.remove(i);
				break;
			}
		}
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
			return null;
		}

		catch(Exception e) {
			return null;
		}

		return doc;		
	}

	public void saveDocument() {

		try {

			FileOutputStream filestream = new FileOutputStream(getFilename());

			ObjectOutputStream os = new ObjectOutputStream(filestream);

			os.writeObject(this);
			os.close();
		}

		catch(IOException e) {

		}

		catch(Exception e) {

		}
	}

	public String getFilename() {
		return _filename;
	}
	public void setFilename(String filename) {
		_filename=filename;
	}
}