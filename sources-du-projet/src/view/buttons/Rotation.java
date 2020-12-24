package view.buttons;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import view.ButtonsConst;
import view.CanvasFigure;

public class Rotation extends GridPane{
	
	private Button Xup,Xdown,Yup,Ydown,Zup,Zdown;
	private static ImageView xUp,xDown,yUp,yDown,zUp,zDown;
	
	public Rotation(CanvasFigure canva){
		
		xUp = new ImageView(new Image(getClass().getResourceAsStream("imgs/xUp.png")));
		xDown = new ImageView(new Image(getClass().getResourceAsStream("imgs/xDown.png")));		
		yUp = new ImageView(new Image(getClass().getResourceAsStream("imgs/yUp.png")));
		yDown = new ImageView(new Image(getClass().getResourceAsStream("imgs/yDown.png")));
		zUp = new ImageView(new Image(getClass().getResourceAsStream("imgs/zUp.png")));
		zDown = new ImageView(new Image(getClass().getResourceAsStream("imgs/zDown.png")));
		
		this.Xup = new Button("",xUp);
		Xup.setOnAction(e ->{
			canva.getFigure().rotateX(ButtonsConst.getVALEUR_DE_ROTATION_Y());
		});
		this.Xdown = new Button("",xDown);
		Xdown.setOnAction(e ->{
			canva.getFigure().rotateX(-ButtonsConst.getVALEUR_DE_ROTATION_Y());
		});
		this.Xup.setPrefSize(ButtonsConst.getButtonSize(),ButtonsConst.getButtonSize()); this.Xdown.setPrefSize(ButtonsConst.getButtonSize(),ButtonsConst.getButtonSize());
		this.Xup.setStyle(ButtonsConst.getButtonStyle()); this.Xdown.setStyle(ButtonsConst.getButtonStyle());
		
		
		this.Yup = new Button("",yUp);
		Yup.setOnAction(e ->{
			canva.getFigure().rotateY(ButtonsConst.getVALEUR_DE_ROTATION_X());
		});
		this.Ydown = new Button("",yDown);
		Ydown.setOnAction(e ->{
			canva.getFigure().rotateY(-ButtonsConst.getVALEUR_DE_ROTATION_X());
		});
		this.Yup.setPrefSize(ButtonsConst.getButtonSize(),ButtonsConst.getButtonSize()); this.Ydown.setPrefSize(ButtonsConst.getButtonSize(),ButtonsConst.getButtonSize());
		this.Yup.setStyle(ButtonsConst.getButtonStyle()); this.Ydown.setStyle(ButtonsConst.getButtonStyle());
		
		this.Zup = new Button("",zUp);
		Zup.setOnAction(e ->{
			canva.getFigure().rotateZ(ButtonsConst.getVALEUR_DE_ROTATION_Z());
		});
		this.Zdown = new Button("",zDown);
		Zdown.setOnAction(e ->{
			canva.getFigure().rotateZ(-ButtonsConst.getVALEUR_DE_ROTATION_Z());
		});
		this.Zup.setPrefSize(ButtonsConst.getButtonSize(),ButtonsConst.getButtonSize()); this.Zdown.setPrefSize(ButtonsConst.getButtonSize(),ButtonsConst.getButtonSize());
		this.Zup.setStyle(ButtonsConst.getButtonStyle()); this.Zdown.setStyle(ButtonsConst.getButtonStyle());
		
		this.setPadding(new Insets(22,0,0,15));
		this.setHgap(10);
		this.setVgap(20);
		this.setGridLinesVisible(true);
		
		this.add(Xup, 0, 0); this.add(Xdown, 2, 0);
		this.add(Yup, 0, 1); this.add(Ydown, 2, 1);
		this.add(Zup, 0, 2); this.add(Zdown, 2, 2);

		ButtonTimeline autoRotate = new ButtonTimeline(canva);
		//GridPane.setColumnSpan(autoRotate,2);
		this.add(autoRotate, 1, 3);
		
		
		this.setStyle(ButtonsConst.getPaneStyle());	
		this.setPrefSize(185,150);
	}
}

