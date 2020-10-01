package vue;

import java.util.List;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.util.Duration;
import modele.Face;
import modele.Figure;
import modele.Point;
import modele.modelisation.Matrix;

public class GroupedVue extends Group {

	Figure fig;
	Timeline timeline;
	public GroupedVue(Figure figure) {
		this.fig = figure;
		this.getChildren().addAll(this.getPolygone());
		timeline= new Timeline(new KeyFrame(Duration.seconds(0.1), e -> {
			fig.rotate(1, 1, 1);
			this.getChildren().remove(0);
			this.getChildren().addAll(this.getPolygone());
		}));
		timeline.setCycleCount(Animation.INDEFINITE);
		timeline.setAutoReverse(true);
		timeline.play();
    	
	}

	private Polygon getPolygon(Double[] coord) {
		Polygon poly = new Polygon();
		poly.setFill(Color.rgb(135, 206, 250, 1));
		poly.getPoints().setAll(coord);
		poly.setStroke(Color.BLACK);
		poly.setStrokeWidth(0.5);
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
	
	public Figure getFigure() {
		return this.fig;
	}
	
	public Polygon[] getPolygone() {
		List<Face> allCoord = this.fig.initialisation();
		Polygon[] pol = new Polygon[allCoord.size()];
		for (int i = 0; i < allCoord.size(); i++) {
			Double[] coord = convert3d2d((fig.getPly().getFaces().get(i)));
			pol[i] = getPolygon(coord);
		}
		return pol;
	}
}
