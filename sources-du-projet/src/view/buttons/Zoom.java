package view.buttons;

import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import modele.modelisation.Figure;
import utils.Icon;
import view.ButtonsConst;

/**
 * Creation of zooming buttons
 * <p>This class is used to create the zoom-in and zoom-out buttons linked to the {@link Figure}</p>
 * @author Groupe G1
 */
public class Zoom extends GridPane{
	
	private Button in,out;
	
	/**
	 * Create the zooming buttons panel linked to {@link Figure}
	 * @param fig
	 * 			The {@link Figure} the buttons are linked to
	 */
	public Zoom(Figure fig){

		this.in = this.createButton("plus");		
		in.setOnAction(e->{
			fig.zoom(1+ButtonsConst.getVALEUR_DE_ZOOM());
		});
		
		this.out = this.createButton("less");	
		out.setOnAction(e->{
			fig.zoom(1-ButtonsConst.getVALEUR_DE_ZOOM());
		});
		
		this.setHgap(10);
		this.setVgap(10);
		
		this.add(in, 0, 0);
		this.add(out, 2, 0);
		
		this.setMaxHeight(50);
	}
	/**
	 * Create a zooming button with an image
	 * @param imgName
	 * 			The image's name
	 * @return {@link Button}
	 * 			The button with its image
	 */
	private Button createButton(String imgName) {
		Button res;
		ImageView img = Icon.createButtonIcon(imgName);
		
		res = new Button("",img);		
		res.setPrefSize(ButtonsConst.getButtonSize(),ButtonsConst.getButtonSize());
		res.setStyle(ButtonsConst.getButtonStyle());
		
		return res;
	}	
}

