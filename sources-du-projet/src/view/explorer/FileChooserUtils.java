package view.explorer;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;

import view.errors.ErrorSceneConstants;

/**
 * 
 * @author Dubois Quentin, Camus Sylvain
 * 
 * @apiNote Thank to Sylvain, who already had this kind 
 * of problem to solve. It's mainly its work that i 
 * applied to our case. (But luckily, he's working
 * on this project too)
 *
 */
public final class FileChooserUtils {
	
	/**
	 * A private constructor, making the Class uninstanciable.
	 */
	private FileChooserUtils() {};
	
	/**
	 * 
	 * @return the File that will be chosen by the user.
	 */
	public static File pathSelector() { //sert a choisir des données externe.
		
		File res = null;
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch(Exception ex) {
			ErrorSceneConstants.display(ex);
		}
		
		final JFileChooser chooser = new JFileChooser();
		chooser.setDialogTitle("Selectionnez le Fichier PLY à ajouter");
		chooser.setAcceptAllFileFilterUsed(false);
		chooser.addChoosableFileFilter(new FileNameExtensionFilter("PLY Files", "ply"));
		chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		final int returnVal = chooser.showOpenDialog(chooser);
		if(returnVal == JFileChooser.APPROVE_OPTION) {
			res = chooser.getSelectedFile();
		}
		return res;
	}
	
	
	/**
	 * Enjoy the test !
	 * @param args
	 */
	public static void main() {
		final File f = pathSelector();
		System.out.println(f);
	}
}

