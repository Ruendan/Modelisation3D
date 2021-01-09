package view.optionConfiguration.controls;

import javafx.scene.control.Spinner;

/**
 * Model for configuration spinners
 * <p>This class is used to be extended in each configuration spinners</p>
 * @author Groupe G1
 */
public abstract class ConfigurationSpinner extends Spinner<Double>{
	
	public ConfigurationSpinner(double defaultValue) {
		super(0,Double.MAX_VALUE, defaultValue, 0.01);
	}
}
