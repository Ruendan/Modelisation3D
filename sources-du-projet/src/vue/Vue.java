package vue;

import java.util.List;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;
import modele.Face;
import modele.Figure;
import modele.Point;
import modele.modelisation.Matrix;

public class Vue extends Stage {
	Figure fig;
	
	
	public Vue(Figure figure) {
		this.fig = figure;
		List<Face> allCoord = this.fig.initialisation();
		Polygon[] pol = new Polygon[allCoord.size()];
		Group root = new Group();
		for (int i = 0; i < allCoord.size(); i++) {
			Double[] coord = convert3d2d((fig.getPly().getFaces().get(i)));
			pol[i] = getPolygon(coord);
		}

		root.getChildren().addAll(pol);
		Scene scene = new Scene(root, 500, 500);
		this.setScene(scene);
		this.show();
	}

	private Polygon getPolygon(Double[] coord) {
		Polygon poly = new Polygon();
		poly.setFill(Color.rgb(135, 206, 250, 1));
		poly.getPoints().setAll(coord);
		poly.setStroke(Color.BLACK);
		poly.setStrokeWidth(2);
		return poly;
	}

	private Double[] convert3d2d(Face face) {
		Double[] coord = new Double[(face.getNbPoints() * 2)];
		for (int j = 0; j < face.getPoints().size(); j++) {
			Point test = Matrix.transformation(fig.getPly().getPoints().get((int) (double) face.getPoints().get(j)));
			coord[j * 2] = test.getX();
			coord[j * 2 + 1] = test.getY();
		}
		return coord;
	}

}
