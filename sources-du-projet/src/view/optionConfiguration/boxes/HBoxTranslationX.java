package view.optionConfiguration.boxes;

import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import view.optionConfiguration.controls.TranslationXSpinner;

public class HBoxTranslationX extends ConfigurationHBox {
	public HBoxTranslationX() {
		this.spinner = new TranslationXSpinner();
		this.label = new Label("Translation sur X : ");
		this.getChildren().addAll(label, spinner);
		spinner.setMaxWidth(Double.MAX_VALUE);
		HBox.setHgrow(spinner, Priority.ALWAYS);
	}
}
