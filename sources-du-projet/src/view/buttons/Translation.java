package view.buttons;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import modele.modelisation.Figure;

public class Translation extends VBox{
	
	private Button up,down,left,right;
	
	private static final int VALEUR_DE_DEPLACEMENT = 10;
	private static final int BUTTON_SIZE = 48;
	private static final String BUTTON_STYLE = "-fx-background-color: black; -fx-background-radius: 50; -fx-text-fill: white; -fx-font: 20 arial;";
	
	public Translation(Figure fig){
		
		Label title = new Label("   Translation   ");
		title.setStyle("-fx-text-fill: white; -fx-font: 16 arial; -fx-font-weight:bold; -fx-border-width:3px; -fx-border-color:white; -fx-border-radius:5");
		
		this.up = new Button("↑");
		up.setOnAction(e->{
			fig.VDeplace(-VALEUR_DE_DEPLACEMENT);;
		});		
		this.down = new Button("↓");
		down.setOnAction(e->{
			fig.VDeplace(VALEUR_DE_DEPLACEMENT);
		});
		this.up.setPrefSize(BUTTON_SIZE,BUTTON_SIZE);
		this.down.setPrefSize(BUTTON_SIZE,BUTTON_SIZE);
		this.up.setStyle(BUTTON_STYLE);
		this.down.setStyle(BUTTON_STYLE);
		
		this.left = new Button("←");
		left.setOnAction(e->{
			fig.HDeplace(-VALEUR_DE_DEPLACEMENT);
		});
		this.right = new Button("→");	
		right.setOnAction(e->{
			fig.HDeplace(VALEUR_DE_DEPLACEMENT);
		});
		this.left.setPrefSize(BUTTON_SIZE,BUTTON_SIZE);
		this.right.setPrefSize(BUTTON_SIZE,BUTTON_SIZE);
		this.left.setStyle(BUTTON_STYLE);
		this.right.setStyle(BUTTON_STYLE);
		
		this.getChildren().addAll(title,new HBox(up,down), new HBox(left,right));
		
		this.setStyle("-fx-border-width: 4px; -fx-border-color: black; -fx-background-color: slategrey; -fx-background-radius: 25;");		
		this.setPrefWidth(200);
	}
}

