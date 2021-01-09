package view.optionConfiguration.controls;

import view.TimelineAttributes;

/**
 * Spinner for the configuration of Z's axis rotation
 * @author Groupe G1
 */
public class RotationZSpinner extends ConfigurationSpinner {
	public RotationZSpinner() {
		super(TimelineAttributes.getDefaultz());
		this.valueProperty().addListener((observable, oldValue, newValue) -> TimelineAttributes.setZRotationValue((double)newValue));
		this.setEditable(true);
	}
}
