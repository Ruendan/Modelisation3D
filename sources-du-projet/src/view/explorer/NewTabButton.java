package view.explorer;

import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import modele.modelisation.Figure;
import modele.parser.exception.PlyParserException;
import utils.Icon;
import view.View;

public class NewTabButton extends Button{
	
	public NewTabButton(String parent) {
		super("",Icon.createButtonIcon("newWindow"));
		Tooltip.install(this, new Tooltip("Créer une nouvelle fenêtre"));
		this.setOnAction(e -> {
			try {
				openNewWindow(parent);
			} catch (PlyParserException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
	}
	
	private void openNewWindow(String parent) throws PlyParserException {
		View vv = new View();
		vv.updateMiddle(new Figure(parent));
	}
}
