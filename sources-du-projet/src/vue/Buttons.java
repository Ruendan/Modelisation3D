package vue;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class Buttons extends HBox{
	
	Button first, second, third;
	
	public Buttons(){
		this.first = new Button("Change X");
		this.second = new Button("Change Y");
		this.third = new Button("Change Z");
		
		this.getChildren().addAll(first, second, third);
		this.setStyle("-fx-border-width: 2px; -fx-border-color: red;");
	}
}
