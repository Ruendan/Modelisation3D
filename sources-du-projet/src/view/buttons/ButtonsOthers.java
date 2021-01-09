package view.buttons;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import view.CanvasFigure;

public class ButtonsOthers extends HBox {
	
	public ButtonsOthers(CanvasFigure canva) {
		super();
		final GridPane bouttonsCouleur, bouttonsEpaisseur,bouttonsTransparency;
		
		bouttonsCouleur = ButtonsFactory.makeButton("Color", canva);
		bouttonsTransparency = ButtonsFactory.makeButton("Transparency", canva);
		bouttonsEpaisseur = ButtonsFactory.makeButton("Thickness", canva);
			

		this.getChildren().addAll(new VBox(bouttonsCouleur, bouttonsTransparency, bouttonsEpaisseur));
		this.setStyle("-fx-background-color: #f1f1f1;");
		this.setPrefWidth(250);
	}
}
