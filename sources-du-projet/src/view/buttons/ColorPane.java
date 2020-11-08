package view.buttons;


import javafx.scene.control.ColorPicker;
import javafx.scene.layout.BorderPane;
import view.Canva;

public class ColorPane extends BorderPane{
	
	private ColorPicker figureColorPicker;
	private ColorPicker canvaColorPicker;

	public ColorPane(Canva canva) {
		this.canvaColorPicker = new ColorPicker(canva.getCanvaFillColor());
		canvaColorPicker.setOnAction(e -> canva.setCanvaFillColor(canvaColorPicker.getValue()));
		this.figureColorPicker = new ColorPicker(canva.getFigureFillColor());
		figureColorPicker.setOnAction(e -> canva.setFigureFillColor(figureColorPicker.getValue()));
		
		this.setLeft(figureColorPicker);
		this.setRight(canvaColorPicker);
	}
	
	
	
}
