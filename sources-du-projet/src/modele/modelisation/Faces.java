package modele.modelisation;

import java.util.ArrayList;

public class Faces implements Comparable<Faces> {
	
	private Vecteur normal;
	private Matrix points;
	private Double closest;
	

	public Faces(int nbPointInFace, ArrayList<Point> pointss) {
		points = new Matrix(pointss);
	}

	public Matrix getPoints() {
		return points;
	}
	
	public int getNbPoints() {
		return points.length();
	}
	
	public Vecteur getNormal() {
		return this.normal;
	}
	
	public void setNormal() {
		if(points!=null && !points.isEmpty()) normal = Vecteur.getNormal(points);
	}
	
	public void setClosest() {
		double petit;
		if(points.isEmpty())
			petit = Double.NaN;
		else petit = points.getMatrix()[0][2];
		
		for (Double[] point : points.getMatrix()) {
			if(point[2]<petit)petit=point[2];
		}
		this.closest = petit;
	}
	
	public void preSort() {
		setNormal();
		setClosest();
	}

	@Override
	public int compareTo(Faces o) {
		int point = this.closest.compareTo(o.closest);
		if(point!=0)return point;
		Double moyZ1 = normal.getDirZ();
		Double moyZ2= o.getNormal().getDirZ();
		
		return moyZ1.compareTo(moyZ2);
	}
}
