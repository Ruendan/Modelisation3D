package application;

import javafx.application.Application;
import javafx.stage.Stage;
import modele.Figure;
import modele.PlyParser;
import vue.View;
import vue.Vue;

public class MainIHM extends Application {
	
	public static void main(String[] args) {
		Application.launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		Figure fig = new Figure(PlyParser.loadPly("cube-wtriangle"));
		//Figure fig = new Figure();
		new View(fig);
	}
}
