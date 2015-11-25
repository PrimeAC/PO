package edt.core;

import java.io.*;

public class Author implements Serializable {
	
	private String _name;

	private String _email;

	public Author(String name, String email) {
		_name=name;
		_email=email;
	}

	public String getEmail() {
		return _email;
	}

	public String getName() {
		return _name;
	}

	public boolean equals(Object obj) {
		Author objecto = (Author) obj;

		return getName().equals(objecto.getName());
	}

	public boolean compareTo(Author author) {
		return true;
	}
}