package view.explorer;

import java.io.File;

import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import utils.IconConstants;

/**
 * Creation of the file explorer button
 * <p>This class is used to create the file explorer buttons to add a file to the list</p>
 * @author Groupe G1
 */
public class FileExplorerButton extends Button{
	
	/**
	 * Create the explorer button to add an item to the {@link ExplorerFilesList}
	 * @param fig
	 * 			The {@link ExplorerFilesList} to add the new file to
	 */
	public FileExplorerButton(Explorer items) {
		super("",IconConstants.createButtonIcon("newFile"));
		Tooltip.install(this, new Tooltip("Ouvrir un nouveau fichier"));
		this.setOnAction(e -> items.addFile(this.getFile()));
	}
	
	/**
	 * Open system's file explorer
	 * @return The File that the user will choose .
	 */
	private File getFile() {
		return FileChooserUtils.pathSelector();
	}

}
