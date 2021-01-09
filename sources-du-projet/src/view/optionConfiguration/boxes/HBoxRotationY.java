package view.optionConfiguration.boxes;

import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import view.optionConfiguration.controls.RotationYSpinner;

/**
 * Label and field for the configuration of Y's axis rotation
 * @author Groupe G1
 */
public class HBoxRotationY extends ConfigurationHBox{
	
	public HBoxRotationY() {
		this.spinner = new RotationYSpinner();
		this.label = new Label("Rotation sur Y (Mode Auto): ");
		this.getChildren().addAll(label, spinner);
		spinner.setMaxWidth(Double.MAX_VALUE);
		HBox.setHgrow(spinner, Priority.ALWAYS);
	}
}
