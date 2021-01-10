package view.explorer;

import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import utils.IconConstants;
import view.optionConfiguration.OptionConfigurationStage;

/**
 * Creation of the option button
 * <p>This class is used to create option button that opens the options of moving, rotation and auto-rotate</p>
 * @author Groupe G1
 */
public class OptionButton extends Button{
	
	/**
	 * Create the option button
	 */
	public OptionButton() {
		super("",IconConstants.createButtonIcon("settings"));
		Tooltip.install(this, new Tooltip("Options"));
		this.setOnAction(e -> openNewWindow());
	}
	
	/**
	 * Open the options window
	 */
	private void openNewWindow() {
		new OptionConfigurationStage();
	}
}
