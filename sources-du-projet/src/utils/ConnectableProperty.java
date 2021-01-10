package utils;

/**
 * Extendable class to convert a property into a Connectable Property
 * <p>This class is used to convert any property into a Connectable Property from the Observer Pattern</p>
 * @author Groupe G1
 */
public class ConnectableProperty extends ObservableProperty implements Observer {

	protected boolean propagating;

	public ConnectableProperty() {
		propagating = false;
	}

	public void connectTo(ConnectableProperty other) {
		other.attach(this);
	}

	public void biconnectTo(ConnectableProperty other) {
		connectTo(other);
		update(other, other.getValue());
		other.connectTo(this);
	}

	public void unconnectFrom(ConnectableProperty other) {
		other.detach(this);
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object val) {
		if (! propagating) {
			propagating = true;
			super.setValue(val);
			propagating = false;
		}
	}

	@Override
	public void update(Subject subj) {
		// never called so does not do anything
	}

	@Override
	public void update(Subject other, Object data) {
		setValue(data);
	}

}
