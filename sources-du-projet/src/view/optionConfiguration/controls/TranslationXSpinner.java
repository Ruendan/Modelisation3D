package view.optionConfiguration.controls;

import view.ButtonsUtils;

/**
 * Spinner for the configuration of X's axis translation
 * @author Groupe G1
 */
public class TranslationXSpinner extends ConfigurationSpinner {

	public TranslationXSpinner() {
		super(ButtonsUtils.getValeurTranslation());
		this.valueProperty().addListener((observable, oldValue, newValue) -> ButtonsUtils.setValeurTranslation((double)newValue));
		this.setEditable(true);
	}

}
