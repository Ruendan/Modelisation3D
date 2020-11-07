package view;

import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import modele.modelisation.Figure;

public class View extends Stage{
	
	public View(Figure fig) {
		Buttons buttons = new Buttons(fig);
		Explorer models = new Explorer();
		Canvas display = new GroupedVue(fig,500.0,500.0);
		
		VBox right = new VBox(); right.setStyle("-fx-border-width: 2px; -fx-border-color: black;");
		right.getChildren().addAll(display, buttons);
		
		BorderPane bb = new BorderPane();		
		bb.setLeft(models);
		bb.setRight(right);		
		
		
		Scene mainScene = new Scene(bb, 1000, 800);
		this.setScene(mainScene);
		this.setTitle("Visionneuse PLY 3D");
		this.show();
	}
}
