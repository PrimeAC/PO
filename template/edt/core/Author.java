package edt.core;

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
		Author objecto = (Author) obj;
		return getEmail().equals(objecto.getEmail()) && getName().equals(objecto.getName());
	}

	public int compareTo(Author author) {
		return compareTo(author);
	}

	/*public static void main(String[] args) {
		Author a1 = new Author("Afonso", "afonso.caetano@outlook.com");
		Author a2 = new Author("Diogo", "diogococo@hotmail.com");
		Author a3 = new Author("Francisco", "kikoftw@gmail.com");

		System.out.println("a1: " +a1.getName() +"\n");
		System.out.println("a1: " +a1.getEmail() +"\n");
		System.out.println("a2: " +a2.getName() +"\n");
		System.out.println("a2: " +a2.getEmail() +"\n");
		System.out.println("a3: " +a3.getName() +"\n");
		System.out.println("a3: " +a3.getEmail() +"\n");

		System.out.println("a1==a2: "+ a1.equals(a2));
	}*/
}