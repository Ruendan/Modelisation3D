package view.buttons;

import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import view.Canva;

public class LineWidthPane extends BorderPane{
	
	private Slider thicken;
	private Label thickenLabel;
	
	private static final String TEXT = "Thicken the line";
	private static final double MIN_WIDTH = 0.1;
	private static final double MAX_WIDTH = 1.0;

	public LineWidthPane(Canva canva) {
		this.thicken = new Slider(MIN_WIDTH,MAX_WIDTH, canva.getFigureLineWidth());
		thicken.setShowTickMarks(true);
		thicken.valueProperty().addListener((observable, oldValue, newValue) -> canva.setFigureLineWidth((double)newValue));

		this.thickenLabel = new Label(TEXT);
		
		this.setLeft(thickenLabel);
		this.setCenter(thicken);
	}
}
