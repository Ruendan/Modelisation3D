package view.optionConfiguration.boxes;

import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import view.optionConfiguration.controls.ConfigurationSpinner;

/**
 * Model for configuration boxes
 * <p>This class is used to be extended in each configuration boxes</p>
 * @author Groupe G1
 */
public abstract class ConfigurationHBox extends HBox {
	
	protected ConfigurationSpinner spinner;
	protected Label label;
	
}
