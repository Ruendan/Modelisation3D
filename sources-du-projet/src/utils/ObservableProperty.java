package utils;

/**
 * Extendable class to convert a property into a Subject
 * <p>This class is used to convert any property into a Subject from the Observer Pattern</p>
 * @author Groupe G1
 */
public class ObservableProperty extends Subject {

	protected Object value;

	public Object getValue() {
		return value;
	}

	public void setValue(Object val) {
		value = val;
		notifyObservers(val);
	}
}
