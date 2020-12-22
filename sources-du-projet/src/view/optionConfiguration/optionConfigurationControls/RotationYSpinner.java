package view.optionConfiguration.optionConfigurationControls;

import view.TimelineConst;

public class RotationYSpinner extends ConfigurationSpinner {
	public RotationYSpinner() {
		super(TimelineConst.getDefaulty());
		this.valueProperty().addListener((observable, oldValue, newValue) -> TimelineConst.setYRotationValue((double)newValue));
		this.setEditable(true);
	}
}
