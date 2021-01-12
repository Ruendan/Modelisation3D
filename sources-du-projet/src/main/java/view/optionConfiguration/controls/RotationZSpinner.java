package view.optionConfiguration.controls;

import view.TimelineUtils;

/**
 * Spinner for the configuration of Z's axis rotation
 * @author Groupe G1
 */
public class RotationZSpinner extends ConfigurationSpinner {
	public RotationZSpinner() {
		super(TimelineUtils.getDefaultz());
		this.valueProperty().addListener((observable, oldValue, newValue) -> TimelineUtils.setZRotationValue((double)newValue));
		this.setEditable(true);
	}
}
