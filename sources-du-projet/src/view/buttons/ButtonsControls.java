package view.buttons;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import view.CanvasFigure;

public class ButtonsControls extends HBox {
	
	private GridPane buttons_rotation, buttons_translation, buttons_zoom;
	
	public ButtonsControls(CanvasFigure canva) {
	
		this.buttons_rotation = ButtonsFactory.makeButton("Rotation", canva);
		this.buttons_translation = ButtonsFactory.makeButton("Translation", canva);
		this.buttons_zoom = ButtonsFactory.makeButton("Zoom", canva);

		this.getChildren().addAll(buttons_rotation, buttons_translation,buttons_zoom);		
		
		this.setPadding(new Insets(5,0,0,10));
		this.setMaxSize(400, 250);
		this.buttons_zoom.setAlignment(Pos.BOTTOM_RIGHT);
	}
}
