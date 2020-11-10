package view.buttons;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import view.Canva;

public class Buttons extends HBox {
	
	private GridPane buttons_rotation, buttons_translation, buttons_zoom;
	private ColorPane bouttons_couleur;
	private LineWidthPane bouttons_eppaisseur;
	
	public Buttons(Canva canva) {
		this.buttons_rotation = ButtonFactory.makeButton("Rotation", canva.getFigure());
		this.buttons_translation = ButtonFactory.makeButton("Translation", canva.getFigure());
		this.buttons_zoom = ButtonFactory.makeButton("Zoom", canva.getFigure());
		this.bouttons_couleur = new ColorPane(canva);
		this.bouttons_eppaisseur = new LineWidthPane(canva);
		

		this.getChildren().addAll(buttons_rotation, new VBox(buttons_translation,buttons_zoom), new VBox(bouttons_couleur, bouttons_eppaisseur));
		//this.setStyle("-fx-border-width: 2px; -fx-border-color: blue;");

	}
}
