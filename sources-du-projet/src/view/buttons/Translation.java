package view.buttons;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import modele.modelisation.Figure;

public class Translation extends VBox{
	
	private Button up,down,left,right;
	
	private static final int VALEUR_DE_DEPLACEMENT = 10;
	
	public Translation(Figure fig){
		
		this.up = new Button("↑");
		this.down = new Button("↓");
		
		this.left = new Button("←");
		this.right = new Button("→");		
		
		this.getChildren().addAll(new Label("Translation"),new HBox(up,down), new HBox(left,right));
		this.setStyle("-fx-border-width: 2px; -fx-border-color: red;");
	}
}

