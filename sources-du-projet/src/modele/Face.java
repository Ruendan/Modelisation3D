package modele;

import java.util.List;

public class Face implements Comparable<Face> {
	private int nbPoints;
	private List<Point> points;
	private int id;
	private static int ID=0;
	
	public Face(int nbPoints,List<Point> points) {
		this.nbPoints=nbPoints;
		this.points=points;
		id=ID;
		ID++;
	}

	public int getNbPoints() {
		return nbPoints;
	}
	
	public List<Point> getPoints() {
		return points;
	}

	public int getId() {
		return id;
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
	
	public double moyenneY() {
		double res = 0;
		for(Point p : points) {
			res+=p.getY();
		}
		return res/nbPoints;
	}

	public double moyenneX() {
		double res = 0;
		for(Point p : points) {
			res+=p.getX();
		}
		return res/nbPoints;
	}
	
	@Override
	public int compareTo(Face o) {
		Double moyZ1 = this.moyenneZ();
		Double moyZ2 = o.moyenneZ();
		Double moyY1 = this.moyenneY();
		Double moyY2 = o.moyenneY();
		Double moyX1 = this.moyenneX();
		Double moyX2 = o.moyenneX();
		
		return -moyZ1.compareTo(moyZ2)/moyX1.compareTo(moyX2)/moyY1.compareTo(moyY2);
	}
 
	public void setId(int id) {
		this.id = id;
	}
	
}
