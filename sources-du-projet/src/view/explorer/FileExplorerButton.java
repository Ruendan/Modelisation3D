package view.explorer;

import java.io.File;

import javafx.scene.control.Button;
import utils.Icon;

public class FileExplorerButton extends Button{
	
	public FileExplorerButton(Explorer items) {
		super("",Icon.createButtonIcon("newFile"));

		this.setOnAction(e -> items.addFile(this.getFile()));
	}
	
	/**
	 * 
	 * @return The File that the user will chose through a "wizard".
	 */
	private File getFile() {
		return FileChooser.pathSelector();
	}

}
