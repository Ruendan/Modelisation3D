package view.buttons;

import javafx.geometry.Insets;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import view.Canva;

public class ColorPane extends GridPane implements Buttons_control{
	
	private ColorPicker figureColorPicker, canvaColorPicker;
	private Label titleCP1, titleCP2;

	public ColorPane(Canva canva) {
		
		this.titleCP1 = new Label("  Couleur de fond  ");
		this.titleCP2 = new Label("  Couleur de trait   ");
		this.titleCP1.setStyle(LABEL_STYLE);
		this.titleCP2.setStyle(LABEL_STYLE);
		
		this.canvaColorPicker = new ColorPicker(canva.getCanvaFillColor());
		canvaColorPicker.setOnAction(e -> canva.setCanvaFillColor(canvaColorPicker.getValue()));
		this.figureColorPicker = new ColorPicker(canva.getFigureFillColor());
		figureColorPicker.setOnAction(e -> canva.setFigureFillColor(figureColorPicker.getValue()));
		
		
		this.setPadding(new Insets(10,0,10,30));
		this.setHgap(10);
		this.setVgap(10);
		
		this.add(titleCP1, 2, 0);
		this.add(canvaColorPicker, 2, 1);
		this.add(titleCP2, 2, 2);
		this.add(figureColorPicker, 2, 3);
		
		this.setStyle(PANE_STYLE);
		this.setPrefWidth(250);
	}
}
