public abstract class TextElement {

	private String _key;

	public String getKey() {
		return _key; 
	}

	public void setKey(String key) {
		_key= key;
	}

	protected boolean isIndexed() {}

	public abstract String getContent() {}

	public abstract int getSize() {}

}