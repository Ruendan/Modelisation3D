package view.optionConfiguration.controls;

import view.TimelineConstants;

public class RotationXSpinner extends ConfigurationSpinner {
	public RotationXSpinner() {
		super(TimelineConstants.getDefaultx());
		this.valueProperty().addListener((observable, oldValue, newValue) -> TimelineConstants.setXRotationValue((double)newValue));
		this.setEditable(true);
	}
}
