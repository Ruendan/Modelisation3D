package view.optionConfiguration.optionConfigurationControls;

import view.ButtonsConst;

public class ZoomSpinner extends ConfigurationSpinner {

	public ZoomSpinner() {
		super(ButtonsConst.getVALEUR_DE_ZOOM());
		this.valueProperty().addListener((observable, oldValue, newValue) -> ButtonsConst.setVALEUR_DE_ZOOM((double)newValue));
		this.setEditable(true);
	}

}
