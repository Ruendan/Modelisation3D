package vue;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class View extends Stage{
	
	public View() {
		Buttons buttons = new Buttons();
		Explorer explorer = new Explorer();
		
		
		BorderPane bb = new BorderPane();
		bb.getChildren();
		
		Scene mainScene = new Scene(bb, 1000, 1000);
		this.setScene(mainScene);
		this.show();
	}
}
