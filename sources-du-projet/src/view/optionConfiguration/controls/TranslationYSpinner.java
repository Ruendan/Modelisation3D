package view.optionConfiguration.controls;

import view.ButtonsAttributes;

/**
 * Spinner for the configuration of Y's axis translation
 * @author Groupe G1
 */
public class TranslationYSpinner extends ConfigurationSpinner {

	public TranslationYSpinner() {
		super(ButtonsAttributes.getVALEUR_DE_DEPLACEMENT_Y());
		this.valueProperty().addListener((observable, oldValue, newValue) -> ButtonsAttributes.setVALEUR_DE_DEPLACEMENT_Y((double)newValue));
		this.setEditable(true);
	}

}
