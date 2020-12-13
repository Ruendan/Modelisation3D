package view.explorer;

import javafx.scene.control.Button;
import modele.parser.exception.PlyParserException;
import view.View;

public class NewTabButton extends Button{
	public NewTabButton() {
		super("Open a new Window");
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
