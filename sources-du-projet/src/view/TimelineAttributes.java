package view;

/**
 * Creation of timeline constants
 * <p>This class is used to store all the timeline's constants</p>
 * @author Groupe G1
 */
public class TimelineAttributes {
	
	protected static double TEMPSDACTUALISATION = 0.05;
	protected static double XROTATIONVALUE = 5;
	protected static double YROTATIONVALUE = 5;
	protected static double ZROTATIONVALUE = 5;
	
	public static void setXRotationValue(double value) {
		XROTATIONVALUE = value;
	}
	
	public static void setYRotationValue(double value) {
		YROTATIONVALUE = value;
	}
	
	public static void setZRotationValue(double newValue) {
		ZROTATIONVALUE = newValue;
	}
	
	public static double getTempsdactualisation() {
		return TEMPSDACTUALISATION;
	}
	
	public static double getDefaultx() {
		return XROTATIONVALUE;
	}
	
	public static double getDefaulty() {
		return YROTATIONVALUE;
	}
	
	public static double getDefaultz() {
		return ZROTATIONVALUE;
	}

	public static void setTempsdactualisation(double seconds) {
		TEMPSDACTUALISATION = seconds;
		
	}
	
	
}
