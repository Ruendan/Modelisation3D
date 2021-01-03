package view.errors;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ErrorScene {
	
	public static void display(Exception e) {
		Stage s = new Stage();
		s.setTitle("Erreur : " + e.getMessage());
		s.initModality(Modality.APPLICATION_MODAL);
		
		HBox layout = new HBox();
		layout.getChildren().add(new Label(e.toString()));
		
		
		s.setScene(new Scene(layout));
		s.showAndWait();
	}
}
