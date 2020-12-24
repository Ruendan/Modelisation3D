package view.buttons;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import modele.modelisation.Figure;
import utils.Icon;
import view.ButtonsConst;

public class Zoom extends GridPane{
	
	private Button in,out;
	private static ImageView inImg,lessImg;
	
	public Zoom(Figure fig){
		inImg = Icon.createButtonIcon("plus");
		lessImg = Icon.createButtonIcon("less");
		
		this.in = new Button("", inImg);
		in.setOnAction(e->{
			fig.zoom(1+ButtonsConst.getVALEUR_DE_ZOOM());
		});
		this.in.setPrefSize(ButtonsConst.getButtonSize(),ButtonsConst.getButtonSize());
		this.in.setStyle(ButtonsConst.getButtonStyle());
		
		this.out = new Button("", lessImg);
		out.setOnAction(e->{
			fig.zoom(1-ButtonsConst.getVALEUR_DE_ZOOM());
		});
		this.out.setPrefSize(ButtonsConst.getButtonSize(),ButtonsConst.getButtonSize());
		this.out.setStyle(ButtonsConst.getButtonStyle());
		
		
		this.setPadding(new Insets(10,0,10,30));
		this.setHgap(10);
		this.setVgap(10);
		this.setGridLinesVisible(true);
		
		this.add(in, 0, 0);
		this.add(out, 2, 0);
		
		this.setStyle(ButtonsConst.getPaneStyle());		
		this.setPrefWidth(190);
	}
}

