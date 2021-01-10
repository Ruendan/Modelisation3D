package view.buttons;

import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import modele.modelisation.Figure;
import utils.IconConstants;
import view.ButtonsUtils;

/**
 * Creation of zooming buttons
 * <p>This class is used to create the zoom-in and zoom-out buttons linked to the {@link Figure}</p>
 * @author Groupe G1
 */
public class Zoom extends GridPane{
	
	/**
	 * Create the zooming buttons panel linked to {@link Figure}
	 * @param fig
	 * 			The {@link Figure} the buttons are linked to
	 */
	public Zoom(Figure fig){
		super();
		
		final Button in,out;
		
		in = createButton("plus");
		in.setOnAction(e->{
			fig.zoom(1+ButtonsUtils.getValeurZoom());
		});
		
		out = createButton("less");
		out.setOnAction(e->{
			fig.zoom(1-ButtonsUtils.getValeurZoom());
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
		final ImageView img = IconConstants.createButtonIcon(imgName);
		
		res = new Button("",img);		
		res.setPrefSize(ButtonsUtils.getButtonSize(),ButtonsUtils.getButtonSize());
		res.setStyle(ButtonsUtils.getButtonStyle());
		
		return res;
	}	
}

