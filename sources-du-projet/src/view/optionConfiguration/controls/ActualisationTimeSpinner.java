package view.optionConfiguration.controls;

import view.TimelineConst;

public class ActualisationTimeSpinner extends ConfigurationSpinner {

	public ActualisationTimeSpinner() {
		super(TimelineConst.getTempsdactualisation());
		this.valueProperty().addListener((observable, oldValue, newValue) -> TimelineConst.setTempsdactualisation(newValue));
		this.setEditable(true);
	}

}
