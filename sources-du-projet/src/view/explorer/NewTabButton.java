package view.explorer;

import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import modele.parser.exception.PlyParserException;
import utils.Icon;
import view.View;

public class NewTabButton extends Button{
	
	public NewTabButton() {
		super("",Icon.createButtonIcon("newWindow"));
		Tooltip.install(this, new Tooltip("Créer une nouvelle fenêtre"));
		this.setOnAction(e -> openNewWindow());
	}
	
	private void openNewWindow() {
		try {
			new View();
		} catch (PlyParserException e1) {
			e1.printStackTrace();
		}
	}
}
