package view.explorer;

import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import utils.Icon;
import view.scriptConfiguration.ScriptConfigurationStage;

public class ScriptButton extends Button {
	public ScriptButton() {
		super("",Icon.createButtonIcon("settings"));
		Tooltip.install(this, new Tooltip("Script"));
		this.setOnAction(e -> openScriptConfigurationWindow());
	}
	
	private void openScriptConfigurationWindow() {
		new ScriptConfigurationStage();
	}
}
