package view;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javafx.scene.control.ListView;
import modele.modelisation.Ply;
import modele.parser.PlyParser;

public class Explorer extends ListView<String>{
	
	File lib = new File("ressources/plys");
	String[] files = lib.list();
	
	public Explorer(){
		for (String file : this.files) {
			file = file.substring(0, file.length()-4);
			Ply convertedInPly = PlyParser.loadPly(file);
			this.getItems().add(convertedInPly.getName()+ " : " +convertedInPly.getNbFace() + " faces");
		}
	}
}


