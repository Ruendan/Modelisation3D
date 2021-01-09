package view.buttons;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import view.CanvasFigure;

public class ButtonsControls extends HBox {
	
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
