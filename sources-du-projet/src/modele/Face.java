package modele;

import java.util.ArrayList;
import java.util.List;

public class Face implements Comparable<Face> {
	private int nbPoints;
	private List<Point> points;
	private int id;
	private static int ID=0;
	
	public Face(int nbPoints,List<Point> points) {
		this.nbPoints=nbPoints;
		if(points==null) this.points = new ArrayList<Point>();
		else this.points=points;
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
		return moyZ1.compareTo(moyZ2);
	}
 
	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((points == null) ? 0 : points.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Face other = (Face) obj;
		
		
		if (points == null) {
			if (other.points != null)
				return false;
		} else {
			for(int i=0; i<points.size(); i++) {
				if(!this.points.get(i).equals(other.getPoints().get(i))) return false;
			}
		}
		return true;
	}
	
}
