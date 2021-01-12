package application;

import javafx.application.Application;
import javafx.stage.Stage;
import modele.modelisation.Figure;
import view.View;

public class MainIHM extends Application { //vraiment utile le constructeur ici ?
	
	public static void main(String[] args) {
		Application.launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		final Figure fig = new Figure("bethoveen");
		new View(fig);
	}
}
