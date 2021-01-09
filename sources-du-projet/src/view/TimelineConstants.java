package view;

public class TimelineConstants {
	
	protected static double tempsActualisation = 0.05;
	protected static double xRotationValue = 5;
	protected static double yRotationValue = 5;
	protected static double zRotationValue = 5;
	
	public static void setXRotationValue(double value) {
		xRotationValue = value;
	}
	
	public static void setYRotationValue(double value) {
		yRotationValue = value;
	}
	
	public static void setZRotationValue(double newValue) {
		zRotationValue = newValue;
	}
	
	public static double getTempsdactualisation() {
		return tempsActualisation;
	}
	
	public static double getDefaultx() {
		return xRotationValue;
	}
	
	public static double getDefaulty() {
		return yRotationValue;
	}
	
	public static double getDefaultz() {
		return zRotationValue;
	}

	public static void setTempsdactualisation(double seconds) {
		tempsActualisation = seconds;
		
	}
	
	
}
