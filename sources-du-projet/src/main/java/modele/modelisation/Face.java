package modele.modelisation;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class Face implements Comparable<Face> {
	
	private final int nbPoints;
	private List<Point> points;
	private Vecteur normal;
	private Double closest;
	private double visibility;
	private double exposition;
	private boolean isUpper;
	
	private Color couleur;
	
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
		for (final Point p : points) {
			x+=p.getX();
			y+=p.getY();
			z+=p.getZ();
		}
		return new Point(x/nbPoints,y/nbPoints,z/nbPoints);
	}
	
	public double moyenneZ() {
		double res = 0;
		for(final Point p : points) {
			res+=p.getZ();
		}
		return res/nbPoints;
	}
	
	public double moyenneY() {
		double res = 0;
		for(final Point p : points) {
			res+=p.getY();
		}
		return res/nbPoints;
	}

	public double moyenneX() {
		double res = 0;
		for(final Point p : points) {
			res+=p.getX();
		}
		return res/nbPoints;
	}
	
	public void preSort(Vecteur vVue,Vecteur vLumiere) {
		setNormal();
		setVisibility(vVue);
		setExposition(vLumiere);
		setClosest();
	}
	
	public void setNormal() {
		if(points!=null && !points.isEmpty())normal = Vecteur.getNormal(points);
		
	}
	
	public void setVisibility(Vecteur observateur) {
		if(normal!=null) {
			visibility = -observateur.produitScalaire(normal);
			if(visibility>0)isUpper = true;
			else isUpper = false;
		}
	}
	
	public void setExposition(Vecteur lumiere) {
		if(normal!=null) {
			exposition = -lumiere.produitScalaire(normal);
		}
	}
	
	public double getExposition() {
		return exposition;
	}
	
	@Override
	public int compareTo(Face o) {
		
		final int point = this.closest.compareTo(o.closest);
		if(point!=0)return point;
		final Double moyZ1 = normal.getDirZ();
		final Double moyZ2= o.getNormal().getDirZ();
		
		return moyZ1.compareTo(moyZ2);
	}

	public void setClosest() {
		double petit;
		if(this.getNbPoints()==0)
			petit = Double.NaN;
		else petit = getPoint(0).getZ();
		
		for (final Point point : points) {
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
	
	public boolean isUpper() {
		return isUpper;
	}
	public int getNbPoints() {
		return nbPoints;
	}
	
	public Point getPoint(int i) {
		return points.get(i);
	}
	
	public List<Point> getPoints() {
		return points;
	}
	
	public Color getCouleur() {
		return couleur;
	}

	public void setCouleur(Color couleur) {
		this.couleur = couleur;
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
		final Face other = (Face) obj;
		
		if (points == null) {
			if (other.points != null)
				return false;
		} else {
			for(int i=0; i<points.size(); i++) {
				final Point thisPoint = getPoint(i);
				if(!thisPoint.equals(other.getPoint(i))) return false;  // je ne comprend pas la loi de demeter ici
			}
		}
		return true;
	}

	public double getVisibility() {
		return visibility;
	}
	
}
