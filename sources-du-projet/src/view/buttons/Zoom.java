package view.buttons;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import modele.modelisation.Figure;

public class Zoom extends GridPane{
	
	private Button In,Out;
	
	private static final double VALEUR_DE_ZOOM = 0.05;
	private static final int BUTTON_SIZE = 48;
	private static final String BUTTON_STYLE = "-fx-background-color: black; -fx-background-radius: 50; -fx-text-fill: white; -fx-font: 20 arial;";
	
	public Zoom(Figure fig){
		
		this.setPadding(new Insets(10,0,10,30));
		this.setHgap(10);
		this.setVgap(10);
		
		Label title = new Label("   Zoom   ");
		title.setStyle("-fx-text-fill: white; -fx-font: 16 arial; -fx-font-weight:bold; -fx-border-width:3px; -fx-border-color:white; -fx-border-radius:5");
		
		
		this.In = new Button("+");
		In.setOnAction(e->{
			fig.zoom(1+VALEUR_DE_ZOOM);
		});
		this.In.setPrefSize(BUTTON_SIZE,BUTTON_SIZE);
		this.In.setStyle(BUTTON_STYLE);
		
		this.Out = new Button("-");
		Out.setOnAction(e->{
			fig.zoom(1-VALEUR_DE_ZOOM);
		});
		this.Out.setPrefSize(BUTTON_SIZE,BUTTON_SIZE);
		this.Out.setStyle(BUTTON_STYLE);
		
		this.add(title, 1, 0);
		this.add(In, 0, 1);
		this.add(Out, 2, 1);
		
		this.setStyle("-fx-border-width: 4px; -fx-border-color: white; -fx-background-color: slategrey; -fx-background-radius: 25; -fx-border-radius:25;");		
		this.setPrefWidth(200);
	}
}

