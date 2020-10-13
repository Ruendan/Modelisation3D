package view;

import java.util.ArrayList;
import java.util.List;

import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import modele.modelisation.Face;
import modele.modelisation.Figure;
import modele.modelisation.Matrix;
import modele.modelisation.Point;
import utils.Observer;
import utils.Subject;

public class GroupedVue extends Group implements Observer{

	Figure fig;
	Timeline timeline;
	
	public GroupedVue(Figure figure) {
		figure.attach(this);
		this.fig = figure;
		
		
		
		this.getChildren().addAll(this.getFigure());
		
		/*
		timeline= new Timeline(new KeyFrame(Duration.seconds(0.033333), e -> {
			fig.tri();
			Mouvement.rotate(fig, 1, 1, 1);
			this.getChildren().clear();
			this.getChildren().addAll(this.getFigure());
		}));
		timeline.setCycleCount(Animation.INDEFINITE);
		timeline.setAutoReverse(true);
		
		timeline.play();
		*/
    	
	}

	private Polygon getPolygon(Double[] coord,  Face f) {
		Polygon poly = new Polygon();

		poly.setFill(Color.rgb(135, 206, 250, 1));
		poly.getPoints().setAll(coord);
		poly.setStroke(Color.BLACK);
		poly.setStrokeWidth(0.2);
		return poly;
	}

	private Double[] convert3d2d(Face face) {
		Double[] coord = new Double[(face.getNbPoints() * 2)];
		for (int j = 0; j < face.getPoints().size(); j++) {
			Point test = Matrix.transformation(face.getPoints().get(j));
			coord[j * 2] = test.getX();
			coord[j * 2 + 1] = test.getY();
		}	
		return coord;
	}
	
	public List<Polygon> getFigure() {
		List<Polygon> pol = new ArrayList<Polygon>();
		
		for(Face f : fig.getFaces()) {
			Double[] coord = convert3d2d((f));
			pol.add(getPolygon(coord,f));
		}
		return pol;
	}

	@Override
	public void update(Subject subj) {
		fig.tri();
		this.getChildren().clear();
		this.getChildren().addAll(this.getFigure());
	}

	@Override
	public void update(Subject subj, Object data) {
		fig.tri();
		this.getChildren().clear();
		this.getChildren().addAll(this.getFigure());
	}
}
