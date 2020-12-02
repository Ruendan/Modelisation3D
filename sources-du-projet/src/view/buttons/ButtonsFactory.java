package view.buttons;

import javafx.scene.layout.GridPane;
import view.Canva;

public class ButtonsFactory {
	
	public static final String R="Rotation",T="Translation",Z="Zoom",C="Color",TH="Thickness";

	public static GridPane makeButton(String type, Canva canva) {
		
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
		default:
			System.out.println("Veuillez insérer un type de bouton correct");
			return null;
		}
	}
}
