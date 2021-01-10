package view.optionConfiguration.controls;

import view.OurTimeline;

public class RotationZSpinner extends ConfigurationSpinner {
	public RotationZSpinner() {
		super(OurTimeline.getDefaultz());
		this.valueProperty().addListener((observable, oldValue, newValue) -> OurTimeline.setZRotationValue((double)newValue));
		this.setEditable(true);
	}
}
