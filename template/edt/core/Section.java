package edt.core;

import java.util.*;
import java.lang.*;

public class Section extends TextElement {

	private String _title;
	private List<Paragraph> _paragraph = new ArrayList<>();
	private List<Section> _subsection = new ArrayList<>();

	public Section(){}

	public Section(String title){
		_title=title;
	}

	public String  getHeadLine(){
		if(_title==null){
			return "{}";
		} 
		return "{"+_title+"}"; 
	}

	public void setTitle(String title){
		_title=title;
	}

	public int getSize() {
		int tamanhoParagrafo;
		int tamanhoTitulo;

		tamanhoParagrafo = 0;

		if(this.getTitle()!=null){
			tamanhoTitulo = this.getTitle().length();
		} 
		else tamanhoTitulo = 0;

		for (Paragraph i : this._paragraph) {
			tamanhoParagrafo += i.getSize();
		}

		for (Section i : this.getSubsections()) {
			
			if(this._title!=null){
				tamanhoTitulo += i._title.length();
			} 

			for (Paragraph j : this._paragraph) {
				tamanhoParagrafo += j.getSize();
			}
		}
		return tamanhoParagrafo+tamanhoTitulo;
	}

	public String getTitle(){
		if (_title == null){
			return "";
		}
		return _title;
	}

	public String getContent() {
		String content ="";
		for (Paragraph i : _paragraph)
			content += i.getContent(); 
		return content;
	}

	public List<Section> getSubsections() {
		return _subsection;
	}

	public Section getSection(int idx) {
		return _subsection.get(idx);
	}

	//public String getSubsectionIndex() {
    //(....).getKey()
	//} 


	public void addSection(int idx , Section sec) {
		if(idx < 0 || idx > _subsection.size()) {
			_subsection.add(sec);
		}
		else {
			_subsection.add(idx,sec);
		}
	}

	public boolean removeSection(int idx , Document doc ) {
		return _subsection.remove(doc.getSection(idx));
	}

	public void addParagraph(int idx , Paragraph par) {
		if(idx < 0 || idx > _paragraph.size()) {
			_paragraph.add(par);
		}
		else {
			_paragraph.add(idx,par);
		}
	}

	public boolean removeParagraph(int idx , Document doc ) {
		return _paragraph.remove(doc.getParagraph(idx));
	}

	public Paragraph getParagraph(int idx) {
		return _paragraph.get(idx);

	}

}