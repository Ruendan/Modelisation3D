package view.optionConfiguration.optionConfigurationControls;

import view.TimelineConst;

public class RotationXSpinner extends ConfigurationSpinner {
	public RotationXSpinner() {
		super(TimelineConst.getDefaultx());
		this.valueProperty().addListener((observable, oldValue, newValue) -> TimelineConst.setXRotationValue((double)newValue));
		this.setEditable(true);
	}
}
