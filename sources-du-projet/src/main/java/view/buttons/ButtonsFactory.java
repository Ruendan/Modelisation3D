package view.buttons;

import javafx.scene.layout.GridPane;
import view.CanvasFigure;

/**
 * Factory to create all the button's panels
 * <p>This class is used to create all the panels that contains the buttons linked to the {@link Figure}</p>
 * @author Groupe G1
 */
public class ButtonsFactory {
	
	public static final String R="Rotation",T="Translation",Z="Zoom",C="Color",TH="Thickness", TR="Transparency";

	/**
	 * Create the panel indicated by type
	 * @param type
	 * 			The type of buttons panel to create
	 * @param canva
	 * 			The canvas in which we want the panel
	 * @return {@link GridPane}
	 * 			The panel filled with its buttons
	 */
	public static GridPane makeButton(String type, CanvasFigure canva) {
		
		switch(type) {
		
		case R:
			return new Rotation(canva);
		case T:
			return new Translation(canva.getFigure());			
		case Z:
			return new Zoom(canva.getFigure());	
		case C:
			return new Colors(canva.getPainter());
		case TH:
			return new Lines(canva.getPainter());
		case TR:
			return new Transparency(canva.getPainter());
		default:
			return null;
		}
	}
}
