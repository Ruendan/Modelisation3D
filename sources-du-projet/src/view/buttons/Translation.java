package view.buttons;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import modele.modelisation.Figure;

public class Translation extends GridPane implements Buttons_control{
	
	private Button up,down,left,right;
	private Label title;
	
	public Translation(Figure fig){
		
		this.up = new Button("↑");
		up.setOnAction(e->{
			fig.VDeplace(-VALEUR_DE_DEPLACEMENT);;
		});		
		this.down = new Button("↓");
		down.setOnAction(e->{
			fig.VDeplace(VALEUR_DE_DEPLACEMENT);
		});
		this.up.setPrefSize(BUTTON_SIZE,BUTTON_SIZE); this.down.setPrefSize(BUTTON_SIZE,BUTTON_SIZE);
		this.up.setStyle(BUTTON_STYLE); this.down.setStyle(BUTTON_STYLE);
		
		this.left = new Button("←");
		left.setOnAction(e->{
			fig.HDeplace(-VALEUR_DE_DEPLACEMENT);
		});
		this.right = new Button("→");	
		right.setOnAction(e->{
			fig.HDeplace(VALEUR_DE_DEPLACEMENT);
		});
		this.left.setPrefSize(BUTTON_SIZE,BUTTON_SIZE); this.right.setPrefSize(BUTTON_SIZE,BUTTON_SIZE);
		this.left.setStyle(BUTTON_STYLE); this.right.setStyle(BUTTON_STYLE);
		
		this.setPadding(new Insets(10,0,10,10));
		this.setHgap(10);
		this.setVgap(10);
		this.setGridLinesVisible(true);
	
		this.add(up, 1, 1);
		this.add(left, 0, 2);
		this.add(right, 2, 2);
		this.add(down, 1, 3);
		
		this.setStyle(PANE_STYLE);		
		this.setPrefWidth(190);
	}
}

