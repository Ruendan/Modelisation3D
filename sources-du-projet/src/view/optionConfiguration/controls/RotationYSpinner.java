package view.optionConfiguration.controls;

import view.TimelineUtils;

/**
 * Spinner for the configuration of Y's axis rotation
 * @author Groupe G1
 */
public class RotationYSpinner extends ConfigurationSpinner {
	public RotationYSpinner() {
		super(TimelineUtils.getDefaulty());
		this.valueProperty().addListener((observable, oldValue, newValue) -> TimelineUtils.setYRotationValue((double)newValue));
		this.setEditable(true);
	}
}
