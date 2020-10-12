package view;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import modele.modelisation.Figure;

public class View extends Stage{
	
	public View(Figure fig) {
		HBox buttons = new Buttons();
		Label explorer = new Label("Explorer"); explorer.setStyle("-fx-border-width: 2px; -fx-border-color: black;");
		Group display = new GroupedVue(fig);
		
		VBox right = new VBox(); right.setStyle("-fx-border-width: 2px; -fx-border-color: black;");
		right.getChildren().addAll(display, buttons);
		
		BorderPane bb = new BorderPane();		
		bb.setLeft(explorer);
		bb.setRight(right);		
		
		
		Scene mainScene = new Scene(bb, 1000, 800);
		this.setScene(mainScene);
		this.show();
	}
}
