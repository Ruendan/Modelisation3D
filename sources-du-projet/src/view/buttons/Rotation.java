package view.buttons;

import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import modele.modelisation.Figure;
import utils.IconConstants;
import view.ButtonsConstants;
import view.CanvasFigure;

/**
 * Creation of rotation buttons
 * <p>This class is used to create the rotation buttons linked to the {@link Figure}</p>
 * @author Groupe G1
 */
public class Rotation extends GridPane{
	
	/**
	 * Create the rotation buttons panel linked to {@link Figure}
	 * @param fig
	 * 			The {@link Figure} the buttons are linked to
	 */
	public Rotation(CanvasFigure canva){
		super();
		final Button xup,xdown,yup,ydown,zup,zdown;
		
		xup = createButton("xUp");
		xup.setOnAction(e ->canva.getFigure().rotateX(ButtonsConstants.getValeurRotation()));
		
		
		xdown = createButton("xDown");
		xdown.setOnAction(e ->canva.getFigure().rotateX(-ButtonsConstants.getValeurRotation()));
		
		yup = createButton("yUp");
		yup.setOnAction(e ->canva.getFigure().rotateY(ButtonsConstants.getValeurRotation()));
		
		ydown = createButton("yDown");
		ydown.setOnAction(e ->canva.getFigure().rotateY(-ButtonsConstants.getValeurRotation()));
		
		zup = createButton("zUp");
		zup.setOnAction(e ->canva.getFigure().rotateZ(ButtonsConstants.getValeurRotation()));
		
		zdown = createButton("zUp");
		zdown.setOnAction(e ->canva.getFigure().rotateZ(-ButtonsConstants.getValeurRotation()));
		
		this.setHgap(10);
		this.setVgap(20);
		
		this.add(xup, 0, 0); this.add(xdown, 2, 0);
		this.add(yup, 0, 1); this.add(ydown, 2, 1);
		this.add(zup, 0, 2); this.add(zdown, 2, 2);

		final ButtonTimeline autoRotate = new ButtonTimeline(canva);
		this.add(autoRotate, 1, 3);
	
		this.setMaxHeight(250);
	}
	/**
	 * Create a rotation button with an image
	 * @param imgName
	 * 			The image's name
	 * @return {@link Button}
	 * 			The button with its image
	 */
	private Button createButton(String imgName) {
		Button res;
		final ImageView img = IconConstants.createButtonIcon(imgName);
		
		res = new Button("",img);
		res.setPrefSize(ButtonsConstants.getButtonSize(),ButtonsConstants.getButtonSize());
		res.setStyle(ButtonsConstants.getButtonStyle());
		
		return res;
	}
}

