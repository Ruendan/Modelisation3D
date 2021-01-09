package view.buttons;

import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import utils.IconConstants;
import view.ButtonsConstants;
import view.CanvasFigure;

public class Rotation extends GridPane{
	
	private static final ImageView XUPIMG = IconConstants.createButtonIcon("xUp"),
			XDOWNIMG = IconConstants.createButtonIcon("xDown"),
			YUPIMG = IconConstants.createButtonIcon("yUp"),
			YDOWNIMG = IconConstants.createButtonIcon("yDown"),
			ZUPIMG = IconConstants.createButtonIcon("zUp"),
			ZDOWNIMG = IconConstants.createButtonIcon("zDown");
	
	public Rotation(CanvasFigure canva){
		super();
		final Button xup,xdown,yup,ydown,zup,zdown;
		
		xup = new Button("",XUPIMG);
		xup.setOnAction(e ->{
			canva.getFigure().rotateX(ButtonsConstants.getValeurRotation());
		});
		xdown = new Button("",XDOWNIMG);
		xdown.setOnAction(e ->{
			canva.getFigure().rotateX(-ButtonsConstants.getValeurRotation());
		});
		xup.setPrefSize(ButtonsConstants.getButtonSize(),ButtonsConstants.getButtonSize()); xdown.setPrefSize(ButtonsConstants.getButtonSize(),ButtonsConstants.getButtonSize());
		xup.setStyle(ButtonsConstants.getButtonStyle()); xdown.setStyle(ButtonsConstants.getButtonStyle());
		
		
		yup = new Button("",YUPIMG);
		yup.setOnAction(e ->{
			canva.getFigure().rotateY(ButtonsConstants.getValeurRotation());
		});
		ydown = new Button("",YDOWNIMG);
		ydown.setOnAction(e ->{
			canva.getFigure().rotateY(-ButtonsConstants.getValeurRotation());
		});
		yup.setPrefSize(ButtonsConstants.getButtonSize(),ButtonsConstants.getButtonSize()); ydown.setPrefSize(ButtonsConstants.getButtonSize(),ButtonsConstants.getButtonSize());
		yup.setStyle(ButtonsConstants.getButtonStyle()); ydown.setStyle(ButtonsConstants.getButtonStyle());
		
		zup = new Button("",ZUPIMG);
		zup.setOnAction(e ->{
			canva.getFigure().rotateZ(ButtonsConstants.getValeurRotation());
		});
		zdown = new Button("",ZDOWNIMG);
		zdown.setOnAction(e ->{
			canva.getFigure().rotateZ(-ButtonsConstants.getValeurRotation());
		});
		zup.setPrefSize(ButtonsConstants.getButtonSize(),ButtonsConstants.getButtonSize()); zdown.setPrefSize(ButtonsConstants.getButtonSize(),ButtonsConstants.getButtonSize());
		zup.setStyle(ButtonsConstants.getButtonStyle()); zdown.setStyle(ButtonsConstants.getButtonStyle());
		
		this.setHgap(10);
		this.setVgap(20);
		//this.setGridLinesVisible(true);
		
		this.add(xup, 0, 0); this.add(xdown, 2, 0);
		this.add(yup, 0, 1); this.add(ydown, 2, 1);
		this.add(zup, 0, 2); this.add(zdown, 2, 2);

		final ButtonTimeline autoRotate = new ButtonTimeline(canva);
		this.add(autoRotate, 1, 3);
		
		
		//this.setStyle(ButtonsConst.getPaneStyle());	
		this.setMaxHeight(250);
	}
}

