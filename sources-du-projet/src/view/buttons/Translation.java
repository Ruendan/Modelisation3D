package view.buttons;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import modele.modelisation.Figure;
import utils.Icon;
import view.ButtonsConst;

public class Translation extends GridPane{
	
	private Button up,down,left,right;
	private static ImageView upImg,downImg,leftImg,rightImg;
	
	public Translation(Figure fig){
		upImg = Icon.createButtonIcon("up");
		downImg = Icon.createButtonIcon("down");
		leftImg = Icon.createButtonIcon("left");
		rightImg = Icon.createButtonIcon("right");
		
		this.up = new Button("",upImg);
		up.setOnAction(e->fig.VDeplace(-ButtonsConst.getVALEUR_DE_DEPLACEMENT_Y()));
		this.down = new Button("", downImg);
		down.setOnAction(e->{
			fig.VDeplace(ButtonsConst.getVALEUR_DE_DEPLACEMENT_Y());
		});
		
		this.up.setPrefSize(ButtonsConst.getButtonSize(),ButtonsConst.getButtonSize());
		this.down.setPrefSize(ButtonsConst.getButtonSize(),ButtonsConst.getButtonSize());
		this.up.setStyle(ButtonsConst.getButtonStyle());
		this.down.setStyle(ButtonsConst.getButtonStyle());
		
		this.left = new Button("",leftImg);
		left.setOnAction(e->{
			fig.HDeplace(-ButtonsConst.getVALEUR_DE_DEPLACEMENT_X());
		});
		this.right = new Button("",rightImg);	
		right.setOnAction(e->{
			fig.HDeplace(ButtonsConst.getVALEUR_DE_DEPLACEMENT_X());
		});
		this.left.setPrefSize(ButtonsConst.getButtonSize(),ButtonsConst.getButtonSize());
		this.right.setPrefSize(ButtonsConst.getButtonSize(),ButtonsConst.getButtonSize());
		this.left.setStyle(ButtonsConst.getButtonStyle());
		this.right.setStyle(ButtonsConst.getButtonStyle());
		
		this.setPadding(new Insets(10,0,10,10));
		this.setHgap(10);
		this.setVgap(10);
		this.setGridLinesVisible(true);
	
		this.add(up, 1, 1);
		this.add(left, 0, 2);
		this.add(right, 2, 2);
		this.add(down, 1, 3);
		
		this.setStyle(ButtonsConst.getPaneStyle());		
		this.setPrefWidth(190);
	}
}

