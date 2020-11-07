package view.buttons;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import modele.modelisation.Figure;

public class Zoom extends VBox{
	
	private Button In,Out;
	
	private static final double VALEUR_DE_ZOOM = 0.05;
	
	public Zoom(Figure fig){
		
		Label title = new Label("Zoom");
		title.setStyle("-fx-text-fill: white;");
		
		this.In = new Button("+");
		In.setOnAction(e->{
			fig.zoom(1+VALEUR_DE_ZOOM);
		});
		
		this.Out = new Button("-");
		Out.setOnAction(e->{
			fig.zoom(1-VALEUR_DE_ZOOM);
		});
		
		this.getChildren().addAll(title,new HBox(In,Out));
		this.setStyle("-fx-border-width: 2px; -fx-border-color: red;");
	}
}

