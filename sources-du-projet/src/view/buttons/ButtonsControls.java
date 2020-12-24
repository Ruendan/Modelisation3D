package view.buttons;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import view.CanvasFigure;

public class ButtonsControls extends HBox {
	
	private GridPane buttons_rotation, buttons_translation, buttons_zoom;
	
	public ButtonsControls(CanvasFigure canva) {
	
		this.buttons_rotation = ButtonsFactory.makeButton("Rotation", canva);
		this.buttons_translation = ButtonsFactory.makeButton("Translation", canva);
		this.buttons_zoom = ButtonsFactory.makeButton("Zoom", canva);

		this.getChildren().addAll(buttons_rotation, new VBox(buttons_translation,buttons_zoom));
		//this.setStyle("-fx-border-width: 2px; -fx-border-color: blue;");

	}
}
