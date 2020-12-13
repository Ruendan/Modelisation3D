package view.explorer;

import javafx.scene.control.Button;
import view.View;

public class NewTabButton extends Button{
	public NewTabButton() {
		super();
		this.setOnAction(e -> new View(null));
	}
}
