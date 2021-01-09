package view.buttons;

import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import modele.modelisation.Figure;
import utils.IconConstants;
import view.ButtonsConstants;

/**
 * Creation of zooming buttons
 * <p>This class is used to create the zoom-in and zoom-out buttons linked to the {@link Figure}</p>
 * @author Groupe G1
 */
public class Zoom extends GridPane{
	
	private static final ImageView INIMG = IconConstants.createButtonIcon("plus"),
			LESSIMG = IconConstants.createButtonIcon("less");
	
	/**
	 * Create the zooming buttons panel linked to {@link Figure}
	 * @param fig
	 * 			The {@link Figure} the buttons are linked to
	 */
	public Zoom(Figure fig){super();
		
		final Button in,out;
		
		in = new Button("", INIMG);
		in.setOnAction(e->{
			fig.zoom(1+ButtonsConstants.getValeurZoom());
		});
		in.setPrefSize(ButtonsConstants.getButtonSize(),ButtonsConstants.getButtonSize());
		in.setStyle(ButtonsConstants.getButtonStyle());
		
		out = new Button("", LESSIMG);
		out.setOnAction(e->{
			fig.zoom(1-ButtonsConstants.getValeurZoom());
		});
		out.setPrefSize(ButtonsConstants.getButtonSize(),ButtonsConstants.getButtonSize());
		out.setStyle(ButtonsConstants.getButtonStyle());
		
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
		ImageView img = IconConstants.createButtonIcon(imgName);
		
		res = new Button("",img);		
		res.setPrefSize(ButtonsConstants.getButtonSize(),ButtonsConstants.getButtonSize());
		res.setStyle(ButtonsConstants.getButtonStyle());
		
		return res;
	}	
}

