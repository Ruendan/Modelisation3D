package view.optionConfiguration.controls;

import view.TimelineAttributes;

/**
 * Spinner for the configuration of X's axis rotation
 * @author Groupe G1
 */
public class RotationXSpinner extends ConfigurationSpinner {
	public RotationXSpinner() {
		super(TimelineAttributes.getDefaultx());
		this.valueProperty().addListener((observable, oldValue, newValue) -> TimelineAttributes.setXRotationValue((double)newValue));
		this.setEditable(true);
	}
}
