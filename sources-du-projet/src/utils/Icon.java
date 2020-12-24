package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Icon {

	public static final String BUTTONICONSFOLDER = "sources-du-projet\\ressources\\imgs\\buttons_icons\\";
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
