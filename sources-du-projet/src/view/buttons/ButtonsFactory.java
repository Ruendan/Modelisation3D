package view.buttons;

import javafx.scene.layout.GridPane;
import modele.modelisation.Figure;
import view.Canva;

public class ButtonsFactory {
	
	public static final String R="Rotation",T="Translation",Z="Zoom",C="Color",TH="Thickness";

	public static GridPane makeButton(String type, Figure fig) {
		
		switch(type) {
		
		case R:
			return new Rotation(fig);
		case T:
			return new Translation(fig);			
		case Z:
			return new Zoom(fig);	
		
		default:
			System.out.println("Veuillez insérer un type de bouton correct");
			return null;
		}
	}
	
	public static GridPane makeButton(String type, Canva canv) {
		
		switch(type) {
		
		case C:
			return new ColorPane(canv);
		case TH:
			return new LineWidthPane(canv);
		
		default:
			System.out.println("Veuillez insérer un type de bouton correct");
			return null;
		}
	}
}
