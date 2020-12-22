package view.optionConfiguration.optionConfigurationBoxes;

import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import view.optionConfiguration.optionConfigurationControls.RotationYSpinner;

public class HBoxRotationY extends ConfigurationHBox{
	
	public HBoxRotationY() {
		this.spinner = new RotationYSpinner();
		this.label = new Label("Rotation sur Y (Mode Auto): ");
		this.getChildren().addAll(label, spinner);
		spinner.setMaxWidth(Double.MAX_VALUE);
		HBox.setHgrow(spinner, Priority.ALWAYS);
	}
}
