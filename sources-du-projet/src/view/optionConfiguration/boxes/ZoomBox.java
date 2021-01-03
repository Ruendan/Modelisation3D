package view.optionConfiguration.boxes;

import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import view.optionConfiguration.controls.ZoomSpinner;

public class ZoomBox extends ConfigurationHBox {
	
	public ZoomBox() {
		this.spinner = new ZoomSpinner();
		this.label = new Label("Valeur de Zoom : ");
		this.getChildren().addAll(label, spinner);
		spinner.setMaxWidth(Double.MAX_VALUE);
		HBox.setHgrow(spinner, Priority.ALWAYS);
	}
}
