package vue;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import modele.modelisation.Figure;

public class TestVue extends Stage{
	
	public TestVue(Figure fig) {
		this.setScene(new Scene(new HBox(new Button("AHHH"))));
		
		//HBox root = new HBox();
		//root.getChildren().addAll(new GroupedVue(fig));
		
		Group root = new GroupedVue(fig);
		
		Scene scene = new Scene(root,500,500);
		this.setScene(scene);
		this.show();
	}
}
