package view.scriptConfiguration;

import javafx.scene.control.Button;
import view.scriptConfiguration.scriptCreation.CreateNewScriptStage;

public class CreateScriptButton extends Button{
	
	private static final String BUTTONTEXT = "Creer un Nouveau Script";
	
	public CreateScriptButton() {
		this.setText(BUTTONTEXT);
		this.setOnAction(e -> new CreateNewScriptStage().showAndWait());
	}
}
