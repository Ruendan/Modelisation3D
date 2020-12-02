package view.explorer;

import java.io.File;

import javafx.scene.control.Button;

public class FileExplorerButton extends Button{

	public File getFile() {
		return FileChooser.pathSelector();
	}

}
