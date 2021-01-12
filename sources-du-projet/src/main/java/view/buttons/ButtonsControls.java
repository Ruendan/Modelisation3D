package view.buttons;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import view.CanvasFigure;

/**
 * This class gathers all the control buttons panel together
 * <p>This class is used to call the creation of all the buttons that control the {@link Figure} </p>
 * @author Groupe G1
 */
public class ButtonsControls extends HBox {
	
	/**
	 * Create the HBox that contains all the control buttons panels
	 * @param canva
	 * 			The canvas that the buttons are linked to
	 */
	public ButtonsControls(CanvasFigure canva) {
		super();
		final GridPane buttonsRotation, buttonsTranslation, buttonsZoom;
		
		buttonsRotation = ButtonsFactory.makeButton("Rotation", canva);
		buttonsTranslation = ButtonsFactory.makeButton("Translation", canva);
		buttonsZoom = ButtonsFactory.makeButton("Zoom", canva);
		buttonsZoom.setAlignment(Pos.BOTTOM_RIGHT);
		
		this.getChildren().addAll(buttonsRotation, buttonsTranslation,buttonsZoom);		
		
		this.setPadding(new Insets(5,0,0,10));
		this.setMaxSize(400, 250);
		
	}
}
