package view.optionConfiguration.controls;

import view.ButtonsUtils;

/**
 * Spinner for the configuration of Y's axis translation
 * @author Groupe G1
 */
public class TranslationYSpinner extends ConfigurationSpinner {

	public TranslationYSpinner() {
		super(ButtonsUtils.getValeurTranslation());
		this.valueProperty().addListener((observable, oldValue, newValue) -> ButtonsUtils.setValeurTranslation((double)newValue));
		this.setEditable(true);
	}

}
