package view.buttons;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import modele.modelisation.Figure;

public class Rotation extends GridPane implements Buttons_control{
	
	private Button Xup,Xdown,Yup,Ydown,Zup,Zdown;
	private Label title;
	
	public Rotation(Figure fig){
		
		this.Xup = new Button("↑");
		Xup.setOnAction(e ->{
			fig.rotateX(VALEUR_DE_ROTATION);
		});
		this.Xdown = new Button("↓");
		Xdown.setOnAction(e ->{
			fig.rotateX(-VALEUR_DE_ROTATION);
		});
		this.Xup.setPrefSize(BUTTON_SIZE,BUTTON_SIZE); this.Xdown.setPrefSize(BUTTON_SIZE,BUTTON_SIZE);
		this.Xup.setStyle(BUTTON_STYLE); this.Xdown.setStyle(BUTTON_STYLE);
		
		
		this.Yup = new Button("←");
		Yup.setOnAction(e ->{
			fig.rotateY(VALEUR_DE_ROTATION);
		});
		this.Ydown = new Button("→");
		Ydown.setOnAction(e ->{
			fig.rotateY(-VALEUR_DE_ROTATION);
		});
		this.Yup.setPrefSize(BUTTON_SIZE,BUTTON_SIZE); this.Ydown.setPrefSize(BUTTON_SIZE,BUTTON_SIZE);
		this.Yup.setStyle(BUTTON_STYLE); this.Ydown.setStyle(BUTTON_STYLE);
		
		this.Zup = new Button("↷");
		Zup.setOnAction(e ->{
			fig.rotateZ(VALEUR_DE_ROTATION);
		});
		this.Zdown = new Button("↶");
		Zdown.setOnAction(e ->{
			fig.rotateZ(-VALEUR_DE_ROTATION);
		});
		this.Zup.setPrefSize(BUTTON_SIZE,BUTTON_SIZE); this.Zdown.setPrefSize(BUTTON_SIZE,BUTTON_SIZE);
		this.Zup.setStyle(BUTTON_STYLE); this.Zdown.setStyle(BUTTON_STYLE);
		
		this.setPadding(new Insets(22,0,0,15));
		this.setHgap(10);
		this.setVgap(20);
		this.setGridLinesVisible(true);
		
		this.add(Xup, 0, 0); this.add(Xdown, 2, 0);
		this.add(Yup, 0, 1); this.add(Ydown, 2, 1);
		this.add(Zup, 0, 2); this.add(Zdown, 2, 2);
		
		this.setStyle(PANE_STYLE);		
		this.setPrefSize(160,150);
	}
}

