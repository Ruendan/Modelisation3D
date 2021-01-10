package view;

/**
 * Creation of buttons attributes
 * <p>This class is used to be able to refer to the same style/size/... for each buttons we create</p>
 * @author Groupe G1
 */
public class ButtonsUtils {
	
	protected static double valeurZoom = 0.05;
	protected static double valeurTranslation = 10;
	
	protected static int valeurRotation = 10;
	
	protected static final int BUTTON_SIZE = 48;

	protected static final String BUTTON_STYLE = "-fx-background-color: black; -fx-background-radius: 50; -fx-text-fill: white; -fx-font: 15 arial; -fx-border-width: 2px; -fx-border-color: white; -fx-border-radius:50;";
	
	public static double getValeurZoom() {
		return valeurZoom;
	}
	
	public static void setValeurZoom(double value) {
		valeurZoom = value;
	}
	
	public static double getValeurTranslation() {
		return valeurTranslation;
	}
	
	public static void setValeurTranslation(double value) {
		valeurTranslation = value;
	}
	
	public static int getValeurRotation() {
		return valeurRotation;
	}
	
	public static void setValeurRotation(int value) {
		valeurRotation = value;
	}
	
	public static int getButtonSize() {
		return BUTTON_SIZE;
	}
	public static String getButtonStyle() {
		return BUTTON_STYLE;
	}

	
}
