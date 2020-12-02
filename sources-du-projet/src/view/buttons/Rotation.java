package view.buttons;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import view.Canva;

public class Rotation extends GridPane{
	
	private Button Xup,Xdown,Yup,Ydown,Zup,Zdown;
	
	public Rotation(Canva canva){
		
		this.Xup = new Button("↑");
		Xup.setOnAction(e ->{
			canva.getFigure().rotateX(ButtonsConst.VALEUR_DE_ROTATION);
		});
		this.Xdown = new Button("↓");
		Xdown.setOnAction(e ->{
			canva.getFigure().rotateX(-ButtonsConst.VALEUR_DE_ROTATION);
		});
		this.Xup.setPrefSize(ButtonsConst.BUTTON_SIZE,ButtonsConst.BUTTON_SIZE); this.Xdown.setPrefSize(ButtonsConst.BUTTON_SIZE,ButtonsConst.BUTTON_SIZE);
		this.Xup.setStyle(ButtonsConst.BUTTON_STYLE); this.Xdown.setStyle(ButtonsConst.BUTTON_STYLE);
		
		
		this.Yup = new Button("←");
		Yup.setOnAction(e ->{
			canva.getFigure().rotateY(ButtonsConst.VALEUR_DE_ROTATION);
		});
		this.Ydown = new Button("→");
		Ydown.setOnAction(e ->{
			canva.getFigure().rotateY(-ButtonsConst.VALEUR_DE_ROTATION);
		});
		this.Yup.setPrefSize(ButtonsConst.BUTTON_SIZE,ButtonsConst.BUTTON_SIZE); this.Ydown.setPrefSize(ButtonsConst.BUTTON_SIZE,ButtonsConst.BUTTON_SIZE);
		this.Yup.setStyle(ButtonsConst.BUTTON_STYLE); this.Ydown.setStyle(ButtonsConst.BUTTON_STYLE);
		
		this.Zup = new Button("↷");
		Zup.setOnAction(e ->{
			canva.getFigure().rotateZ(ButtonsConst.VALEUR_DE_ROTATION);
		});
		this.Zdown = new Button("↶");
		Zdown.setOnAction(e ->{
			canva.getFigure().rotateZ(-ButtonsConst.VALEUR_DE_ROTATION);
		});
		this.Zup.setPrefSize(ButtonsConst.BUTTON_SIZE,ButtonsConst.BUTTON_SIZE); this.Zdown.setPrefSize(ButtonsConst.BUTTON_SIZE,ButtonsConst.BUTTON_SIZE);
		this.Zup.setStyle(ButtonsConst.BUTTON_STYLE); this.Zdown.setStyle(ButtonsConst.BUTTON_STYLE);
		
		this.setPadding(new Insets(22,0,0,15));
		this.setHgap(10);
		this.setVgap(20);
		this.setGridLinesVisible(true);
		
		this.add(Xup, 0, 0); this.add(Xdown, 2, 0);
		this.add(Yup, 0, 1); this.add(Ydown, 2, 1);
		this.add(Zup, 0, 2); this.add(Zdown, 2, 2);

		this.add(new ButtonTimeline(canva), 0, 3);
		
		this.setStyle(ButtonsConst.PANE_STYLE);	
		this.setPrefSize(160,150);
	}
}

