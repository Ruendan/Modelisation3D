package view.buttons;

import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import utils.IconConstants;
import view.ButtonsConstants;
import view.CanvasFigure;

public class ButtonTimeline extends Button {

	private final CanvasFigure canva;
	
	private static final ImageView PLAY = IconConstants.createButtonIcon("play"), PAUSE = IconConstants.createButtonIcon("pause");
	
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
