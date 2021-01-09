package view.buttons;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import modele.modelisation.Figure;
import view.CanvasFigure;

/**
 * This class gathers all the control buttons panel together
 * <p>This class is used to call the creation of all the buttons that control the {@link Figure} </p>
 * @author Groupe G1
 */
public class ButtonsControls extends HBox {
	
	private GridPane buttons_rotation, buttons_translation, buttons_zoom;
	
	/**
	 * Create the HBox that contains all the control buttons panels
	 * @param canva
	 * 			The canvas that the buttons are linked to
	 */
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
