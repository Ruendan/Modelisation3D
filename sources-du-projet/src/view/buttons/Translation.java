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
		up.setOnAction(e->{
			fig.VDeplace(VALEUR_DE_DEPLACEMENT);;
		});
		
		this.down = new Button("↓");
		down.setOnAction(e->{
			fig.VDeplace(-VALEUR_DE_DEPLACEMENT);
		});
		
		this.left = new Button("←");
		left.setOnAction(e->{
			fig.HDeplace(VALEUR_DE_DEPLACEMENT);
		});
		
		this.right = new Button("→");	
		right.setOnAction(e->{
			fig.HDeplace(-VALEUR_DE_DEPLACEMENT);
		});
		
		this.getChildren().addAll(new Label("Translation"),new HBox(up,down), new HBox(left,right));
		this.setStyle("-fx-border-width: 2px; -fx-border-color: red;");
	}
}

