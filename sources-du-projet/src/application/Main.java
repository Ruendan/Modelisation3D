package application;

import javafx.application.Application;
import javafx.stage.Stage;
import modele.Figure;
import modele.Vecteur;
import modele.parser.PlyParser;
import vue.Vue;

public class Main extends Application {
	
	public static void main(String[] args) {
		Application.launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		System.out.println(new Vecteur(1,1,1));
		Figure fig = new Figure(PlyParser.loadPly("cube-wtriangle"));
		//Figure fig = new Figure();
		new Vue(fig);
	}
}
