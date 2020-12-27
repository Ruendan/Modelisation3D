package modele.modelisation;

import java.util.ArrayList;
import java.util.List;

public class Face implements Comparable<Face> {
	private int nbPoints;
	private List<Point> points;
	private Vecteur normal;
	private Double closest;
	private double exposition;
	private static final Vecteur vVue = new Vecteur(0,0,-1);
	
	public Face(int nbPoints,List<Point> points) {
		this.nbPoints=nbPoints;
		if(points==null) this.points = new ArrayList<>();
		else this.points=points;
		setClosest();
		setNormal();
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
	
	public void preSort() {
		setNormal();
		setClosest();
		
	}
	
	public void setNormal() {
		if(points!=null && !points.isEmpty())normal = Vecteur.getNormal(points);
		if(normal!=null) {
			exposition = -vVue.produitScalaire(normal);
			
		}
	}
	
	@Override
	public int compareTo(Face o) {
		
		int point = this.closest.compareTo(o.closest);
		if(point!=0)return point;
		Double moyZ1 = normal.getDirZ();
		Double moyZ2= o.getNormal().getDirZ();
		
		return moyZ1.compareTo(moyZ2);
	}
 
	public void setClosest() {
		double petit;
		if(this.getNbPoints()==0)
			petit = Double.NaN;
		else petit = points.get(0).getZ();
		
		for (Point point : points) {
			if(point.getZ()<petit)petit=point.getZ();
		}
		this.closest = petit;
	}
	
	public Double getClosest() {
		return this.closest;
	}

	public Vecteur getNormal() {
		return this.normal;
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

	public double getExposition() {
		return exposition;
	}
	
}
