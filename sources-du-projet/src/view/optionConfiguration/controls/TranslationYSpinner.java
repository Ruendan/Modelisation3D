package view.optionConfiguration.controls;

import view.ButtonsConstants;

public class TranslationYSpinner extends ConfigurationSpinner {

	public TranslationYSpinner() {
		super(ButtonsConstants.getValeurTranslation());
		this.valueProperty().addListener((observable, oldValue, newValue) -> ButtonsConstants.setValeurTranslation((double)newValue));
		this.setEditable(true);
	}

}
