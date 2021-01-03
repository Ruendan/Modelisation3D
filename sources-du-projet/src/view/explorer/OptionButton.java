package view.explorer;

import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import utils.Icon;
import view.optionConfiguration.OptionConfigurationStage;

public class OptionButton extends Button{
	
	public OptionButton() {
		super("",Icon.createButtonIcon("settings"));
		Tooltip.install(this, new Tooltip("Options"));
		this.setOnAction(e -> openNewWindow());
	}
	
	private void openNewWindow() {
		new OptionConfigurationStage();
	}
}
