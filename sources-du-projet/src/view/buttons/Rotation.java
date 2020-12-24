package view.buttons;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import utils.Icon;
import view.ButtonsConst;
import view.CanvasFigure;

public class Rotation extends GridPane{
	
	private Button xup,xdown,yup,ydown,zup,zdown;
	private static ImageView xupImg,xdownImg,yupImg,ydownImg,zupImg,zdownImg;
	
	public Rotation(CanvasFigure canva){
		
		xupImg = Icon.createButtonIcon("xUp");
		xdownImg = Icon.createButtonIcon("xDown");	
		yupImg = Icon.createButtonIcon("yUp");
		ydownImg = Icon.createButtonIcon("yDown");
		zupImg = Icon.createButtonIcon("zUp");
		zdownImg = Icon.createButtonIcon("zDown");
		
		this.xup = new Button("",xupImg);
		xup.setOnAction(e ->{
			canva.getFigure().rotateX(ButtonsConst.getVALEUR_DE_ROTATION_Y());
		});
		this.xdown = new Button("",xdownImg);
		xdown.setOnAction(e ->{
			canva.getFigure().rotateX(-ButtonsConst.getVALEUR_DE_ROTATION_Y());
		});
		this.xup.setPrefSize(ButtonsConst.getButtonSize(),ButtonsConst.getButtonSize()); this.xdown.setPrefSize(ButtonsConst.getButtonSize(),ButtonsConst.getButtonSize());
		this.xup.setStyle(ButtonsConst.getButtonStyle()); this.xdown.setStyle(ButtonsConst.getButtonStyle());
		
		
		this.yup = new Button("",yupImg);
		yup.setOnAction(e ->{
			canva.getFigure().rotateY(ButtonsConst.getVALEUR_DE_ROTATION_X());
		});
		this.ydown = new Button("",ydownImg);
		ydown.setOnAction(e ->{
			canva.getFigure().rotateY(-ButtonsConst.getVALEUR_DE_ROTATION_X());
		});
		this.yup.setPrefSize(ButtonsConst.getButtonSize(),ButtonsConst.getButtonSize()); this.ydown.setPrefSize(ButtonsConst.getButtonSize(),ButtonsConst.getButtonSize());
		this.yup.setStyle(ButtonsConst.getButtonStyle()); this.ydown.setStyle(ButtonsConst.getButtonStyle());
		
		this.zup = new Button("",zupImg);
		zup.setOnAction(e ->{
			canva.getFigure().rotateZ(ButtonsConst.getVALEUR_DE_ROTATION_Z());
		});
		this.zdown = new Button("",zdownImg);
		zdown.setOnAction(e ->{
			canva.getFigure().rotateZ(-ButtonsConst.getVALEUR_DE_ROTATION_Z());
		});
		this.zup.setPrefSize(ButtonsConst.getButtonSize(),ButtonsConst.getButtonSize()); this.zdown.setPrefSize(ButtonsConst.getButtonSize(),ButtonsConst.getButtonSize());
		this.zup.setStyle(ButtonsConst.getButtonStyle()); this.zdown.setStyle(ButtonsConst.getButtonStyle());
		
		this.setHgap(10);
		this.setVgap(20);
		//this.setGridLinesVisible(true);
		
		this.add(xup, 0, 0); this.add(xdown, 2, 0);
		this.add(yup, 0, 1); this.add(ydown, 2, 1);
		this.add(zup, 0, 2); this.add(zdown, 2, 2);

		ButtonTimeline autoRotate = new ButtonTimeline(canva);
		this.add(autoRotate, 1, 3);
		
		
		//this.setStyle(ButtonsConst.getPaneStyle());	
		this.setMaxHeight(250);
	}
}

