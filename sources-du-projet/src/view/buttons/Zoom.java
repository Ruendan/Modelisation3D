package view.buttons;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import modele.modelisation.Figure;

public class Zoom extends VBox{
	
	private Button In,Out;
	
	private static final double VALEUR_DE_ZOOM = 0.05;
	private static final int BUTTON_SIZE = 30;
	private static final String BUTTON_STYLE = "-fx-background-color: black; -fx-background-radius: 50; -fx-text-fill: white; -fx-font: 20 arial;";
	
	public Zoom(Figure fig){
		
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
		
		this.getChildren().addAll(title,new HBox(In,Out));
		
		this.setStyle("-fx-border-width: 4px; -fx-border-color: black; -fx-background-color: firebrick; -fx-background-radius: 25;");		
		this.setPrefWidth(200);
	}
}

