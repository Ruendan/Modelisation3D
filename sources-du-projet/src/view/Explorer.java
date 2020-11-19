package view;

import java.io.File;

import javafx.scene.control.ListView;
import modele.modelisation.Ply;
import modele.parser.PlyParser;
import modele.parser.exception.PlyParserException;

public class Explorer extends ListView<String>{
	
	File lib = new File("ressources/plys");
	String[] files = lib.list();
	
	public Explorer(CustomChangeListener gg){
		Ply convertedInPly;
		for (String file : this.files) {
			file = file.substring(0, file.length()-4);
			
			try {
				convertedInPly = PlyParser.loadPly(file);
				this.getItems().add(convertedInPly.getName()+ " : " +convertedInPly.getNbFace() + " faces");
			} catch (PlyParserException e) {
				e.printStackTrace();
			}
		}

		this.getSelectionModel().selectedItemProperty().addListener(gg);
	}
	
}


