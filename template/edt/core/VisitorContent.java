package edt.core;

public class VisitorContent implements Visitor {
	
	public String visit(Section section) {
		String content = section.getHeadLine()+"\n";

		for (Paragraph i : section.getParagraph()) {
			content += i.getContent()+"\n"; 
		}
		for (Section i : section.getSubsections()) {
			content += i.getContent();
		}
		return content;
	}

	public String visit(Paragraph paragraph) {
		return paragraph.getContent();
	}

}