package view.buttons;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import modele.modelisation.Figure;

public class Translation extends GridPane{
	
	private Button up,down,left,right;
	
	private static final int VALEUR_DE_DEPLACEMENT = 10;
	private static final int BUTTON_SIZE = 48;
	private static final String BUTTON_STYLE = "-fx-background-color: black; -fx-background-radius: 50; -fx-text-fill: white; -fx-font: 20 arial;";
	
	public Translation(Figure fig){
		
		this.setPadding(new Insets(10,0,10,10));
		this.setHgap(10);
		this.setVgap(10);
		//this.setGridLinesVisible(true);
		
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
		
		this.add(title, 1, 0);
		this.add(up, 0, 1);
		this.add(down, 2, 1);
		this.add(left, 0, 2);
		this.add(right, 2, 2);
		
		this.setStyle("-fx-border-width: 4px; -fx-border-color: white; -fx-background-color: slategrey; -fx-background-radius: 25; -fx-border-radius:25;");		
		this.setPrefWidth(260);
	}
}

