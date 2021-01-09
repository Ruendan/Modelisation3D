package view.buttons;

import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import modele.modelisation.Figure;
import utils.IconConstants;
import view.ButtonsConstants;

public class Zoom extends GridPane{
	
	
	private static final ImageView INIMG = IconConstants.createButtonIcon("plus"),
			LESSIMG = IconConstants.createButtonIcon("less");
	
	public Zoom(Figure fig){
		super();
		
		final Button in,out;
		
		in = new Button("", INIMG);
		in.setOnAction(e->{
			fig.zoom(1+ButtonsConstants.getValeurZoom());
		});
		in.setPrefSize(ButtonsConstants.getButtonSize(),ButtonsConstants.getButtonSize());
		in.setStyle(ButtonsConstants.getButtonStyle());
		
		out = new Button("", LESSIMG);
		out.setOnAction(e->{
			fig.zoom(1-ButtonsConstants.getValeurZoom());
		});
		out.setPrefSize(ButtonsConstants.getButtonSize(),ButtonsConstants.getButtonSize());
		out.setStyle(ButtonsConstants.getButtonStyle());
		
		this.setHgap(10);
		this.setVgap(10);
		//this.setGridLinesVisible(true);
		
		this.add(in, 0, 0);
		this.add(out, 2, 0);
		
		//this.setStyle(ButtonsConst.getPaneStyle());
		this.setMaxHeight(50);
	}
}

