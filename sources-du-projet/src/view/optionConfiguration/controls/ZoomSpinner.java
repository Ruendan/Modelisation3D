package view.optionConfiguration.controls;

import view.ButtonsAttributes;

/**
 * Spinner for the configuration of zoom
 * @author Groupe G1
 */
public class ZoomSpinner extends ConfigurationSpinner {

	public ZoomSpinner() {
		super(ButtonsAttributes.getVALEUR_DE_ZOOM());
		this.valueProperty().addListener((observable, oldValue, newValue) -> ButtonsAttributes.setVALEUR_DE_ZOOM((double)newValue));
		this.setEditable(true);
	}

}
