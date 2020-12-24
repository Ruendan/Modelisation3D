package view.buttons;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import view.ButtonsConst;
import view.CanvasFigure;

public class ButtonTimeline extends Button {

	CanvasFigure canva;
	
	private static ImageView play,pause;
	
	public ButtonTimeline(CanvasFigure canva) {
		play = new ImageView(new Image(getClass().getResourceAsStream("imgs/play.png")));
		pause = new ImageView(new Image(getClass().getResourceAsStream("imgs/pause.png")));
		
		this.canva = canva;
		this.setGraphic((canva.isRotating()?pause:play));
		this.setOnAction(e -> onClick());
		this.setStyle(ButtonsConst.getButtonStyle());
	}
	
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
