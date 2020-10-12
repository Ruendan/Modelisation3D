package vue;

import java.io.File;
import javafx.scene.control.ListView;
import modele.Ply;

public class Explorer{
	
	File lib = new File("C:\\Users\\natht\\eclipse-workspace\\projetmode-g1\\sources-du-projet\\ressources\\plys");
	String[] files = lib.list();
	
	
	
	public static void main(String[] args) {
		Explorer gg = new Explorer();
		

		for (String ss : gg.files) {
			System.out.println(ss);
		}
	}
}


