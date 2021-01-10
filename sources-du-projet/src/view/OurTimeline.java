package view;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

/**
 * Creation of timeline attributes
 * <p>This class is used to store all the timeline's attributes</p>
 * @author Groupe G1
 */
public class OurTimeline {
	
	protected static double tempsActualisation = 0.05;
	protected static double xRotationValue = 5;
	protected static double yRotationValue = 5;
	protected static double zRotationValue = 5;
	
	private Timeline timeline;
	private boolean running;
	private final CanvasFigure canva;
	
	public boolean isRunning() {
		return running;
	}
	
	public OurTimeline(CanvasFigure canva) {
		super();
		this.canva = canva;
		running = false;
		resetTimeline();
	}

	public void resetTimeline() {
		if(timeline!=null) timeline.stop();
		timeline = new Timeline(new KeyFrame(Duration.seconds(tempsActualisation), e -> {
			canva.getFigure().rotate(xRotationValue, yRotationValue, zRotationValue);
		}));
		timeline.setCycleCount(Animation.INDEFINITE);
		timeline.setAutoReverse(true);
	}
	
	public void play() {
		running = true;
		timeline.play();
	}
	
	public void stop() {
		running = false;
		timeline.stop();
	}
	
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
