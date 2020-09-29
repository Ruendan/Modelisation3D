package application;

import javafx.application.Application;
import javafx.stage.Stage;
import vue.TestVue;

public class Main extends Application {
	
	public static void main(String[] args) {
		Application.launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		new TestVue();
	}
}
