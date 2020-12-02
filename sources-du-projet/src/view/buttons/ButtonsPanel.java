package view.buttons;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import view.Canva;

public class ButtonsPanel extends HBox {
	
	private GridPane buttons_rotation, buttons_translation, buttons_zoom, bouttons_couleur, bouttons_epaisseur;
	
	public ButtonsPanel(Canva canva) {
	
		this.buttons_rotation = ButtonsFactory.makeButton("Rotation", canva);
		this.buttons_translation = ButtonsFactory.makeButton("Translation", canva);
		this.buttons_zoom = ButtonsFactory.makeButton("Zoom", canva);
		this.bouttons_couleur = ButtonsFactory.makeButton("Color", canva);
		this.bouttons_epaisseur = ButtonsFactory.makeButton("Thickness", canva);		

		this.getChildren().addAll(buttons_rotation, new VBox(buttons_translation,buttons_zoom), new VBox(bouttons_couleur, bouttons_epaisseur));
		//this.setStyle("-fx-border-width: 2px; -fx-border-color: blue;");

	}
}
