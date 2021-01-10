package view.optionConfiguration.controls;

import view.OurTimeline;

/**
 * Spinner for the configuration of Y's axis rotation
 * @author Groupe G1
 */
public class RotationYSpinner extends ConfigurationSpinner {
	public RotationYSpinner() {
		super(OurTimeline.getDefaulty());
		this.valueProperty().addListener((observable, oldValue, newValue) -> OurTimeline.setYRotationValue((double)newValue));
		this.setEditable(true);
	}
}
