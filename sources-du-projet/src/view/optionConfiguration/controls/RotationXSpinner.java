package view.optionConfiguration.controls;

import view.OurTimeline;

/**
 * Spinner for the configuration of X's axis rotation
 * @author Groupe G1
 */
public class RotationXSpinner extends ConfigurationSpinner {
	public RotationXSpinner() {
		super(OurTimeline.getDefaultx());
		this.valueProperty().addListener((observable, oldValue, newValue) -> OurTimeline.setXRotationValue((double)newValue));
		this.setEditable(true);
	}
}
