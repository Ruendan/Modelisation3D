package view.buttons;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.BooleanPropertyBase;
import javafx.collections.ObservableList;
import javafx.css.PseudoClass;
import javafx.event.ActionEvent;
import javafx.scene.control.Labeled;
import javafx.scene.control.Skin;

public class ToggleSwitch extends Labeled {

	private static final String DEFAULT_STYLE_CLASS = "toggle-switch";
	
	private static final PseudoClass PSEUDO_CLASS_SELECTED =
			PseudoClass.getPseudoClass("selected");
	
	private BooleanProperty value;
	
	public ToggleSwitch() {
		super();
		init();
	}
	
	public ToggleSwitch(String label) {
		super(label);
		init();
	}

	private void init() {
		getStyleClass().setAll(DEFAULT_STYLE_CLASS);
	}
	
	public final void setValue(boolean value) {
		selectedProperty().set(value);
	}
	
	public final boolean isToggle() {
		return value == null ? false : value.get();
	}
	
	public final BooleanProperty selectedProperty() {
		if(value == null) {
			value = new BooleanPropertyBase() {
				@Override protected void invalidated() {
					final Boolean val = get();
					pseudoClassStateChanged(PSEUDO_CLASS_SELECTED, val);
				}

				@Override
				public Object getBean() {
					return ToggleSwitch.this;
				}

				@Override
				public String getName() {
					return "selected";
				}
			};
		}
		return value;
	}
	
	public void fire() {
		if (!isDisabled()) {
			setValue(!isToggle());
			fireEvent(new ActionEvent());
		}
	}
	
	@Override protected Skin<?> createDefaultSkin() {
		return new ToggleSwitchSkin(this);
	}
	
	@Override
    public String getUserAgentStylesheet() {
        return ToggleSwitch.class.getResource("toggleswitch.css").toExternalForm();
    }
	
}
