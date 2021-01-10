package view.optionConfiguration.controls;

import view.ButtonsConstants;

/**
 * Spinner for the configuration of Y's axis translation
 * @author Groupe G1
 */
public class TranslationYSpinner extends ConfigurationSpinner {

	public TranslationYSpinner() {
		super(ButtonsConstants.getValeurTranslation());
		this.valueProperty().addListener((observable, oldValue, newValue) -> ButtonsConstants.setValeurTranslation((double)newValue));
		this.setEditable(true);
	}

}
