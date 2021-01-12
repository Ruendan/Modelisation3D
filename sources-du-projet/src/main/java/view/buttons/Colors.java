package view.buttons;

import javafx.geometry.Pos;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import view.Painter;

/**
 * Creation of colors buttons
 * <p>This class is used to create the buttons that modify the colors in the {@link CanvasFigure}</p>
 * @author Groupe G1
 */
public class Colors extends GridPane{
	
	private final ColorPicker figureColorPicker, canvaColorPicker;
	

	/**
	 * Create the colors buttons panel linked to {@link Figure}
	 * @param canva
	 * 			The {@link CanvasFigure} that need to be colored
	 */
	public Colors(Painter painter) {
		super();
		final Label titleCP1, titleCP2;
		
		titleCP1 = new Label("Couleur de fond");
		titleCP2 = new Label("Couleur de face");
		
		this.canvaColorPicker = new ColorPicker(painter.getCanvaFillColor());
		canvaColorPicker.setOnAction(e -> painter.setCanvaFillColor(canvaColorPicker.getValue()));
		this.figureColorPicker = new ColorPicker(painter.getFigureFillColor());
		figureColorPicker.setOnAction(e -> painter.setFigureFillColor(figureColorPicker.getValue()));
		
		
		this.setHgap(10);
		this.setVgap(10);
		
		this.add(titleCP1, 0, 0);
		this.add(canvaColorPicker, 0, 1);
		this.add(titleCP2, 0, 2);
		this.add(figureColorPicker, 0, 3);
		
		this.setAlignment(Pos.CENTER);
	}
}
