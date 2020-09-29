package vue;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class TestVue extends Stage{

	public TestVue() {
		this.setScene(new Scene(new HBox(new Button("AHHH"))));
		this.show();
	}
}
