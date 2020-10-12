package view;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import modele.modelisation.Figure;

public class Buttons extends HBox{
	
	private Button first, second, third;
	private static final int VALEUR_DE_DEPLACEMENT = 10;
	
	
	public Buttons(Figure fig){
		this.first = new Button("Change X");
		first.setOnAction(e ->{
			fig.rotateX(VALEUR_DE_DEPLACEMENT);
		});
		
		this.second = new Button("Change Y");
		second.setOnAction(e ->{
			fig.rotateY(VALEUR_DE_DEPLACEMENT);
		});
		
		this.third = new Button("Change Z");
		third.setOnAction(e ->{
			fig.rotateZ(VALEUR_DE_DEPLACEMENT);
		});
		
		this.getChildren().addAll(first, second, third);
		this.setStyle("-fx-border-width: 2px; -fx-border-color: red;");
	}
}
