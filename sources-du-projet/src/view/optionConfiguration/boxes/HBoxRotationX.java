package view.optionConfiguration.boxes;

import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import view.optionConfiguration.controls.RotationXSpinner;

/**
 * Label and field for the configuration of X's axis rotation
 * @author Groupe G1
 */
public class HBoxRotationX extends ConfigurationHBox {
	
	public HBoxRotationX() {
		this.spinner = new RotationXSpinner();
		this.label = new Label("Rotation sur X (Mode Auto): ");
		this.getChildren().addAll(label, spinner);
		spinner.setMaxWidth(Double.MAX_VALUE);
		HBox.setHgrow(spinner, Priority.ALWAYS);
	}
}
