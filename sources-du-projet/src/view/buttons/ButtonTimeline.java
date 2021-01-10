package view.buttons;

import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import utils.IconConstants;
import view.ButtonsConstants;
import view.CanvasFigure;

/**
 * Creation of the auto-rotate button
 * <p>This class is used to create the automatic rotation button linked to the {@link Figure}</p>
 * @author Groupe G1
 */
public class ButtonTimeline extends Button {

	private final CanvasFigure canva;
	
	private static final ImageView PLAY = IconConstants.createButtonIcon("play"), PAUSE = IconConstants.createButtonIcon("pause");
	
	/**
	 * Create the automatic rotation button linked to {@link Figure}
	 * @param canva
	 * 			The {@link CanvasFigure} that need to auto-rotate
	 */
	public ButtonTimeline(CanvasFigure canva) {
		super();
		
		this.canva = canva;
		this.setGraphic((canva.isRotating()?PAUSE:PLAY));
		this.setOnAction(e -> onClick());
		this.setStyle(ButtonsConstants.getButtonStyle());
	}
	
	public void onClick() {
		if(canva.isRotating()) {
			canva.stopRotation();
			this.setGraphic(PLAY);
		}else {
			canva.startRotation();
			this.setGraphic(PAUSE);
		}
	}
}
