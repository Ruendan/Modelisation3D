package view.buttons;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.GridPane;
import view.Canva;

public class LineWidthPane extends GridPane{
	
	private Slider thicken;
	private Label title;

	private static final double MIN_WIDTH = 0.1;
	private static final double MAX_WIDTH = 1.0;

	public LineWidthPane(Canva canva) {
		
		title = new Label("  Epaisseur du trait  ");
		title.setStyle(Buttons_control.LABEL_STYLE);
		
		this.setPadding(new Insets(10,0,10,30));
		this.setHgap(10);
		this.setVgap(10);
		
		this.thicken = new Slider(MIN_WIDTH,MAX_WIDTH, canva.getFigureLineWidth());
		thicken.setShowTickMarks(true);
		thicken.valueProperty().addListener((observable, oldValue, newValue) -> canva.setFigureLineWidth((double)newValue));
		
		this.add(title, 1, 0);
		this.add(thicken, 1, 1);
		
		this.setStyle(Buttons_control.PANE_STYLE);
		this.setPrefWidth(250);
	}
}
