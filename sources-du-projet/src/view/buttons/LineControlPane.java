package view.buttons;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.GridPane;
import view.Painter;

/**
 * Creation of buttons that handle lines
 * <p>This class is used to create the buttons that modify the width of the lines and permit to show them or not</p>
 * @author Groupe G1
 */
public class LineControlPane extends GridPane{

	private static final double MIN_WIDTH = 0.001;
	private static final double MAX_WIDTH = 1.0;

	/**
	 * Create the lines buttons panel linked to {@link Figure}
	 * @param canva
	 * 			The {@link CanvasFigure} that has the lines
	 */
	public LineControlPane(Painter painter) {
		super();
		
		final Slider thicken;
		final Label title;
		final ToggleSwitch tswitch;
		final ToggleSwitch iSwitch;
		
		title = new Label("Epaisseur des arêtes");
		
		this.setHgap(10);
		this.setVgap(10);
		
		thicken = new Slider(MIN_WIDTH,MAX_WIDTH, 0.15);
		thicken.setShowTickMarks(true);
		thicken.valueProperty().addListener((observable, oldValue, newValue) -> painter.setFigureLineWidth((double)newValue));

		tswitch = new ToggleSwitch("Afficher les arêtes");
		tswitch.selectedProperty().addListener((observable, oldValue, newValue) -> painter.setAllEdgeVisible(newValue));
		tswitch.setValue(false);
		
		iSwitch = new ToggleSwitch("Mode Performance");
		iSwitch.selectedProperty().addListener((observable, oldValue, newValue) -> painter.setLowImpact(newValue));
		iSwitch.setValue(false);
		
		this.add(tswitch, 0, 0);
		this.add(title, 0, 1);
		this.add(thicken, 0, 2);
		this.add(iSwitch, 0, 3);
		
		this.setAlignment(Pos.CENTER);
	}
}
