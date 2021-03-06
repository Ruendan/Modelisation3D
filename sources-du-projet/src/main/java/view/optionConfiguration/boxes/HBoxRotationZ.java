package view.optionConfiguration.boxes;

import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import view.optionConfiguration.controls.RotationZSpinner;

/**
 * Label and field for the configuration of Z's axis rotation
 * @author Groupe G1
 */
public class HBoxRotationZ extends ConfigurationHBox {
	
	public HBoxRotationZ() {
		super();
		this.spinner = new RotationZSpinner();
		this.label = new Label("Rotation sur Z (Mode Auto): ");
		this.getChildren().addAll(label, spinner);
		spinner.setMaxWidth(Double.MAX_VALUE);
		HBox.setHgrow(spinner, Priority.ALWAYS);
	}
}
