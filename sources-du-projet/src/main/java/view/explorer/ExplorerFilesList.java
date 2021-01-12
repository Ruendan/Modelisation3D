package view.explorer;

import java.io.File;
import java.io.FileNotFoundException;

import javafx.scene.control.ListView;
import modele.modelisation.Figure;
import modele.modelisation.Ply;
import modele.parser.exception.PlyParserException;
import utils.ErrorSceneUtils;
import view.View;

/**
 * Creation the layout of the explorer
 * <p>This class is used to create the zoom-in and zoom-out buttons linked to the {@link Figure}</p>
 * @author Groupe G1
 */
public class ExplorerFilesList extends ListView<PlyFile>{
	
	private final File lib = new File("./resources/plys");
	private final File[] files = lib.listFiles();
	
	/**
	 * The Layout made to display the FileExplorer.
	 * It's a VBox regrouping the Explorer and the FileChoser.
	 * @param parent
	 * 			The {@link View} to add the explorer and toolbar to
	 */
	public ExplorerFilesList(View parent){
		super();
		for (final File file : this.files) {
			try {
				this.getItems().add(new PlyFile(file));
			} catch (PlyParserException | FileNotFoundException e) {
				ErrorSceneUtils.display(e);
			}
		}
		this.getSelectionModel().selectedItemProperty().addListener((observable, oldvalue, newvalue) -> {
			try {
				//System.out.println("Bon, Alors");
				final Ply newPly = newvalue.getPly();
				if(oldvalue!=null) oldvalue.unload();
				if(newPly != null) parent.updateMiddle(new Figure(newPly));
			} catch (PlyParserException | FileNotFoundException e) {
				ErrorSceneUtils.display(e);
			}
		});
	}

	public boolean addFile(File file) {
		if(file == null) return false;
		if(file.getName().contains(".ply"))  //Demeter ?
			try {
				return this.getItems().add(new PlyFile(file));
			} catch (PlyParserException | FileNotFoundException e) {
				ErrorSceneUtils.display(e);
			}
		return false;
	}
}


