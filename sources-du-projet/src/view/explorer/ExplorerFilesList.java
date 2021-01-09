package view.explorer;

import java.io.File;

import javafx.scene.control.ListView;
import modele.modelisation.Figure;
import modele.modelisation.Ply;
import modele.parser.exception.PlyParserException;
import view.View;
import view.errors.ErrorScene;

/**
 * Creation of the files list in the explorer
 * <p>This class is used to create the list of file in the explorer and allow to select others models </p>
 * @author Groupe G1
 */
public class ExplorerFilesList extends ListView<PlyFile>{
	
	File lib = new File("ressources/plys");
	File[] files = lib.listFiles();
	
	/**
	 * Create the explorer's list and define the on-click behavior of it
	 * @param parent
	 * 			The {@link View} to update when the user click on a model
	 */
	public ExplorerFilesList(View parent){
		for (File file : this.files) {
			try {
				this.getItems().add(new PlyFile(file));
			} catch (PlyParserException e) {
				ErrorScene.display(e);
			}
		}
		this.getSelectionModel().selectedItemProperty().addListener((observable, oldvalue, newvalue) -> {
			try {
				Ply newPly = newvalue.getPly();
				if(oldvalue!=null) oldvalue.unload();
				if(newPly != null) parent.updateMiddle(new Figure(newPly));
			} catch (PlyParserException e) {
				ErrorScene.display(e);
			}
		});
	}

	/**
	 * Adds a model to the explorer's list
	 * @param file
	 * 			The {@link File} to add to the list
	 */
	public boolean addFile(File file) {
		if(file == null) return false;
		if(file.getName().contains(".ply"))
			try {
				return this.getItems().add(new PlyFile(file));
			} catch (PlyParserException e) {
				ErrorScene.display(e);
			}
		return false;
	}
}


