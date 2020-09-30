package vue;

import java.util.List;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;
import modele.Figure;

public class Vue extends Stage{
	Figure fig;
	public Vue(Figure figure) {
		this.fig=figure;
		List<Double[]> allCoord = this.fig.initialisation();
		Polygon[] pol= new Polygon[allCoord.size()]; 
		Group root = new Group();
		for(int i=0; i<allCoord.size();i++) {
			pol[i] = getPolygon(allCoord.get(i));
		}

		root.getChildren().addAll(pol);
		Scene scene = new Scene(root,1000,1000);
		this.setScene(scene);
		this.show();
	}
	
	
	private Polygon getPolygon(Double[] coord) {
		Polygon poly = new Polygon();
		poly.setFill(Color.rgb(135,206,250,0.7));
		poly.getPoints().setAll(coord);
		poly.setStroke(Color.BLACK);
		poly.setStrokeWidth(2);
		return poly;
	}

}
