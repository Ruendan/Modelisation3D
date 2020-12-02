package view;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.UIManager;

public class FileChooser {
	
	private FileChooser() {};
	
	public static File pathSelector() { //sert a choisir des données externe
		
		File res = null;
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		
		JFileChooser chooser = new JFileChooser();
		chooser.setDialogTitle("Selectionnez le dossier Content");
		chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		int returnVal = chooser.showOpenDialog(chooser);
		if(returnVal == JFileChooser.APPROVE_OPTION) {
			res = chooser.getSelectedFile();
		}
		return res;
	}

	public static void main(String[] args) {
		File f = pathSelector();
		System.out.println(f);
		
	}
}

