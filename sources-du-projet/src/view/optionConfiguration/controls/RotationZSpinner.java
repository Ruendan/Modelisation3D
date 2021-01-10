package view.optionConfiguration.controls;

import view.OurTimeline;

/**
 * Spinner for the configuration of Z's axis rotation
 * @author Groupe G1
 */
public class RotationZSpinner extends ConfigurationSpinner {
	public RotationZSpinner() {
		super(OurTimeline.getDefaultz());
		this.valueProperty().addListener((observable, oldValue, newValue) -> OurTimeline.setZRotationValue((double)newValue));
		this.setEditable(true);
	}
}
