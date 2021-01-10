package view.optionConfiguration.controls;

import view.TimelineUtils;

/**
 * Spinner for the configuration of X's axis rotation
 * @author Groupe G1
 */
public class RotationXSpinner extends ConfigurationSpinner {
	public RotationXSpinner() {
		super(TimelineUtils.getDefaultx());
		this.valueProperty().addListener((observable, oldValue, newValue) -> TimelineUtils.setXRotationValue((double)newValue));
		this.setEditable(true);
	}
}
