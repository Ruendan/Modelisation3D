package view.optionConfiguration.controls;

import view.ButtonsConstants;

/**
 * Spinner for the configuration of X's axis translation
 * @author Groupe G1
 */
public class TranslationXSpinner extends ConfigurationSpinner {

	public TranslationXSpinner() {
		super(ButtonsConstants.getValeurTranslation());
		this.valueProperty().addListener((observable, oldValue, newValue) -> ButtonsConstants.setValeurTranslation((double)newValue));
		this.setEditable(true);
	}

}
