package view.optionConfiguration.boxes;

import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import view.optionConfiguration.controls.ActualisationTimeSpinner;

/**
 * Label and field for the configuration of auto-rotate speed
 * @author Groupe G1
 */
public class HBoxActualisationTime extends ConfigurationHBox {
	
	public HBoxActualisationTime() {
		super();
		this.spinner = new ActualisationTimeSpinner();
		this.label = new Label("Vitesse de rotation (mode auto) : ");
		this.getChildren().addAll(label, spinner);
		spinner.setMaxWidth(Double.MAX_VALUE);
		HBox.setHgrow(spinner, Priority.ALWAYS);
	}
}
