package utils;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * Display errors that occur
 * <p>This class is used to show a new stage with any error that can occur</p>
 * @author Groupe G1
 */
public class ErrorSceneUtils {
	
	/**
	 * Create the stage showing the error
	 * @param e
	 * 			The {@link Exception} to be displayed
	 */
	public static void display(Exception e) {
		final Stage s = new Stage();
		s.setTitle("Erreur : " + e.getMessage());
		s.initModality(Modality.APPLICATION_MODAL);
		
		final HBox layout = new HBox();
		layout.getChildren().add(new Label(e.toString()));
		
		
		s.setScene(new Scene(layout));
		s.showAndWait();
	}
}
