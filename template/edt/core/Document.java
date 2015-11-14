import pt.utl.ist.po.ui.Display;

public class Document extends Section {

	private String _filename;

	public void addAuthor() {

	}
	public void getAuthors() {

	}

	public TextElement getTextElement(String id ) {}

	public void indexElement(String id , TextElement ele ) {}

	public String getHeadLine() {}

	public void removeFromIndex(TextElement ele) {}

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