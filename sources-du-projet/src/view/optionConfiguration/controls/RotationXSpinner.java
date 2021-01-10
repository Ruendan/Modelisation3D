package view.optionConfiguration.controls;

import view.OurTimeline;

public class RotationXSpinner extends ConfigurationSpinner {
	public RotationXSpinner() {
		super(OurTimeline.getDefaultx());
		this.valueProperty().addListener((observable, oldValue, newValue) -> OurTimeline.setXRotationValue((double)newValue));
		this.setEditable(true);
	}
}
