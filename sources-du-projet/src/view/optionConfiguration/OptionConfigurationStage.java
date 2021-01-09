package view.optionConfiguration;

import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class OptionConfigurationStage extends Stage{
	
	private static final String TITRE = "Configuration de la rotation";
	
	public OptionConfigurationStage() {
		super();
		this.setTitle(TITRE);
		this.initModality(Modality.APPLICATION_MODAL);
		this.setScene(new Scene(new OptionConfigurationLayout()));
		this.showAndWait();
	}
}
