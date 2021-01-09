package view.buttons;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import modele.modelisation.Figure;
import utils.IconConstants;
import view.ButtonsConstants;

public class Translation extends GridPane{
	
	
	private static final ImageView UPIMG = IconConstants.createButtonIcon("up"),
									DOWNIMG = IconConstants.createButtonIcon("down"),
									LEFTIMG = IconConstants.createButtonIcon("left"),
									RIGHTIMG = IconConstants.createButtonIcon("right");
	
	public Translation(Figure fig){
		super();
		final Button up,down,left,right;
		
		up = new Button("",UPIMG);
		up.setOnAction(e->fig.vDeplace(-ButtonsConstants.getValeurTranslation()));
		down = new Button("", DOWNIMG);
		down.setOnAction(e->{
			fig.vDeplace(ButtonsConstants.getValeurTranslation());
		});
		
		up.setPrefSize(ButtonsConstants.getButtonSize(),ButtonsConstants.getButtonSize());
		down.setPrefSize(ButtonsConstants.getButtonSize(),ButtonsConstants.getButtonSize());
		up.setStyle(ButtonsConstants.getButtonStyle());
		down.setStyle(ButtonsConstants.getButtonStyle());
		
		left = new Button("",LEFTIMG);
		left.setOnAction(e->{
			fig.hDeplace(-ButtonsConstants.getValeurTranslation());
		});
		right = new Button("",RIGHTIMG);	
		right.setOnAction(e->{
			fig.hDeplace(ButtonsConstants.getValeurTranslation());
		});
		left.setPrefSize(ButtonsConstants.getButtonSize(),ButtonsConstants.getButtonSize());
		right.setPrefSize(ButtonsConstants.getButtonSize(),ButtonsConstants.getButtonSize());
		left.setStyle(ButtonsConstants.getButtonStyle());
		right.setStyle(ButtonsConstants.getButtonStyle());
		
		this.setPadding(new Insets(0,35,0,35));
		this.setHgap(10);
		this.setVgap(10);
		//this.setGridLinesVisible(true);
	
		this.add(up, 1, 0);
		this.add(left, 0, 1);
		this.add(right, 2,1);
		this.add(down, 1, 2);
		
		//this.setStyle(ButtonsConst.getPaneStyle());
		this.setMaxHeight(180);
	}
}

