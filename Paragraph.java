import java.io.*;



public class Paragraph {
	
	private String _text;

	public Paragraph() {
		_text = "";
	}

	public void setText(String text ) {
		_text = text;
	}

	public String getContent() {
		return _text;
	}

	public int getSize() {
		return _text.length();
	}
}