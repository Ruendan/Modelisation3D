package view.explorer;

/**
 * Creation of the option button
 * <p>This class is used to create option button that opens the options of moving, rotation and auto-rotate</p>
 * @author Groupe G1
 */
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import utils.Icon;
import view.optionConfiguration.OptionConfigurationStage;

public class OptionButton extends Button{
	
	/**
	 * Create the option button
	 */
	public OptionButton() {
		super("",Icon.createButtonIcon("settings"));
		Tooltip.install(this, new Tooltip("Configuration"));
		this.setOnAction(e -> openNewWindow());
	}
	/**
	 * Open the options window
	 */
	private void openNewWindow() {
		new OptionConfigurationStage();
	}
}
