package edt.core;

public class Paragraph extends TextElement {
	
	private String _text;

	public Paragraph(String text) {
		_text=text;
	}

	public void setText(String text) {
		_text = text;
	}

	public String getContent() {
		return _text;
	}

	public int getSize() {
		return _text.length();
	}
}