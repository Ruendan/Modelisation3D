package view.optionConfiguration.controls;

import view.TimelineAttributes;

/**
 * Spinner for the configuration of auto-rotate speed
 * @author Groupe G1
 */
public class ActualisationTimeSpinner extends ConfigurationSpinner {

	public ActualisationTimeSpinner() {
		super(TimelineAttributes.getTempsdactualisation());
		this.valueProperty().addListener((observable, oldValue, newValue) -> TimelineAttributes.setTempsdactualisation(newValue));
		this.setEditable(true);
	}

}
