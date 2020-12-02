package view.explorer;

import java.io.File;

import javafx.scene.control.ListView;
import modele.modelisation.Ply;
import modele.parser.PlyParser;
import modele.parser.exception.PlyParserException;

public class Explorer extends ListView<PlyFile>{
	
	File lib = new File("ressources/plys");
	File[] files = lib.listFiles();
	
	public Explorer(CustomChangeListener gg){
		Ply convertedInPly;
		for (File file : this.files) {
			
			try {
				convertedInPly = PlyParser.loadHeader(file);
				this.getItems().add(new PlyFile(file, convertedInPly));
			} catch (PlyParserException e) {
				e.printStackTrace();
			}
		}

		this.getSelectionModel().selectedItemProperty().addListener(gg);
	}

//	public boolean addFile(File file) {
//		if(file == null) return false;
//		
//	}
	
}


