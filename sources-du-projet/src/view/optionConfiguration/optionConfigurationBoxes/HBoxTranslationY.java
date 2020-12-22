package view.optionConfiguration.optionConfigurationBoxes;

import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import view.optionConfiguration.optionConfigurationControls.TranslationYSpinner;

public class HBoxTranslationY extends ConfigurationHBox {
	public HBoxTranslationY() {
		this.spinner = new TranslationYSpinner();
		this.label = new Label("Translation sur Y : ");
		this.getChildren().addAll(label, spinner);
		spinner.setMaxWidth(Double.MAX_VALUE);
		HBox.setHgrow(spinner, Priority.ALWAYS);
	}
}
