package view.buttons;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import modele.modelisation.Figure;
import view.ButtonsConst;

public class Zoom extends GridPane{
	
	private Button In,Out;
	private Label title;
	
	public Zoom(Figure fig){
		
		title = new Label("   Zoom   ");
		title.setStyle(ButtonsConst.getLabelStyle());
		
		this.In = new Button("+");
		In.setOnAction(e->{
			fig.zoom(1+ButtonsConst.getVALEUR_DE_ZOOM());
		});
		this.In.setPrefSize(ButtonsConst.getButtonSize(),ButtonsConst.getButtonSize());
		this.In.setStyle(ButtonsConst.getButtonStyle());
		
		this.Out = new Button("-");
		Out.setOnAction(e->{
			fig.zoom(1-ButtonsConst.getVALEUR_DE_ZOOM());
		});
		this.Out.setPrefSize(ButtonsConst.getButtonSize(),ButtonsConst.getButtonSize());
		this.Out.setStyle(ButtonsConst.getButtonStyle());
		
		
		this.setPadding(new Insets(10,0,10,30));
		this.setHgap(10);
		this.setVgap(10);
		this.setGridLinesVisible(true);
		
		this.add(In, 0, 1);
		this.add(Out, 2, 1);
		
		this.setStyle(ButtonsConst.getPaneStyle());		
		this.setPrefWidth(190);
	}
}

