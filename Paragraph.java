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

	public static void main(String[] args) {
		Paragraph p1 = new Paragraph();
		Paragraph p2 = new Paragraph();
		p1.setText("A mae do Afonso é boa!!");
		p2.setText("Pois é");
		p2.getSize();
		p1.getContent();
		p2.getContent();
		p1.getSize();
	}
}