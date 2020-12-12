package view.explorer;

import java.io.File;

import javafx.scene.control.Button;

public class FileExplorerButton extends Button{

	private static final String BUTTONTEXT = "Load new File";
	
	public FileExplorerButton() {
		super(BUTTONTEXT);
	}
	
	/**
	 * 
	 * @return The File that the user will chose through a "wizard".
	 */
	public File getFile() {
		return FileChooser.pathSelector();
	}

}
