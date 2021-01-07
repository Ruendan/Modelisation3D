package view.scriptConfiguration;

import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ScriptConfigurationStage extends Stage{
	
	private static final String TITRE = "Configuration des Scripts Personnels";
	
	public ScriptConfigurationStage() {
		this.setTitle(TITRE);
		this.initModality(Modality.APPLICATION_MODAL);
		this.setScene(new Scene(new ScriptConfigurationLayout()));
		this.showAndWait();
	}
}
