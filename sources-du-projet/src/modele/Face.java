package modele;

import java.util.List;

public class Face {
	private int nbPoints;
	private List<Integer> points;
	
	public Face(int nbPoints,List<Integer> points) {
		this.nbPoints=nbPoints;
		this.points=points;
	}

	public int getNbPoints() {
		return nbPoints;
	}
	
	public List<Integer> getPoints() {
		return points;
	}

	@Override
	public String toString() {
		return "Face [nbPoints=" + nbPoints + ", points=" + points + "]";
	}
	
}
