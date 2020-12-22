package view.optionConfiguration.optionConfigurationControls;

import view.ButtonsConst;

public class TranslationYSpinner extends ConfigurationSpinner {

	public TranslationYSpinner() {
		super(ButtonsConst.getVALEUR_DE_DEPLACEMENT_Y());
		this.valueProperty().addListener((observable, oldValue, newValue) -> ButtonsConst.setVALEUR_DE_DEPLACEMENT_Y((double)newValue));
		this.setEditable(true);
	}

}
