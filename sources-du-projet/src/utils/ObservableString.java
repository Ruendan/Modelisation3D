package utils;

/**
 * Extendable class to convert a String into a Subject
 * <p>This class is used to convert any String into a Subject from the Observer Pattern</p>
 * @author Groupe G1
 */
public class ObservableString extends Subject {
	
	private String text;
	
	public ObservableString() {
		super();
	}
	
	public void setText(String text) {
		this.text = text;
	}
	
	public String getText() {
		return text;
	}
	
}
