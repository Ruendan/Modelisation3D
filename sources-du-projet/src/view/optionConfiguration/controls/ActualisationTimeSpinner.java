package view.optionConfiguration.controls;

import view.OurTimeline;

public class ActualisationTimeSpinner extends ConfigurationSpinner {

	public ActualisationTimeSpinner() {
		super(OurTimeline.getTempsdactualisation());
		this.valueProperty().addListener((observable, oldValue, newValue) -> OurTimeline.setTempsdactualisation(newValue));
		this.setEditable(true);
	}

}
