package view.buttons;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import modele.modelisation.Figure;
import view.ButtonsConst;

public class Zoom extends GridPane{
	
	private Button In,Out;
	private static ImageView Plus,Less;
	
	public Zoom(Figure fig){
		Plus = new ImageView(new Image(getClass().getResourceAsStream("imgs/plus.png")));
		Less = new ImageView(new Image(getClass().getResourceAsStream("imgs/less.png")));
		
		this.In = new Button("", Plus);
		In.setOnAction(e->{
			fig.zoom(1+ButtonsConst.getVALEUR_DE_ZOOM());
		});
		this.In.setPrefSize(ButtonsConst.getButtonSize(),ButtonsConst.getButtonSize());
		this.In.setStyle(ButtonsConst.getButtonStyle());
		
		this.Out = new Button("", Less);
		Out.setOnAction(e->{
			fig.zoom(1-ButtonsConst.getVALEUR_DE_ZOOM());
		});
		this.Out.setPrefSize(ButtonsConst.getButtonSize(),ButtonsConst.getButtonSize());
		this.Out.setStyle(ButtonsConst.getButtonStyle());
		
		
		this.setPadding(new Insets(10,0,10,30));
		this.setHgap(10);
		this.setVgap(10);
		this.setGridLinesVisible(true);
		
		this.add(In, 0, 0);
		this.add(Out, 2, 0);
		
		this.setStyle(ButtonsConst.getPaneStyle());		
		this.setPrefWidth(190);
	}
}

