package view.buttons;

import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import modele.modelisation.Figure;
import utils.Icon;
import view.ButtonsConst;
import view.CanvasFigure;

/**
 * Creation of the auto-rotate button
 * <p>This class is used to create the automatic rotation button linked to the {@link Figure}</p>
 * @author Groupe G1
 */
public class Timeline extends Button {

	CanvasFigure canva;
	
	private static ImageView play,pause;
	
	/**
	 * Create the automatic rotation button linked to {@link Figure}
	 * @param canva
	 * 			The {@link CanvasFigure} that need to auto-rotate
	 */
	public Timeline(CanvasFigure canva) {
		play = Icon.createButtonIcon("play");
		pause = Icon.createButtonIcon("pause");
		
		this.canva = canva;
		this.setGraphic((canva.isRotating()?pause:play));
		this.setOnAction(e -> onClick());
		this.setStyle(ButtonsConst.getButtonStyle());
	}
	
	/**
	 * Defines the behavior of the automatic rotation when clicked
	 */
	public void onClick() {
		if(canva.isRotating()) {
			canva.stopRotation();
			this.setGraphic(play);
		}else {
			canva.startRotation();
			this.setGraphic(pause);
		}
	}
}
