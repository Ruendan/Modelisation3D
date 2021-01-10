package modele.modelisation;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.PrimitiveIterator.OfDouble;

import com.sun.org.apache.xpath.internal.operations.Bool;

import javafx.collections.SetChangeListener;

public class Face implements Comparable<Face> {
	
	private int nbPoints;
	private List<Point> points;
	private Vecteur normal;
	private Double closest;
	private double visibility;
	private double exposition;
	private boolean isUpper;
	
	private Color couleur;
	/**
	 * Create a Face with a {@link List} of {@link Point} and the number of point in this list 
	 * @param nbPoints
	 * 		Number of point of the Face
	 * @param points
	 * 		The point which constitutes the face
	 */
	public Face(int nbPoints,List<Point> points) {
		this.nbPoints=nbPoints;
		if(points==null) this.points = new ArrayList<>();
		else this.points=points;
		setClosest();
		setNormal();
	}

	/**
	 * Return the point which is the center of the face
	 * @return 
	 * 		return a {@link Point} which is the center of the face
	 */
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
	
	/**
	 * Return the average of all the Z coordinate of the face
	 * @return 
	 * 		return a {@link Double} which is the average of the Z coordinate of the face
	 */
	public double moyenneZ() {
		double res = 0;
		for(Point p : points) {
			res+=p.getZ();
		}
		return res/nbPoints;
	}
	
	/**
	 * Return the average of all the Y coordinate of the face
	 * @return 
	 * 		return a {@link Double} which is the average of the Y coordinate of the face
	 */
	public double moyenneY() {
		double res = 0;
		for(Point p : points) {
			res+=p.getY();
		}
		return res/nbPoints;
	}
	
	/**
	 * Return the average of all the X coordinate of the face
	 * @return 
	 * 		return a {@link Double} which is the average of the X coordinate of the face
	 */
	public double moyenneX() {
		double res = 0;
		for(Point p : points) {
			res+=p.getX();
		}
		return res/nbPoints;
	}
	
	/**
	 * Update the parameter of the face which is used for the sort
	 * @param vVue
	 * 		director vector of the view 
	 * @param vLumière
	 * 		director vector of the light
	 * @see Vecteur
	 */
	public void preSort(Vecteur vVue,Vecteur vLumière) {
		setNormal();
		setVisibility(vVue);
		setExposition(vLumière);
		setClosest();
	}
	
	/**
	 * Set the normal vector
	 * @see Vecteur
	 */
	public void setNormal() {
		if(points!=null && !points.isEmpty())normal = Vecteur.getNormal(points);
		
	}
	
	/**
	 * 
	 * @param observateur
	 */
	public void setVisibility(Vecteur observateur) {
		if(normal!=null) {
			visibility = -observateur.produitScalaire(normal);
			if(visibility>0)isUpper = true;
			else isUpper = false;
		}
	}
	
	public void setExposition(Vecteur lumière) {
		if(normal!=null) {
			exposition = -lumière.produitScalaire(normal);
		}
	}
	
	/**
	 * get the variable exposition of the face
	 * @return 
	 * 		{@link Double}
	 */
	public double getExposition() {
		return exposition;
	}
	
	@Override
	public int compareTo(Face o) {
		
		int point = this.closest.compareTo(o.closest);
		if(point!=0)return point;
		Double moyZ1 = normal.getDirZ();
		Double moyZ2= o.getNormal().getDirZ();
		
		return moyZ1.compareTo(moyZ2);
	}
 
	/**
	 * Set closest which is the Z coordinate the closest Z coordinate to the user's view
	 */
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
	
	/**
	 * Get the value of the variable closest
	 * @return
	 * 		{@link Double}
	 */
	public Double getClosest() {
		return this.closest;
	}

	/**
	 * Get the normal vector of the face
	 * @return
	 * 		{@link Vecteur}
	 */
	public Vecteur getNormal() {
		return this.normal;
	}
	
	/**
	 * Get if the face is visible or not
	 * @return
	 * 	 {@link Boolean}
	 */
	public boolean isUpper() {
		return isUpper;
	}
	
	/**
	 * Get the number of point of the face
	 * @return
	 * 		{@link Integer}
	 */
	public int getNbPoints() {
		return nbPoints;
	}
	
	/**
	 * Get the {@link List} of {@link Point} of the face
	 * @return
	 * 		{@link List} of {@link Point}
	 */
	public List<Point> getPoints() {
		return points;
	}
	
	/**
	 * Get the {@link javafx.scene.paint.Color} of the face
	 * @return
	 * 		{@link javafx.scene.paint.Color}
	 */
	public Color getCouleur() {
		return couleur;
	}

	/**
	 * Set the {@link javafx.scene.paint.Color} of the face
	 * @param couleur
	 * 		The future {@link javafx.scene.paint.Color} of the face
	 */
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

	/**
	 * Get the result of the scalar product of the director vector of the observer and the normal vector of the face
	 * @return
	 * 		{@link Double}
	 */
	public double getVisibility() {
		return visibility;
	}
	
}
