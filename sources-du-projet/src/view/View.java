package view;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import modele.modelisation.Figure;
import view.buttons.Rotation;
import view.buttons.Translation;
import view.buttons.Zoom;

public class View extends Stage{
	
	public View(Figure fig) {
		//Buttons buttons = new Buttons(fig);
		
		Rotation buttons_rotation = new Rotation(fig);
		Translation buttons_translation = new Translation(fig);
		Zoom buttons_zoom = new Zoom(fig);
		
		
		Explorer modelsList = new Explorer();
		Group display = new GroupedVue(fig);
		HBox buttons = new HBox();
		buttons.getChildren().addAll(buttons_rotation, new VBox(buttons_translation,buttons_zoom));
		
		VBox right = new VBox(); right.setStyle("-fx-border-width: 2px; -fx-border-color: black;");
		right.getChildren().addAll(display, buttons);
		
		BorderPane bb = new BorderPane();		
		bb.setLeft(modelsList);
		bb.setRight(right);		
		
		
		Scene mainScene = new Scene(bb, 1000, 800);
		this.setScene(mainScene);
		this.setTitle("Visionneuse PLY 3D");
		this.show();
	}
}
