public class Document extends Section {

	private String _filename;

	public void addAuthor() {

	}
	public void getAuthors() {

	}

	public TextElement getTextElement( String id ) {}

	public void indexElement( String id , TextElement ele ) {}

	public String getHeadLine() {}

	public void removeFromIndex(TextElement ele) {}

	public void loadDocument() {}

	public void saveDocument() {}

	public String getFilename() {
		return _filename;
	}
	public void setFilename(String filename ) {
		_filename=filename;
	}
	
}