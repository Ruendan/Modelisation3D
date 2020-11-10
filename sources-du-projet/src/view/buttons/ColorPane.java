package view.buttons;

import javafx.geometry.Insets;
import javafx.scene.control.ColorPicker;
import javafx.scene.layout.GridPane;
import view.Canva;

public class ColorPane extends GridPane implements Buttons_control{
	
	private ColorPicker figureColorPicker;
	private ColorPicker canvaColorPicker;

	public ColorPane(Canva canva) {
		
		this.setPadding(new Insets(10,0,10,30));
		this.setHgap(10);
		this.setVgap(10);
		
		this.canvaColorPicker = new ColorPicker(canva.getCanvaFillColor());
		canvaColorPicker.setOnAction(e -> canva.setCanvaFillColor(canvaColorPicker.getValue()));
		this.figureColorPicker = new ColorPicker(canva.getFigureFillColor());
		figureColorPicker.setOnAction(e -> canva.setFigureFillColor(figureColorPicker.getValue()));
		
		this.add(canvaColorPicker, 1, 0);
		this.add(figureColorPicker, 0, 1);
		
		this.setStyle(PANE_STYLE);
		this.setPrefWidth(200);
	}
}
