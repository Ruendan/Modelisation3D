package view.explorer;

import java.io.File;

import javafx.scene.control.ListView;
import modele.modelisation.Figure;
import modele.modelisation.Ply;
import modele.parser.exception.PlyParserException;
import view.View;
import view.errors.ErrorScene;

public class Explorer extends ListView<PlyFile>{
	
	File lib = new File("ressources/plys");
	File[] files = lib.listFiles();
	
	/**
	 * The Explorer.
	 * @param gg
	 */
	public Explorer(View parent){
		for (File file : this.files) {
			this.getItems().add(new PlyFile(file));
		}
		
		this.getSelectionModel().selectedItemProperty().addListener((observable, oldvalue, newvalue) -> {
			try {
				Ply newPly = newvalue.getPly();
				if(oldvalue!=null) oldvalue.unload();
				System.out.println(newPly);
				if(newPly != null) parent.updateMiddle(new Figure(newPly));
			} catch (PlyParserException e) {
				ErrorScene.display(e);
			}
		});
		
	}

	public boolean addFile(File file) {
		if(file == null) return false;
		if(file.getName().contains(".ply")) return this.getItems().add(new PlyFile(file));
		else return false;
	}
}


