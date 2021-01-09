package utils;


public class ObservableProperty extends Subject {

	protected Object value;

	public ObservableProperty() {
		super();
		value = new Object();
	}
	
	public Object getValue() {
		return value;
	}

	public void setValue(Object val) {
		value = val;
		notifyObservers(val);
	}
}
