package view.buttons;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import modele.modelisation.Figure;

public class Zoom extends GridPane implements Buttons_control{
	
	private Button In,Out;
	private Label title;
	
	public Zoom(Figure fig){
		
		this.setPadding(new Insets(10,0,10,30));
		this.setHgap(10);
		this.setVgap(10);
		
		title = new Label("   Zoom   ");
		title.setStyle(LABEL_STYLE);
		
		this.In = new Button("+");
		In.setOnAction(e->{
			fig.zoom(1+VALEUR_DE_ZOOM);
		});
		this.In.setPrefSize(BUTTON_SIZE,BUTTON_SIZE);
		this.In.setStyle(BUTTON_STYLE);
		
		this.Out = new Button("-");
		Out.setOnAction(e->{
			fig.zoom(1-VALEUR_DE_ZOOM);
		});
		this.Out.setPrefSize(BUTTON_SIZE,BUTTON_SIZE);
		this.Out.setStyle(BUTTON_STYLE);
		
		this.add(title, 1, 0);
		this.add(In, 0, 1);
		this.add(Out, 2, 1);
		
		this.setStyle(PANE_STYLE);		
		this.setPrefWidth(200);
	}
}

