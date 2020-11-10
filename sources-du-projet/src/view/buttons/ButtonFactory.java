package view.buttons;

import javafx.scene.layout.GridPane;
import modele.modelisation.Figure;
import view.Canva;

public class ButtonFactory {

	public static GridPane makeButton(String type, Figure fig) {
		
		switch(type) {
		
		case "Rotation":
			return new Rotation(fig);
		case "Translation":
			return new Translation(fig);			
		case "Zoom":
			return new Zoom(fig);	
		
		default:
			System.out.println("Veuillez insérer un type de bouton correct");
			return null;
		}
	}
	
	public static GridPane makeButton(String type, Canva canv) {
		
		switch(type) {
		
		case "Color":
			return new ColorPane(canv);
		case "Thickness":
			return new LineWidthPane(canv);
		
		default:
			System.out.println("Veuillez insérer un type de bouton correct");
			return null;
		}
	}
}
