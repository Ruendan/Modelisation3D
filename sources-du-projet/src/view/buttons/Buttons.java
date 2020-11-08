package view.buttons;

import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import modele.modelisation.Figure;

public class Buttons extends HBox {
	
	private Rotation buttons_rotation;
	private Translation buttons_translation;
	private Zoom buttons_zoom;
	
	public Buttons(Figure fig) {
		this.buttons_rotation = new Rotation(fig);
		this.buttons_translation = new Translation(fig);
		this.buttons_zoom = new Zoom(fig);

		this.getChildren().addAll(buttons_rotation, new VBox(buttons_translation,buttons_zoom));
		//buttons.setStyle("-fx-border-width: 2px; -fx-border-color: blue;");

	}

}
