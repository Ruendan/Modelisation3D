package view.optionConfiguration.boxes;

import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import view.optionConfiguration.controls.RotationYSpinner;

public class HBoxRotationY extends ConfigurationHBox{
	
	public HBoxRotationY() {
		super();
		this.spinner = new RotationYSpinner();
		this.label = new Label("Rotation sur Y (Mode Auto): ");
		this.getChildren().addAll(label, spinner);
		spinner.setMaxWidth(Double.MAX_VALUE);
		HBox.setHgrow(spinner, Priority.ALWAYS);
	}
}
