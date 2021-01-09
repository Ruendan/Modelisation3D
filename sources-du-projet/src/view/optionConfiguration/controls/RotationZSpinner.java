package view.optionConfiguration.controls;

import view.TimelineConstants;

public class RotationZSpinner extends ConfigurationSpinner {
	public RotationZSpinner() {
		super(TimelineConstants.getDefaultz());
		this.valueProperty().addListener((observable, oldValue, newValue) -> TimelineConstants.setZRotationValue((double)newValue));
		this.setEditable(true);
	}
}
