package view.buttons;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import modele.modelisation.Figure;

public class Zoom extends GridPane{
	
	private Button In,Out;
	private Label title;
	
	public Zoom(Figure fig){
		
		title = new Label("   Zoom   ");
		title.setStyle(Buttons_control.LABEL_STYLE);
		
		this.In = new Button("+");
		In.setOnAction(e->{
			fig.zoom(1+Buttons_control.VALEUR_DE_ZOOM);
		});
		this.In.setPrefSize(Buttons_control.BUTTON_SIZE,Buttons_control.BUTTON_SIZE);
		this.In.setStyle(Buttons_control.BUTTON_STYLE);
		
		this.Out = new Button("-");
		Out.setOnAction(e->{
			fig.zoom(1-Buttons_control.VALEUR_DE_ZOOM);
		});
		this.Out.setPrefSize(Buttons_control.BUTTON_SIZE,Buttons_control.BUTTON_SIZE);
		this.Out.setStyle(Buttons_control.BUTTON_STYLE);
		
		
		this.setPadding(new Insets(10,0,10,30));
		this.setHgap(10);
		this.setVgap(10);
		this.setGridLinesVisible(true);
		
		this.add(In, 0, 1);
		this.add(Out, 2, 1);
		
		this.setStyle(Buttons_control.PANE_STYLE);		
		this.setPrefWidth(190);
	}
}

