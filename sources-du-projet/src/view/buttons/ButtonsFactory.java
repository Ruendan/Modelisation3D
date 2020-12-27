package view.buttons;

import javafx.scene.layout.GridPane;
import view.CanvasFigure;

public class ButtonsFactory {
	
	public static final String R="Rotation",T="Translation",Z="Zoom",C="Color",TH="Thickness", TR="Transparency";

	public static GridPane makeButton(String type, CanvasFigure canva) {
		
		switch(type) {
		
		case R:
			return new Rotation(canva);
		case T:
			return new Translation(canva.getFigure());			
		case Z:
			return new Zoom(canva.getFigure());	
		case C:
			return new ColorPane(canva);
		case TH:
			return new LineWidthPane(canva);
		case TR:
			return new TransparencyPane(canva);
		default:
			System.out.println("Veuillez inserer un type de bouton correct");
			return null;
		}
	}
}
