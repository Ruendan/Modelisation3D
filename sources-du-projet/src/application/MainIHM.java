package application;

import javafx.application.Application;
import javafx.stage.Stage;
import modele.Figure;
import modele.parser.PlyParser;
import vue.View;

public class MainIHM extends Application {
	
	public static void main(String[] args) {
		Application.launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		Figure fig = new Figure(PlyParser.loadPly("bethoveen"));
		//Figure fig = new Figure();
		new View(fig);
	}
}
