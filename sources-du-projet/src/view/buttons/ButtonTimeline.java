package view.buttons;

import javafx.scene.control.Button;
import view.Canva;

public class ButtonTimeline extends Button {
	
	private Canva canva; 

	private static final String TEXTSTART = ">";
	private static final String TEXTSTOP = "||";
	
	public ButtonTimeline(Canva canva) {
		this.canva = canva;
		this.setText((canva.isRotating()?TEXTSTOP:TEXTSTART));
		this.setOnAction(e -> onClick());
		this.setStyle(ButtonsConst.BUTTON_STYLE);
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
