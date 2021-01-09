package view.buttons;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import modele.modelisation.Figure;
import view.CanvasFigure;

/**
 * This class gathers all the others buttons panel together
 * <p>This class is used to call the creation of all the buttons that modify the properties of the {@link Figure} </p>
 * @author Groupe G1
 */
public class ButtonsOthers extends HBox {
	
	private GridPane bouttons_couleur, bouttons_epaisseur,bouttons_transparency;
	
	/**
	 * Create the HBox that contains all the others buttons panels
	 * @param canva
	 * 			The canvas that the buttons are linked to
	 */
	public ButtonsOthers(CanvasFigure canva) {

		this.bouttons_couleur = ButtonsFactory.makeButton("Color", canva);
		this.bouttons_epaisseur = ButtonsFactory.makeButton("Thickness", canva);
		this.bouttons_transparency = ButtonsFactory.makeButton("Transparency", canva);		

		this.getChildren().addAll(new VBox(bouttons_couleur, bouttons_epaisseur,bouttons_transparency));
		this.setStyle("-fx-background-color: #f1f1f1;");
		this.setPrefWidth(200);
	}
}
