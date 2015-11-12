

public class Section extends TextElement {
	
	private String _title;

	public String  getHeadLine(){}

	public void setTitle(String title){
		_title=title;
	}

	public int getSize() {}

	public String getContent() {}

	public List<Section> getSubsections() {}

	public Section getSection(int idx) {}

	public String getSubsectionIndex() {}

	public void addSection(int idx , Section sec) {}

	public boolean removeSection(int idx , Document doc ) {}

	public void addParagraph(int idx , Paragraph par) {}

	public boolean removeParagraph(int idx , Document doc ) {}

	public Paragraph getParagraph(int idx) {}

}