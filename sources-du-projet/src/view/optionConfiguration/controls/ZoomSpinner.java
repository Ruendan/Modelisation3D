package view.optionConfiguration.controls;

import view.ButtonsUtils;

/**
 * Spinner for the configuration of zoom
 * @author Groupe G1
 */
public class ZoomSpinner extends ConfigurationSpinner {

	public ZoomSpinner() {
		super(ButtonsUtils.getValeurZoom());
		this.valueProperty().addListener((observable, oldValue, newValue) -> ButtonsUtils.setValeurZoom((double)newValue));
		this.setEditable(true);
	}

}
