package view.explorer;

import javafx.scene.control.Button;
import view.optionConfiguration.OptionConfigurationStage;

public class OptionButton extends Button{
	public OptionButton() {
		super("Configure");
		this.setOnAction(e -> openNewWindow());
	}
	
	private void openNewWindow() {
		new OptionConfigurationStage();
	}
}
