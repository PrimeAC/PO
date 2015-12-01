package edt.core;

public interface Visitor {
	public String visit(Section section);
	public String visit(Paragraph paragraph);
}