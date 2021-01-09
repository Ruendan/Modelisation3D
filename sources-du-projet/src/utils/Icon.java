package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Create an {@link Icon} from image's name
 * <p>This class is used to create a usable Icon for buttons just by giving its name (images need to be in the buttons_icones folder)</p>
 * @author Groupe G1
 */
public class Icon {

	private static String fs = File.separator;
	public static final String BUTTONICONSFOLDER = "ressources"+fs+"imgs"+fs+"buttons_icons"+fs;
	public static final String EXTENSION = ".png";
	
	public static ImageView createButtonIcon(String imgName) {
		ImageView res = null;
		
		try {
			res = new ImageView(new Image(new FileInputStream(BUTTONICONSFOLDER+imgName+EXTENSION)));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return res;
	}
}
