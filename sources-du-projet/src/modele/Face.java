package modele;

import java.util.List;

public class Face implements Comparable<Face> {
	private int nbPoints;
	private List<Point> points;
	
	public Face(int nbPoints,List<Point> points) {
		this.nbPoints=nbPoints;
		this.points=points;
	}

	public int getNbPoints() {
		return nbPoints;
	}
	
	public List<Point> getPoints() {
		return points;
	}

	@Override
	public String toString() {
		return "Face [nbPoints=" + nbPoints + ", points:(" + points + ")";
	}
	
	public Point pointMoyen() {
		double x = 0;
		double y = 0;
		double z = 0;
		for (Point p : points) {
			x+=p.getX();
			y+=p.getY();
			z+=p.getZ();
		}
		return new Point(x/nbPoints,y/nbPoints,z/nbPoints);
	}
	
	public double moyenneZ() {
		double res = 0;
		for(Point p : points) {
			res+=p.getZ();
		}
		return res/nbPoints;
	}

	@Override
	public int compareTo(Face o) {
		Double moy1 = this.moyenneZ();
		Double moy2 = o.moyenneZ();
		return moy1.compareTo(moy2);
	}
	
}
