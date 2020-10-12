package vue;

import java.io.File;

public class Explorer{
	
	File lib = new File("ressources/plys");
	String[] files = lib.list();
	
	
	
	public static void main(String[] args) {
		Explorer gg = new Explorer();
		

		for (String ss : gg.files) {
			System.out.println(ss);
		}
	}
}


