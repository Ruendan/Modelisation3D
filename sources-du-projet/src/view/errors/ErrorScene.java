package view.errors;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import view.ButtonsAttributes;

/**
 * Display errors that occur
 * <p>This class is used to show a new stage with any error that can occur</p>
 * @author Groupe G1
 */
public class ErrorScene {
	
	/**
	 * Create the stage showing the error
	 * @param e
	 * 			The {@link Exception} to be displayed
	 */
	public static void display(Exception e) {
		Stage s = new Stage();
		s.setTitle("Erreur : " + e.getMessage());
		s.initModality(Modality.APPLICATION_MODAL);
		
		Label message = new Label(e.toString());
		message.setPadding(new Insets(10,20,10,20));
		message.setStyle("-fx-text-fill: red;");
		
		VBox layout = new VBox();
		layout.setPadding(new Insets(10));
		layout.getChildren().addAll(message);
		layout.setAlignment(Pos.CENTER);

		s.setScene(new Scene(layout));
		s.showAndWait();
	}
}
