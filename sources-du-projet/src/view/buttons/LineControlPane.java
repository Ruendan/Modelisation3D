package view.buttons;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.GridPane;
import view.CanvasFigure;

public class LineControlPane extends GridPane{

	private static final double MIN_WIDTH = 0.001;
	private static final double MAX_WIDTH = 1.0;

	public LineControlPane(CanvasFigure canva) {
		super();
		
		final Slider thicken;
		final Label title;
		final ToggleSwitch tswitch;
		
		title = new Label("Epaisseur des arêtes");
		
		this.setPadding(new Insets(10,0,10,30));
		this.setHgap(10);
		this.setVgap(10);
		
		thicken = new Slider(MIN_WIDTH,MAX_WIDTH, canva.getFigureLineWidth());
		thicken.setShowTickMarks(true);
		thicken.valueProperty().addListener((observable, oldValue, newValue) -> canva.setFigureLineWidth((double)newValue));

		tswitch = new ToggleSwitch("Afficher les arêtes");
		tswitch.selectedProperty().addListener((observable, oldValue, newValue) -> canva.setAllEdgeVisible(newValue));
		
		this.add(tswitch, 0, 0);
		this.add(title, 0, 1);
		this.add(thicken, 0, 2);
		
		
		GridPane.setHalignment(title, HPos.CENTER);
	}
}
