package view.buttons;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import modele.modelisation.Figure;
import utils.Icon;
import view.ButtonsAttributes;

/**
 * Creation of moving buttons
 * <p>This class is used to create the translation buttons linked to the {@link Figure}</p>
 * @author Groupe G1
 */
public class Translation extends GridPane{
	
	private Button up,down,left,right;
	
	/**
	 * Create the translation buttons panel linked to {@link Figure}
	 * @param fig
	 * 			The {@link Figure} the buttons are linked to
	 */
	public Translation(Figure fig){
		
		this.up = this.createButton("up");
		up.setOnAction(e->fig.VDeplace(-ButtonsAttributes.getVALEUR_DE_DEPLACEMENT_Y()));
		this.down = this.createButton("down");
		down.setOnAction(e->{
			fig.VDeplace(ButtonsAttributes.getVALEUR_DE_DEPLACEMENT_Y());
		});
		
		this.left = this.createButton("left");
		left.setOnAction(e->{
			fig.HDeplace(-ButtonsAttributes.getVALEUR_DE_DEPLACEMENT_X());
		});
		this.right = this.createButton("right");	
		right.setOnAction(e->{
			fig.HDeplace(ButtonsAttributes.getVALEUR_DE_DEPLACEMENT_X());
		});
		
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
	 * Create a translation button with an image
	 * @param imgName
	 * 			The image's name
	 * @return {@link Button}
	 * 			The button with its image
	 */
	private Button createButton(String imgName) {
		Button res;
		ImageView img = Icon.createButtonIcon(imgName);
		
		res = new Button("",img);
		res.setPrefSize(ButtonsAttributes.getButtonSize(),ButtonsAttributes.getButtonSize());
		res.setStyle(ButtonsAttributes.getButtonStyle());
		
		return res;
	}
}

