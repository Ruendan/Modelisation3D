package view.optionConfiguration.controls;

import view.TimelineUtils;

/**
 * Spinner for the configuration of auto-rotate speed
 * @author Groupe G1
 */
public class ActualisationTimeSpinner extends ConfigurationSpinner {

	public ActualisationTimeSpinner() {
		super(TimelineUtils.getTempsdactualisation());
		this.valueProperty().addListener((observable, oldValue, newValue) -> TimelineUtils.setTempsdactualisation(newValue));
		this.setEditable(true);
	}

}
