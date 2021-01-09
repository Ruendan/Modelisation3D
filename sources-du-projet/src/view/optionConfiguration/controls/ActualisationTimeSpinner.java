package view.optionConfiguration.controls;

import view.TimelineConstants;

public class ActualisationTimeSpinner extends ConfigurationSpinner {

	public ActualisationTimeSpinner() {
		super(TimelineConstants.getTempsdactualisation());
		this.valueProperty().addListener((observable, oldValue, newValue) -> TimelineConstants.setTempsdactualisation(newValue));
		this.setEditable(true);
	}

}
