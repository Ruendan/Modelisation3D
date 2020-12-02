package view.buttons;

import javafx.scene.control.Button;
import view.CanvasFigure;

public class ButtonTimeline extends Button {
	
	CanvasFigure canva; 

	private static final String TEXTSTART = "START";
	private static final String TEXTSTOP = "STOP";
	
	public ButtonTimeline(CanvasFigure canva) {
		this.canva = canva;
		this.setText((canva.isRotating()?TEXTSTOP:TEXTSTART));
		this.setOnAction(e -> onClick());
	}
	
	public void onClick() {
		if(canva.isRotating()) {
			canva.stopRotation();
			this.setText(TEXTSTART);
		}else {
			canva.startRotation();
			this.setText(TEXTSTOP);
		}
	}
}
