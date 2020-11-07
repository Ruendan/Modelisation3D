package view.buttons;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import modele.modelisation.Figure;

public class Rotation extends VBox{
	
	private Button Xup,Xdown,Yup,Ydown,Zup,Zdown;
	
	private static final int VALEUR_DE_ROTATION = 10;
	
	public Rotation(Figure fig){
		
		this.Xup = new Button("↑");
		Xup.setOnAction(e ->{
			fig.rotateX(VALEUR_DE_ROTATION);
		});
		this.Xdown = new Button("↓");
		Xdown.setOnAction(e ->{
			fig.rotateX(-VALEUR_DE_ROTATION);
		});
		
		
		this.Yup = new Button("←");
		Yup.setOnAction(e ->{
			fig.rotateY(VALEUR_DE_ROTATION);
		});
		this.Ydown = new Button("→");
		Ydown.setOnAction(e ->{
			fig.rotateY(-VALEUR_DE_ROTATION);
		});
		
		
		this.Zup = new Button("↷");
		Zup.setOnAction(e ->{
			fig.rotateZ(VALEUR_DE_ROTATION);
		});
		this.Zdown = new Button("↶");
		Zdown.setOnAction(e ->{
			fig.rotateZ(-VALEUR_DE_ROTATION);
		});
		
		this.getChildren().addAll(new Label("Rotation"),new HBox(Xup,Xdown),new HBox(Yup,Ydown),new HBox(Zup,Zdown));		
		this.setStyle("-fx-border-width: 2px; -fx-border-color: red;");
	}
}

