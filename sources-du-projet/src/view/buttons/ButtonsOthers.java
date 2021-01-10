package view.buttons;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import modele.modelisation.Figure;
import view.CanvasFigure;

/**
 * This class gathers all the others buttons panel together
 * <p>This class is used to call the creation of all the buttons that modify the properties of the {@link Figure} </p>
 * @author Groupe G1
 */
public class ButtonsOthers extends VBox {	
	/**
	 * Create the HBox that contains all the others buttons panels
	 * @param canva
	 * 			The canvas that the buttons are linked to
	 */
	public ButtonsOthers(CanvasFigure canva) {
		super();
		final GridPane bouttonsCouleur, bouttonsEpaisseur,bouttonsTransparency;

		bouttonsCouleur = ButtonsFactory.makeButton("Color", canva);
		bouttonsTransparency = ButtonsFactory.makeButton("Transparency", canva);
		bouttonsEpaisseur = ButtonsFactory.makeButton("Thickness", canva);
		
		this.getChildren().addAll(new VBox(bouttonsCouleur, bouttonsTransparency, bouttonsEpaisseur));
		this.setStyle("-fx-background-color: #f1f1f1;");

		setMargin(bouttonsTransparency, new Insets(10,20,20,20));
		setMargin(bouttonsCouleur, new Insets(10,20,10,20));

		this.setAlignment(Pos.TOP_CENTER);
		this.setPadding(new Insets(20));
	}
}
