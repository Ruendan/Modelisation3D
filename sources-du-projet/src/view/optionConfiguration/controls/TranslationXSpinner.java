package view.optionConfiguration.controls;

import view.ButtonsConstants;

public class TranslationXSpinner extends ConfigurationSpinner {

	public TranslationXSpinner() {
		super(ButtonsConstants.getValeurTranslation());
		this.valueProperty().addListener((observable, oldValue, newValue) -> ButtonsConstants.setValeurTranslation((double)newValue));
		this.setEditable(true);
	}

}
