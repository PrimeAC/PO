package edt.core;

import edt.textui.main.*;

import pt.utl.ist.po.ui.Display;

import java.util.*;
import java.io.*;

public class Document extends Section {

    private String _filename;

    private List<TextElement> _textElements = new ArrayList<>();

    private TreeMap<String, Author> _autores = new TreeMap<String, Author>();

    public Document(){

    }

    public void addAuthor(Author author) {
        _autores.put(author.getName(), author);
    }

    public TreeMap<String, Author> getAuthors() {
        return _autores;
    }

    public TextElement getTextElement(String id) {
        for(TextElement textElement : _textElements){
            if(textElement.getKey() == id){
                return textElement;
            }
        }
        return null;
    }

    public void indexElement(String id, TextElement ele) {
        ele.setKey(id);
        _textElements.add(ele);
    }
/*
    public String getHeadline() {

    }

    public void removeFromIndex(TextElement ele) {

    }*/

    public Document loadDocument(String filename) {

        ObjectInputStream in = null;
        Document doc = null;
        try {
            in = new ObjectInputStream(new FileInputStream(filename));
            doc = (Document) in.readObject();
            in.close();
        }catch(Exception e){

        }
        return doc;
    }

    public void saveDocument(String filename) {        
        
        ObjectOutputStream out = null;
        FileOutputStream filestream = null;
        try {
            filestream = new FileOutputStream(filename);
            out = new ObjectOutputStream(filestream);
            out.writeObject(this);
            out.close();
        } catch(IOException e){

        }
    }

    public String getFilename() {
        return _filename;
    }

    public void setFilename(String filename) {
        _filename = filename;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Document){
            Document doc = (Document)obj;
            return doc.getFilename().equals(this.getFilename()) && 
            doc.getAuthors().equals(this.getAuthors()) &&
            doc.getTitle().equals(this.getTitle()) &&
            doc.getContent().equals(this.getContent());
        }
        else{
            return false;
        }
    }
}