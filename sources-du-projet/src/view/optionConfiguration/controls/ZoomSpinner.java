package view.optionConfiguration.controls;

import view.ButtonsConstants;

/**
 * Spinner for the configuration of zoom
 * @author Groupe G1
 */
public class ZoomSpinner extends ConfigurationSpinner {

	public ZoomSpinner() {
		super(ButtonsConstants.getValeurZoom());
		this.valueProperty().addListener((observable, oldValue, newValue) -> ButtonsConstants.setValeurZoom((double)newValue));
		this.setEditable(true);
	}

}
