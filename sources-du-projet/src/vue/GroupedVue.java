package vue;

import java.util.ArrayList;

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
import modele.Mouvement;
import modele.Point;
import modele.modelisation.Matrix;

public class GroupedVue extends Group{

	Figure fig;
	Timeline timeline;
	
	public GroupedVue(Figure figure) {
		this.fig = figure;
		
		
		this.getChildren().addAll(this.getFigure());
		timeline= new Timeline(new KeyFrame(Duration.seconds(0.033333), e -> {
			fig.tri();
			Mouvement.rotate(fig, 1, 1, 1);
			this.getChildren().clear();
			this.getChildren().addAll(this.getFigure());
		}));
		timeline.setCycleCount(Animation.INDEFINITE);
		timeline.setAutoReverse(true);
		
		timeline.play();
    	
	}

	private Polygon getPolygon(Double[] coord,  Face f) {
		Polygon poly = new Polygon();
//		if(f.getId() == 5) {
//			poly.setFill(Color.YELLOW);
//			System.out.println("moyenne5X = "+f.moyenneX());
//			System.out.println("moyenne5Y = "+f.moyenneY());
//			System.out.println("moyenne5Z = "+f.moyenneZ());
//		} else if(f.getId() == 7){
//			poly.setFill(Color.RED);
//			System.out.println("moyenne7X = "+f.moyenneX());
//			System.out.println("moyenne7Y = "+f.moyenneY());
//			System.out.println("moyenne7Z = "+f.moyenneZ());
//		}else 
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
}
