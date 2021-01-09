package view.optionConfiguration.controls;

import view.ButtonsAttributes;

/**
 * Spinner for the configuration of X's axis translation
 * @author Groupe G1
 */
public class TranslationXSpinner extends ConfigurationSpinner {

	public TranslationXSpinner() {
		super(ButtonsAttributes.getVALEUR_DE_DEPLACEMENT_X());
		this.valueProperty().addListener((observable, oldValue, newValue) -> ButtonsAttributes.setVALEUR_DE_DEPLACEMENT_X((double)newValue));
		this.setEditable(true);
	}

}
