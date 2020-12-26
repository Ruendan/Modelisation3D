package view.explorer;

import javafx.scene.control.Button;
import utils.Icon;
import view.optionConfiguration.OptionConfigurationStage;

public class OptionButton extends Button{
	public OptionButton() {
		super("",Icon.createButtonIcon("settings"));
		this.setOnAction(e -> openNewWindow());
	}
	
	private void openNewWindow() {
		new OptionConfigurationStage();
	}
}
