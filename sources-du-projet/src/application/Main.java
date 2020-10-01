package application;

import javafx.application.Application;
import javafx.stage.Stage;
import modele.Figure;
import modele.PlyParser;
import vue.TestVue;

public class Main extends Application {
	
	public static void main(String[] args) {
		Application.launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		Figure fig = new Figure(PlyParser.loadPly("cube"));
		//Figure fig = new Figure();
		new TestVue(fig);

	}
}
