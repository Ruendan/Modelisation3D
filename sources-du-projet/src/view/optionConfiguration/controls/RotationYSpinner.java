package view.optionConfiguration.controls;

import view.TimelineConstants;

public class RotationYSpinner extends ConfigurationSpinner {
	public RotationYSpinner() {
		super(TimelineConstants.getDefaulty());
		this.valueProperty().addListener((observable, oldValue, newValue) -> TimelineConstants.setYRotationValue((double)newValue));
		this.setEditable(true);
	}
}
