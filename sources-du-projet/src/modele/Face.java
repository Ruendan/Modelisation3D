package modele;

import java.util.List;

public class Face {
	private int nbPoints;
	private List<Point> points;
	
	public Face(int nbPoints, List<Point> points) {
		this.nbPoints=nbPoints;
		this.points=points;
	}

	public int getNbPoints() {
		return nbPoints;
	}

	public List<Point> getPoints() {
		return points;
	}
}
