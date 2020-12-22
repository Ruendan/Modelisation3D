package view.optionConfiguration.controls;

import view.ButtonsConst;

public class TranslationXSpinner extends ConfigurationSpinner {

	public TranslationXSpinner() {
		super(ButtonsConst.getVALEUR_DE_DEPLACEMENT_X());
		this.valueProperty().addListener((observable, oldValue, newValue) -> ButtonsConst.setVALEUR_DE_DEPLACEMENT_X((double)newValue));
		this.setEditable(true);
	}

}
