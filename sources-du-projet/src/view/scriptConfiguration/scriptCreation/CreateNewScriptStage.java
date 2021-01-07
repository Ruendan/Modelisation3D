package view.scriptConfiguration.scriptCreation;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class CreateNewScriptStage extends Stage{
	
	public CreateNewScriptStage() {
		CreateNewScriptLayout layout = new CreateNewScriptLayout();
		this.setScene(new Scene(layout));
	}
}
