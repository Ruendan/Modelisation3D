package view.buttons;

import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import view.Canva;

public class LineWidthPane extends BorderPane{
	
	private Slider thicken;
	
	private static final double MIN_WIDTH = 0.1;
	private static final double MAX_WIDTH = 1.0;

	public LineWidthPane(Canva canva) {
		this.thicken = new Slider(MIN_WIDTH,MAX_WIDTH, canva.getFigureLineWidth());
		thicken.valueProperty().addListener((observable, oldValue, newValue) -> canva.setFigureLineWidth((double)newValue));
		
		this.setCenter(thicken);
	}
}
