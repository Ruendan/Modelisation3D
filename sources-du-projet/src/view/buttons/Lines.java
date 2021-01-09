package view.buttons;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.GridPane;
import modele.modelisation.Figure;
import view.CanvasFigure;

/**
 * Creation of buttons that handle lines
 * <p>This class is used to create the buttons that modify the width of the lines and permit to show them or not</p>
 * @author Groupe G1
 */
public class Lines extends GridPane{
	
	private Slider thicken;
	private Label title;
	private ToggleSwitch tswitch;

	private static final double MIN_WIDTH = 0.001;
	private static final double MAX_WIDTH = 1.0;

	/**
	 * Create the lines buttons panel linked to {@link Figure}
	 * @param canva
	 * 			The {@link CanvasFigure} that has the lines
	 */
	public Lines(CanvasFigure canva) {
		
		title = new Label("Epaisseur des arêtes");
		
		this.setPadding(new Insets(10,0,10,30));
		this.setHgap(10);
		this.setVgap(10);
		
		this.thicken = new Slider(MIN_WIDTH,MAX_WIDTH, canva.getFigureLineWidth());
		thicken.setShowTickMarks(true);
		thicken.valueProperty().addListener((observable, oldValue, newValue) -> canva.setFigureLineWidth((double)newValue));

		this.tswitch = new ToggleSwitch("Afficher les arêtes");
		tswitch.selectedProperty().addListener((observable, oldValue, newValue) -> canva.setAllEdgeVisible(newValue));
		
		
		this.add(title, 0, 0);
		this.add(thicken, 0, 1);
		this.add(tswitch, 0, 2);
		
		GridPane.setHalignment(title, HPos.CENTER);
	}
}
