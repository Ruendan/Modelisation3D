package view.buttons;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import view.CanvasFigure;

public class ButtonsOthers extends HBox {
	
	private GridPane bouttons_couleur, bouttons_epaisseur,bouttons_transparency;
	
	public ButtonsOthers(CanvasFigure canva) {

		this.bouttons_couleur = ButtonsFactory.makeButton("Color", canva);
		this.bouttons_epaisseur = ButtonsFactory.makeButton("Thickness", canva);
		this.bouttons_transparency = ButtonsFactory.makeButton("Transparency", canva);		

		this.getChildren().addAll(new VBox(bouttons_couleur, bouttons_epaisseur,bouttons_transparency));
		//this.setStyle("-fx-border-width: 2px; -fx-border-color: blue;");

	}
}
