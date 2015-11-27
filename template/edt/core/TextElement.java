package edt.core;

import java.io.*;

public abstract class TextElement implements Serializable {

	private String _key;

	public String getKey() {
		if (_key==null) {
			return "";
		}
		else {
			return _key; 
		}
	}

	public void setKey(String key) {
		_key= key;
	}

	//protected boolean isIndexed() {}

	public abstract String getContent();

	public abstract int getSize();

}