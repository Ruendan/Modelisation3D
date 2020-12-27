package view.optionConfiguration.controls;

import javafx.scene.control.Spinner;

public abstract class ConfigurationSpinner extends Spinner<Double>{
	
	public ConfigurationSpinner(double defaultValue) {
		super(0,Double.MAX_VALUE, defaultValue);
	}
}
