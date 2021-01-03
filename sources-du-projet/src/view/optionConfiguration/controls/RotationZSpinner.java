package view.optionConfiguration.controls;

import view.TimelineConst;

public class RotationZSpinner extends ConfigurationSpinner {
	public RotationZSpinner() {
		super(TimelineConst.getDefaultz());
		this.valueProperty().addListener((observable, oldValue, newValue) -> TimelineConst.setZRotationValue((double)newValue));
		this.setEditable(true);
	}
}
