package view.buttons;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import modele.modelisation.Figure;

public class Zoom extends VBox{
	
	private Button In,Out;
	
	private static final double VALEUR_DE_ZOOM_IN = 1.05;
	private static final double VALEUR_DE_ZOOM_OUT = 0.95;
	
	public Zoom(Figure fig){
		
		this.In = new Button("+");
		In.setOnAction(e->{
			fig.zoom(VALEUR_DE_ZOOM_IN);
		});
		
		this.Out = new Button("-");
		Out.setOnAction(e->{
			fig.zoom(VALEUR_DE_ZOOM_OUT);
		});
		
		this.getChildren().addAll(new Label("Zoom"),new HBox(In,Out));
		this.setStyle("-fx-border-width: 2px; -fx-border-color: red;");
	}
}

