package view;

public class ButtonsConst {
	
	protected static double VALEUR_DE_ZOOM = 0.05;
	protected static double VALEUR_DE_DEPLACEMENT_X = 10;
	protected static double VALEUR_DE_DEPLACEMENT_Y = 10;
	
	protected static int VALEUR_DE_ROTATION_X = 10;
	protected static int VALEUR_DE_ROTATION_Y = 10;
	protected static int VALEUR_DE_ROTATION_Z = 10;
	
	protected static final int BUTTON_SIZE = 48;
	
	public static double getVALEUR_DE_ZOOM() {
		return VALEUR_DE_ZOOM;
	}
	public static void setVALEUR_DE_ZOOM(double vALEUR_DE_ZOOM) {
		VALEUR_DE_ZOOM = vALEUR_DE_ZOOM;
	}
	
	public static double getVALEUR_DE_DEPLACEMENT_X() {
		return VALEUR_DE_DEPLACEMENT_X;
	}
	
	public static double getVALEUR_DE_DEPLACEMENT_Y() {
		return VALEUR_DE_DEPLACEMENT_Y;
	}
	
	public static void setVALEUR_DE_DEPLACEMENT_X(double value) {
		VALEUR_DE_DEPLACEMENT_X = value;
	}
	
	public static void setVALEUR_DE_DEPLACEMENT_Y(double value) {
		VALEUR_DE_DEPLACEMENT_Y = value;
	}
	
	
	public static int getVALEUR_DE_ROTATION_X() {
		return VALEUR_DE_ROTATION_X;
	}
	
	public static int getVALEUR_DE_ROTATION_Y() {
		return VALEUR_DE_ROTATION_Y;
	}
	
	public static int getVALEUR_DE_ROTATION_Z() {
		return VALEUR_DE_ROTATION_Z;
	}
	
	public static void setVALEUR_DE_ROTATION_X(int value) {
		VALEUR_DE_ROTATION_X = value;
	}
	
	public static void setVALEUR_DE_ROTATION_Y(int value) {
		VALEUR_DE_ROTATION_Y = value;
	}
	
	public static void setVALEUR_DE_ROTATION_Z(int value) {
		VALEUR_DE_ROTATION_Z = value;
	}
	
	protected static final String BUTTON_STYLE = "-fx-background-color: black; -fx-background-radius: 50; -fx-text-fill: white; -fx-font: 15 arial;";
	protected static final String PANE_STYLE = "-fx-border-width: 4px; -fx-border-color: white; -fx-background-color: slategrey; -fx-background-radius: 25; -fx-border-radius:25;";
	protected static final String LABEL_STYLE = "-fx-text-fill: white; -fx-font: 13 arial; -fx-font-weight:bold; -fx-border-width:3px; -fx-border-color:white; -fx-border-radius:5";

	public static int getButtonSize() {
		return BUTTON_SIZE;
	}
	public static String getButtonStyle() {
		return BUTTON_STYLE;
	}
	public static String getPaneStyle() {
		return PANE_STYLE;
	}
	public static String getLabelStyle() {
		return LABEL_STYLE;
	}

	
}
