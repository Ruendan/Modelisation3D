package view.optionConfiguration;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;
import view.View;

/**
 * Creation of the option button
 * <p>This class is used to create option button that opens the options of moving, rotation and auto-rotate</p>
 * @author Groupe G1
 */
public class OptionConfigurationStage extends Stage{
	
	private static final String TITRE = "Configuration de la rotation";
	
	/**
	 * Creation of the stage that contains all the configuration options
	 */
	public OptionConfigurationStage() {
		super();
		this.setTitle(TITRE);
		this.initModality(Modality.APPLICATION_MODAL);
		this.setScene(new Scene(new OptionConfigurationLayout()));
		this.getIcons().add(new Image("file:"+View.ICONPATH));
		this.showAndWait();
	}
}
