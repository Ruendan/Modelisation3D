package modele.modelisation;

import java.util.ArrayList;
import java.util.List;

public class Face implements Comparable<Face> {
	
	private int nbPoints;
	private AllPoint allPoints;
	private List<Integer> points;
	private Vecteur normal;
	private Double closest;
	private double exposition;
	private boolean isUpper;
	private static final Vecteur vVue = new Vecteur(0,0,-1);
	
	public Face(int nbPoints,List<Integer> points, AllPoint allPoint) {
		//System.out.println(points.get(0)+" "+points.get(1)+" "+points.get(2));
		this.nbPoints=nbPoints;
		this.allPoints = allPoint;
		if(points==null) this.points = new ArrayList<Integer>();
		else this.points=points;
		setClosest();
		setNormal();
	}

	public Point pointMoyen() {
		double x = 0;
		double y = 0;
		double z = 0;
		for(int i = 0 ; i<points.size() ; i++) {
			x+=allPoints.getMatrix()[points.get(i)][0];
			y+=allPoints.getMatrix()[points.get(i)][1];
			z+=allPoints.getMatrix()[points.get(i)][2];
		}
		return new Point(x/nbPoints,y/nbPoints,z/nbPoints);
	}
	
	public double moyenneZ() {
		double res = 0;
		for(int i = 0 ; i<points.size() ; i++) {
			res+=allPoints.getMatrix()[points.get(i)][2];
		}
		return res/nbPoints;
	}
	
	public double moyenneY() {
		double res = 0;
		for(int i = 0 ; i<points.size() ; i++) {
			res+=allPoints.getMatrix()[points.get(i)][1];
		}
		return res/nbPoints;
	}

	public double moyenneX() {
		double res = 0;
		for(int i = 0 ; i<points.size() ; i++) {
			res+=allPoints.getMatrix()[points.get(i)][0];
		}
		return res/nbPoints;
	}
	
	public void preSort() {
		setNormal();
		setClosest();
	}
	
	public void setNormal() {

		if(points!=null && !points.isEmpty())normal = Vecteur.getNormal(getPoints());
		if(normal!=null) {
			exposition = -vVue.produitScalaire(normal);
			if(exposition>0)isUpper = true;
			else isUpper = false;
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
		else petit = allPoints.get(points.get(0))[2);
		
		for(int i = 0 ; i<points.size() ; i++) {
			if(allPoints.getMatrix()[points.get(i)][2]<petit)petit=allPoints.getMatrix()[points.get(i)][2];
		}
		this.closest = petit;
	}
	
	public Double getClosest() {
		return this.closest;
	}

	public Vecteur getNormal() {
		return this.normal;
	}
	public boolean isUpper() {
		return isUpper;
	}
	public int getNbPoints() {
		return nbPoints;
	}
	
	public AllPoint getPoints() {
		AllPoint p = new AllPoint(points.size());
		for (Integer integer : points) {
			p.add(allPoints.get(integer));
		}
		return p;
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
				if(!this.allPoints.get(points.get(i)).equals(other.getPoints().get(i))) return false;
			}
		}
		return true;
	}

	public double getExposition() {
		return exposition;
	}
	
}
