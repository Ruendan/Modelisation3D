package view.optionConfiguration.controls;

import view.OurTimeline;

/**
 * Spinner for the configuration of auto-rotate speed
 * @author Groupe G1
 */
public class ActualisationTimeSpinner extends ConfigurationSpinner {

	public ActualisationTimeSpinner() {
		super(OurTimeline.getTempsdactualisation());
		this.valueProperty().addListener((observable, oldValue, newValue) -> OurTimeline.setTempsdactualisation(newValue));
		this.setEditable(true);
	}

}
