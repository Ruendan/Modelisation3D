package view.buttons;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.GridPane;
import view.CanvasFigure;

public class TransparencyPane extends GridPane{
	
	private static final double MIN_WIDTH = 0.0;
	private static final double MAX_WIDTH = 1.0;

	public TransparencyPane(CanvasFigure canva) {
		super();
		
		final Slider opacify;
		final Label title;
		final ToggleSwitch colorSwitch;
		final ToggleSwitch shadowSwitch;
		final ToggleSwitch faceSwitch;
		
		title = new Label("Transparence des Faces");
		
		this.setPadding(new Insets(10,0,10,30));
		this.setHgap(10);
		this.setVgap(10);
		
		opacify = new Slider(MIN_WIDTH,MAX_WIDTH, canva.getFigureOpacity());
		opacify.setShowTickMarks(true);
		opacify.valueProperty().addListener((observable, oldValue, newValue) -> canva.setFigureOpacity((double)newValue));
		
		shadowSwitch = new ToggleSwitch("Ombre propre");
		shadowSwitch.selectedProperty().addListener((observable, oldValue, newValue) -> canva.setShadowView((boolean)newValue));
		shadowSwitch.setValue(true);
		
		faceSwitch = new ToggleSwitch("Affichage des faces");
		faceSwitch.selectedProperty().addListener((observable, oldValue, newValue) -> canva.setFaceVisible((boolean)newValue));
		faceSwitch.setValue(true);
		
		colorSwitch = new ToggleSwitch("Couleurs Custom");
		colorSwitch.selectedProperty().addListener((observable, oldValue, newValue) -> canva.setCouleurCustom((boolean)newValue));
		colorSwitch.setValue(false);
		
		this.add(title, 0, 0);
		this.add(opacify, 0, 1);
		this.add(shadowSwitch, 0, 4);
		this.add(faceSwitch, 0, 2);
		this.add(colorSwitch, 0, 5);
		
		GridPane.setHalignment(title, HPos.CENTER);
	}
}
