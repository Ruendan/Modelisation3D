package view.buttons;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.GridPane;
import modele.modelisation.Figure;
import view.CanvasFigure;

/**
 * Creation of the slider that handle the opacity of the {@link Figure}
 * <p>This class is used to create the slider that modify the opacity of the {@link Figure}'s faces</p>
 * @author Groupe G1
 */
public class Transparency extends GridPane{
	
	private Slider opacity;
	private Label title;

	private static final double MIN_WIDTH = 0.0;
	private static final double MAX_WIDTH = 1.0;

	/**
	 * Create the opacity slider panel linked to {@link Figure}
	 * @param canva
	 * 			The {@link CanvasFigure} that has the faces
	 */
	public Transparency(CanvasFigure canva) {
		
		title = new Label("Transparence des Faces");
		
		this.setPadding(new Insets(10,0,10,30));
		this.setHgap(10);
		this.setVgap(10);
		
		this.opacity = new Slider(MIN_WIDTH,MAX_WIDTH, canva.getFigureOpacity());
		opacity.setShowTickMarks(true);
		opacity.valueProperty().addListener((observable, oldValue, newValue) -> canva.setFigureOpacity((double)newValue));
		
		this.add(title, 0, 0);
		this.add(opacity, 0, 1);
		
		GridPane.setHalignment(title, HPos.CENTER);
	}
}
