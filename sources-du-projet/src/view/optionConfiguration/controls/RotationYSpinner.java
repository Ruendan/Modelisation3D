package view.optionConfiguration.controls;

import view.OurTimeline;

public class RotationYSpinner extends ConfigurationSpinner {
	public RotationYSpinner() {
		super(OurTimeline.getDefaulty());
		this.valueProperty().addListener((observable, oldValue, newValue) -> OurTimeline.setYRotationValue((double)newValue));
		this.setEditable(true);
	}
}
