package edt.core;

public class Section extends TextElement {

	private String _title;
	private List<Paragraph> _paragraph = new ArrayList<>();
	private List<Section> _subsection = new ArrayList<>();


	public String  getHeadLine(){ //************************
	}

	public void setTitle(String title){
		_title=title;
	}

	public int getSize() {
		int tamanhoParagrafo = 0;
		int tamanhoTitulo = _title.lenght();

		for (Paragraph paragraph : _paragraph)
			tamanhoParagrafo += paragraph.getSize();

		for (Section subsection : _subsection){
			tamanhoTitulo += _title.lenght();
			for (Paragraph paragraph : _paragraph)
			tamanhoParagrafo += paragraph.getSize();}

		return tamanhoParagrafo+tamanhoTitulo;



	}

	public String title(){
		return _title;
	}

	public String getContent() {
		String content = getHeadLine ;
		for (Paragraph paragraph : _paragraph)
			content += paragraph.getContent(); 
		return content;
	}

	public List<Section> getSubsections() {
		return _subsection;
	}

	public Section getSection(int idx) {
		return _subsection.get(idx)
	}

	public String getSubsectionIndex() {
    //(....).getKey()
	} 


	public void addSection(int idx , Section sec) {
		_subsection.add(idx,sec);
	}

	public boolean removeSection(int idx , Document doc ) {
		_subsection.remove(doc.getSection(idx))
	}

	public void addParagraph(int idx , Paragraph par) {
		_paragraph.add(idx,par);
	}

	public boolean removeParagraph(int idx , Document doc ) {
		_paragraph.remove(doc.getParagraph(idx));
	}

	public Paragraph getParagraph(int idx) {
		return _paragraph.get(idx);

	}

}