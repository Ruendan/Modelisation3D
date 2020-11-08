package view.buttons;

import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import view.Canva;

public class Buttons extends HBox {
	
	private Rotation buttons_rotation;
	private Translation buttons_translation;
	private Zoom buttons_zoom;
	private ColorPane bouttons_couleur;
	
	
	public Buttons(Canva canva) {
		this.buttons_rotation = new Rotation(canva.getFigure());
		this.buttons_translation = new Translation(canva.getFigure());
		this.buttons_zoom = new Zoom(canva.getFigure());
		this.bouttons_couleur = new ColorPane(canva);

		this.getChildren().addAll(buttons_rotation, new VBox(buttons_translation,buttons_zoom, bouttons_couleur));
		//this.setStyle("-fx-border-width: 2px; -fx-border-color: blue;");

	}

}
