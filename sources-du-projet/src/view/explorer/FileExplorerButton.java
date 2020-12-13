package view.explorer;

import java.io.File;

import javafx.scene.control.Button;

public class FileExplorerButton extends Button{

	private static final String BUTTONTEXT = "Load new File";
	
	public FileExplorerButton(Explorer items) {
		super(BUTTONTEXT);

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
