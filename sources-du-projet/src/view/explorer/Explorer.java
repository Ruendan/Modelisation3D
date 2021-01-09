package view.explorer;

import java.io.File;
import java.io.FileNotFoundException;

import javafx.scene.control.ListView;
import modele.modelisation.Figure;
import modele.modelisation.Ply;
import modele.parser.exception.PlyParserException;
import view.View;
import view.errors.ErrorSceneConstants;

public class Explorer extends ListView<PlyFile>{
	
	private final File lib = new File("ressources/plys");
	private final File[] files = lib.listFiles();
	
	/**
	 * The Explorer.
	 * @param gg
	 */
	public Explorer(View parent){
		super();
		for (final File file : this.files) {
			try {
				this.getItems().add(new PlyFile(file));
			} catch (PlyParserException | FileNotFoundException e) {
				ErrorSceneConstants.display(e);
			}
		}
		this.getSelectionModel().selectedItemProperty().addListener((observable, oldvalue, newvalue) -> {
			try {
				//System.out.println("Bon, Alors");
				final Ply newPly = newvalue.getPly();
				if(oldvalue!=null) oldvalue.unload();
				if(newPly != null) parent.updateMiddle(new Figure(newPly));
			} catch (PlyParserException | FileNotFoundException e) {
				ErrorSceneConstants.display(e);
			}
		});
	}

	public boolean addFile(File file) {
		if(file == null) return false;
		if(file.getName().contains(".ply"))  //Demeter ?
			try {
				return this.getItems().add(new PlyFile(file));
			} catch (PlyParserException | FileNotFoundException e) {
				ErrorSceneConstants.display(e);
			}
		return false;
	}
}


