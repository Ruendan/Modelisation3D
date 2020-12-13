package view.buttons;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.GridPane;
import view.CanvasFigure;

public class TransparencyPane extends GridPane{
	
	private Slider opacify;
	private Label title;

	private static final double MIN_WIDTH = 0.0;
	private static final double MAX_WIDTH = 1.0;

	public TransparencyPane(CanvasFigure canva) {
		
		title = new Label("  Transparence des Faces  ");
		title.setStyle(ButtonsConst.LABEL_STYLE);
		
		this.setPadding(new Insets(10,0,10,30));
		this.setHgap(10);
		this.setVgap(10);
		
		this.opacify = new Slider(MIN_WIDTH,MAX_WIDTH, canva.getFigureOpacity());
		opacify.setShowTickMarks(true);
		opacify.valueProperty().addListener((observable, oldValue, newValue) -> canva.setFigureOpacity((double)newValue));
		
		this.add(title, 1, 0);
		this.add(opacify, 1, 1);
		
		this.setStyle(ButtonsConst.PANE_STYLE);
		this.setPrefWidth(250);
	}
}
