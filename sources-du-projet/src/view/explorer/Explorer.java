package view.explorer;

import java.io.File;

import javafx.scene.control.ListView;
import modele.modelisation.Figure;
import view.View;

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

		this.getSelectionModel().selectedItemProperty().addListener((observable, oldvalue, newvalue) -> parent.createRight(new Figure(newvalue.getPly())));
	}

	public boolean addFile(File file) {
		if(file == null) return false;
		if(file.getName().contains(".ply")) return this.getItems().add(new PlyFile(file));
		else return false;
	}
}


