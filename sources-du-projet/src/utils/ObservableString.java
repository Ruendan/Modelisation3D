package utils;


public class ObservableString extends Subject {
	
	private String text;
	
	public ObservableString() {
		super();
		text = "";
	}
	
	public void setText(String text) {
		this.text = text;
	}
	
	public String getText() {
		return text;
	}
	
}
