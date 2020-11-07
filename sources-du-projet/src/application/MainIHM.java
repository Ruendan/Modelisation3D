package application;

import javafx.application.Application;
import javafx.stage.Stage;
import modele.modelisation.Figure;
import modele.parser.PlyParser;
import view.View;

public class MainIHM extends Application {
	
	public static void main(String[] args) {
		Application.launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		Figure fig = new Figure(PlyParser.loadPly("bethoveen"));

		new View(fig);
	}
}
