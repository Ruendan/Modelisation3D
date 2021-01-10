package view.buttons;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import view.CanvasFigure;

public class ButtonsOthers extends VBox {
	
	public ButtonsOthers(CanvasFigure canva) {
		super();
		final GridPane bouttonsCouleur, bouttonsEpaisseur,bouttonsTransparency;
		
		bouttonsCouleur = ButtonsFactory.makeButton("Color", canva);
		bouttonsTransparency = ButtonsFactory.makeButton("Transparency", canva);
		bouttonsEpaisseur = ButtonsFactory.makeButton("Thickness", canva);
			
		this.getChildren().addAll(new VBox(bouttonsCouleur, bouttonsTransparency, bouttonsEpaisseur));
		this.setStyle("-fx-background-color: #f1f1f1;");
		
		this.setAlignment(Pos.CENTER);
		setMargin(bouttonsTransparency, new Insets(10,20,20,20));
		setMargin(bouttonsCouleur, new Insets(20,20,10,20));
		//this.setPadding(new Insets(20));
		
	}
}
