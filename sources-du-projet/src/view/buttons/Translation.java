package view.buttons;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import modele.modelisation.Figure;
import utils.IconConstants;
import view.ButtonsUtils;

/**
 * Creation of moving buttons
 * <p>This class is used to create the translation buttons linked to the {@link Figure}</p>
 * @author Groupe G1
 */
public class Translation extends GridPane{
	
	/**
	 * Create the translation buttons panel linked to {@link Figure}
	 * @param fig
	 * 			The {@link Figure} the buttons are linked to
	 */
	public Translation(Figure fig){
		super();
		final Button up,down,left,right;
		
		up = createButton("up");
		up.setOnAction(e->fig.vDeplace(-ButtonsUtils.getValeurTranslation()));
		
		down = createButton("down");
		down.setOnAction(e->fig.vDeplace(ButtonsUtils.getValeurTranslation()));
		
		
		left = createButton("left");
		left.setOnAction(e->fig.hDeplace(-ButtonsUtils.getValeurTranslation()));
		
		right = createButton("right");	
		right.setOnAction(e->fig.hDeplace(ButtonsUtils.getValeurTranslation()));
		
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
		final ImageView img = IconConstants.createButtonIcon(imgName);
		
		res = new Button("",img);
		res.setPrefSize(ButtonsUtils.getButtonSize(),ButtonsUtils.getButtonSize());
		res.setStyle(ButtonsUtils.getButtonStyle());
		
		return res;
	}
}

