package edt.core;

public class VisitorContent implements Visitor {
	
	public String visit(Section section) {
		String content = section.getHeadLine()+"\n";

		for (Paragraph i : section.getParagraph()) {
			content += visit(i)+"\n"; 
		}
		for (Section i : section.getSubsections()) {
			content += visit(i);
		}
		return content;
	}

	public String visit(Paragraph paragraph) {
		return paragraph.getContent();
	}

}