package view.buttons;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import modele.modelisation.Figure;

public class Rotation extends GridPane{
	
	private Button Xup,Xdown,Yup,Ydown,Zup,Zdown;
	
	private static final int VALEUR_DE_ROTATION = 10;
	private static final int BUTTON_SIZE_WIDTH = 48;
	private static final int BUTTON_SIZE_HEIGHT = 30;
	private static final String BUTTON_STYLE = "-fx-background-color: black; -fx-background-radius: 50; -fx-text-fill: white; -fx-font: 20 arial;";
	
	public Rotation(Figure fig){
		
		this.setPadding(new Insets(22,0,0,15));
		this.setHgap(10);
		this.setVgap(10);
		//this.setGridLinesVisible(true);
		
		Label title = new Label("   Rotation   ");
		title.setStyle("-fx-text-fill: white; -fx-font: 16 arial; -fx-font-weight:bold; -fx-border-width:3px; -fx-border-color:white; -fx-border-radius:5");
		
		this.Xup = new Button("↑");
		Xup.setOnAction(e ->{
			fig.rotateX(VALEUR_DE_ROTATION);
		});
		this.Xdown = new Button("↓");
		Xdown.setOnAction(e ->{
			fig.rotateX(-VALEUR_DE_ROTATION);
		});
		this.Xup.setPrefSize(BUTTON_SIZE_WIDTH,BUTTON_SIZE_HEIGHT);
		this.Xdown.setPrefSize(BUTTON_SIZE_WIDTH,BUTTON_SIZE_HEIGHT);
		this.Xup.setStyle(BUTTON_STYLE);
		this.Xdown.setStyle(BUTTON_STYLE);
		
		
		this.Yup = new Button("←");
		Yup.setOnAction(e ->{
			fig.rotateY(VALEUR_DE_ROTATION);
		});
		this.Ydown = new Button("→");
		Ydown.setOnAction(e ->{
			fig.rotateY(-VALEUR_DE_ROTATION);
		});
		this.Yup.setPrefSize(BUTTON_SIZE_WIDTH,BUTTON_SIZE_HEIGHT);
		this.Ydown.setPrefSize(BUTTON_SIZE_WIDTH,BUTTON_SIZE_HEIGHT);
		this.Yup.setStyle(BUTTON_STYLE);
		this.Ydown.setStyle(BUTTON_STYLE);
		
		
		this.Zup = new Button("↷");
		Zup.setOnAction(e ->{
			fig.rotateZ(VALEUR_DE_ROTATION);
		});
		this.Zdown = new Button("↶");
		Zdown.setOnAction(e ->{
			fig.rotateZ(-VALEUR_DE_ROTATION);
		});
		this.Zup.setPrefSize(BUTTON_SIZE_WIDTH,BUTTON_SIZE_HEIGHT);
		this.Zdown.setPrefSize(BUTTON_SIZE_WIDTH,BUTTON_SIZE_HEIGHT);
		this.Zup.setStyle(BUTTON_STYLE);
		this.Zdown.setStyle(BUTTON_STYLE);
		
		this.add(title, 1, 0);
		this.add(Xup, 0, 1);
		this.add(Xdown, 2, 1);
		this.add(Yup, 0, 2);
		this.add(Ydown, 2, 2);
		this.add(Zup, 0, 3);
		this.add(Zdown, 2, 3);
		
		this.setStyle("-fx-border-width: 4px; -fx-border-color: black; -fx-background-color: slategrey; -fx-background-radius: 50;");		
		this.setPrefSize(250,220);
	}
}

