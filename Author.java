public class Author {
	
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
		return getEmail()==obj.getEmail() && getName()==obj.getName;
	}

	public int compareTo(Author author) {
		return compareTo(author);
	}
}