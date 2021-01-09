package view.buttons;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import modele.modelisation.Figure;
import utils.IconConstants;
import view.ButtonsConstants;

/**
 * Creation of moving buttons
 * <p>This class is used to create the moving buttons linked to the {@link Figure}</p>
 * @author Groupe G1
 */
public class Translation extends GridPane{
	
	private static final ImageView UPIMG = IconConstants.createButtonIcon("up"),
									DOWNIMG = IconConstants.createButtonIcon("down"),
									LEFTIMG = IconConstants.createButtonIcon("left"),
									RIGHTIMG = IconConstants.createButtonIcon("right");
	
	/**
	 * Create the moving buttons panel linked to {@link Figure}
	 * @param fig
	 * 			The {@link Figure} the buttons are linked to
	 */
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
	
		this.add(up, 1, 0);
		this.add(left, 0, 1);
		this.add(right, 2,1);
		this.add(down, 1, 2);

		this.setMaxHeight(180);
	}
	/**
	 * Create a moving button with an image
	 * @param imgName
	 * 			The image's name
	 * @return {@link Button}
	 * 			The button with its image
	 */
	private Button createButton(String imgName) {
		Button res;
		ImageView img = IconConstants.createButtonIcon(imgName);
		
		res = new Button("",img);
		res.setPrefSize(ButtonsConstants.getButtonSize(),ButtonsConstants.getButtonSize());
		res.setStyle(ButtonsConstants.getButtonStyle());
		
		return res;
	}
}

