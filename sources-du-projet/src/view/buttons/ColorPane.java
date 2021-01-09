package view.buttons;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import view.CanvasFigure;

public class ColorPane extends GridPane{
	
	private final ColorPicker figureColorPicker, canvaColorPicker;
	

	public ColorPane(CanvasFigure canva) {
		super();
		final Label titleCP1, titleCP2;
		
		titleCP1 = new Label("Couleur de fond");
		titleCP2 = new Label("Couleur de face");
		
		this.canvaColorPicker = new ColorPicker(canva.getCanvaFillColor());
		canvaColorPicker.setOnAction(e -> canva.setCanvaFillColor(canvaColorPicker.getValue()));
		this.figureColorPicker = new ColorPicker(canva.getFigureFillColor());
		figureColorPicker.setOnAction(e -> canva.setFigureFillColor(figureColorPicker.getValue()));
		
		
		this.setPadding(new Insets(10,0,10,30));
		this.setHgap(10);
		this.setVgap(10);
		
		this.add(titleCP1, 0, 0);
		this.add(canvaColorPicker, 0, 1);
		this.add(titleCP2, 0, 2);
		this.add(figureColorPicker, 0, 3);
		
		GridPane.setHalignment(titleCP1, HPos.CENTER);
		GridPane.setHalignment(titleCP2, HPos.CENTER);
	}
}
