package view.explorer;

import javafx.scene.control.Button;
import modele.parser.exception.PlyParserException;
import utils.Icon;
import view.View;

public class NewTabButton extends Button{
	public NewTabButton() {
		super("",Icon.createButtonIcon("newWindow"));
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
