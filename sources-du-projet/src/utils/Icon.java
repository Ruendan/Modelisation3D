package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

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
