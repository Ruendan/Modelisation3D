package view.optionConfiguration.controls;

import view.TimelineAttributes;

/**
 * Spinner for the configuration of Y's axis rotation
 * @author Groupe G1
 */
public class RotationYSpinner extends ConfigurationSpinner {
	public RotationYSpinner() {
		super(TimelineAttributes.getDefaulty());
		this.valueProperty().addListener((observable, oldValue, newValue) -> TimelineAttributes.setYRotationValue((double)newValue));
		this.setEditable(true);
	}
}
