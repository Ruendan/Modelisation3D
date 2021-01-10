package utils;

/**
 * Create an {@link Icon} from image's name
 * <p>This class is used to create a usable Icon for buttons just by giving its name (images need to be in the buttons_icones folder)</p>
 * @author Groupe G1
 */
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class IconConstants {

	private static String fs = File.separator;
	public static final String BUTTONICONSFOLDER = "ressources"+fs+"imgs"+fs+"buttons_icons"+fs;
	public static final String EXTENSION = ".png";
	
	public static ImageView createButtonIcon(String imgName) {
		ImageView res = null;
		
		final Path path = Paths.get(BUTTONICONSFOLDER+imgName+EXTENSION);
		
		try {
			res = new ImageView(new Image(Files.newInputStream(path)));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return res;
	}
}
