package view.explorer;

import java.io.File;

import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import utils.IconConstants;

public class FileExplorerButton extends Button{
	
	public FileExplorerButton(Explorer items) {
		super("",IconConstants.createButtonIcon("newFile"));
		Tooltip.install(this, new Tooltip("Ouvrir un nouveau fichier"));
		this.setOnAction(e -> items.addFile(this.getFile()));
	}
	
	/**
	 * 
	 * @return The File that the user will chose through a "wizard".
	 */
	private File getFile() {
		return FileChooserUtils.pathSelector();
	}

}
