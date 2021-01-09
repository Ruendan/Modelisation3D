package view.explorer;

import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import utils.IconConstants;
import view.optionConfiguration.OptionConfigurationStage;

public class OptionButton extends Button{
	
	public OptionButton() {
		super("",IconConstants.createButtonIcon("settings"));
		Tooltip.install(this, new Tooltip("Options"));
		this.setOnAction(e -> openNewWindow());
	}
	
	private void openNewWindow() {
		new OptionConfigurationStage();
	}
}
