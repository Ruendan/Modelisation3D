package view.optionConfiguration.boxes;

import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import view.optionConfiguration.controls.TranslationYSpinner;

/**
 * Label and field for the configuration of Y's axis translation
 * @author Groupe G1
 */
public class HBoxTranslationY extends ConfigurationHBox {
	
	public HBoxTranslationY() {
		super();
		this.spinner = new TranslationYSpinner();
		this.label = new Label("Translation sur Y : ");
		this.getChildren().addAll(label, spinner);
		spinner.setMaxWidth(Double.MAX_VALUE);
		HBox.setHgrow(spinner, Priority.ALWAYS);
	}
}
