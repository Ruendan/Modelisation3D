package view.explorer;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;

import view.errors.ErrorSceneConstants;

/**
 * Open the file chooser
 * <p>Open a configured system file explorer that allows the user to choose its own ply files</p>
 * 
 * @author Groupe G1
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
	 * Open the system's file explorer
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
}

