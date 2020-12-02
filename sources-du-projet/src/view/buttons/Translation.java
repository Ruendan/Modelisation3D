package view.buttons;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import modele.modelisation.Figure;

public class Translation extends GridPane{
	
	private Button up,down,left,right;
	
	public Translation(Figure fig){
		
		this.up = new Button("↑");
		up.setOnAction(e->fig.VDeplace(-ButtonsConst.VALEUR_DE_DEPLACEMENT));
		this.down = new Button("↓");
		
		down.setOnAction(e->{
			fig.VDeplace(ButtonsConst.VALEUR_DE_DEPLACEMENT);
		});
		
		this.up.setPrefSize(ButtonsConst.BUTTON_SIZE,ButtonsConst.BUTTON_SIZE);
		this.down.setPrefSize(ButtonsConst.BUTTON_SIZE,ButtonsConst.BUTTON_SIZE);
		this.up.setStyle(ButtonsConst.BUTTON_STYLE);
		this.down.setStyle(ButtonsConst.BUTTON_STYLE);
		
		this.left = new Button("←");
		left.setOnAction(e->{
			fig.HDeplace(-ButtonsConst.VALEUR_DE_DEPLACEMENT);
		});
		this.right = new Button("→");	
		right.setOnAction(e->{
			fig.HDeplace(ButtonsConst.VALEUR_DE_DEPLACEMENT);
		});
		this.left.setPrefSize(ButtonsConst.BUTTON_SIZE,ButtonsConst.BUTTON_SIZE);
		this.right.setPrefSize(ButtonsConst.BUTTON_SIZE,ButtonsConst.BUTTON_SIZE);
		this.left.setStyle(ButtonsConst.BUTTON_STYLE);
		this.right.setStyle(ButtonsConst.BUTTON_STYLE);
		
		this.setPadding(new Insets(10,0,10,10));
		this.setHgap(10);
		this.setVgap(10);
		this.setGridLinesVisible(true);
	
		this.add(up, 1, 1);
		this.add(left, 0, 2);
		this.add(right, 2, 2);
		this.add(down, 1, 3);
		
		this.setStyle(ButtonsConst.PANE_STYLE);		
		this.setPrefWidth(190);
	}
}

