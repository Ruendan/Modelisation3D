package modele;

import java.util.List;

public class Face {
	private int nbPoints;
	private List<Point> allPoints;
	private List<Integer> points;
	
	public Face(int nbPoints,List<Integer> points, List<Point> allPoints) {
		this.nbPoints=nbPoints;
		this.points=points;
		this.allPoints=allPoints;
	}

	public int getNbPoints() {
		return nbPoints;
	}

	public List<Point> getAllPoints() {
		return allPoints;
	}
	
	public List<Integer> getPoints() {
		return points;
	}
}
