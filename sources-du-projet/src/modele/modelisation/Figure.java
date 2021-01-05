package modele.modelisation;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import modele.parser.PlyParser;
import modele.parser.exception.PlyParserException;
import utils.Subject;
import view.CanvasFigure;

/**
 *Modelisation du fichier PLY
 *<p>
 *C'est ici que se trouve toute les fonctions de manipulation de la figure.
 *<p>
 *
 *<br>
 * @author Groupe G1 
 * <br>
 * {@link} nathan-developpeur.com
 * 
 *
 */
public class Figure extends Subject{
	

	private String name;
	private List<Face> faces;
	private Point center;
	private Set<Point> points;

	/**
	 * Create a figure with a {@link Ply}
	 * @param ply
	 * 			The using {@link Ply}
	 */
	public Figure(Ply ply) {
		this.name = ply.getName();
		this.faces = ply.getFaces();
		this.points = ply.getPoints();
		this.center = center();
		this.initialisation();
	}
	
	/**
	 * Create a figure with a name pf a ply File
	 * @see Ply
	 * @see PlyParser
	 * @param nom
	 * 			The name of the PLY File you want to use
	 * @throws PlyParserException
	 * 			if the PLY isn't exist or have an error
	 * 		
	 */
	public Figure(String nom) throws PlyParserException {
		this(PlyParser.loadPly(nom));
	}
	
	
	/**
	 * Return figure's set of point
	 * @return {@link Set} of {@link Point}
	 * 			The list of all points of the figure
	 */
	public Set<Point> getPoints(){
		return points;
	}
	
	/**
	 * Return the point that matches with the figure's center
	 * @return {@link Point}
	 * 			The center of the figure
	 */
	public Point getCenter() {
		return center;
	}
	
	/**
	 * Return the figure's number of {@link Face}
	 * @return {@link Integer}
	 * 			The number of Figures'faces
	 */
	public int getNbFaces() {
		return faces.size();
	}
	
	/**
	 * Return the figure's {@link List} of {@link Face} 
	 * @return {@link List} of {@link Face} 
	 * 			The List of Figure's {@link Face}
	 */
	public List<Face> getFaces(){
		return faces;
	}

	/**
	 * Return the figure's name
	 * @return {@link String}
	 * 			The figure's name
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Return the figure's number of {@link Point}.
	 * @return {@link Double}
	 * 			The figure's number of {@link Point}.
	 */
	public double getNbPoint() {
		return points.size();
	}
	
	private void initialisation() {
		Mouvement.deplacer(this, -center.getX(), -center.getY(), -center.getZ());
		center.deplacer(-center.getX(), -center.getY(), -center.getZ());
		Mouvement.rotate(this, 180, 180, 0);
	}

	/**
	 * Zoom or dezoom the figure
	 * @param zoom
	 * 			The value of the zoom
	 * <p>Mutliply the figure's points by the value of zoom</p>
	 */
	public void zoom(double zoom) {
		toOrigin();
		for(Point p : this.getPoints()) p.agrandir(zoom);
		toCenter();
		this.notifyObservers();
	}
	
	/**
	 * Move the figure horizontaly
	 * @param value
	 * 			The value of the number of time you want to move the figure in the X axes.
	 * @see Mouvement
	 */
	public void HDeplace(double value) {
		center.deplacerX(value);
		Mouvement.deplacer(this, value, 0, 0);
		notifyObservers();
	}
	
	/**
	 * Move the figure verticaly
	 * @param value
	 * 			The value of the number of time you want to move the figure in the Y axes.
	 * @see Mouvement
	 */
	public void VDeplace(double value){
		center.deplacerY(value);
		Mouvement.deplacer(this, 0, value, 0);
		notifyObservers();
	}

	/**
	 * Sort the {@link List} of {@link Face}
	 * <p> Sort the {@link List} of {@link Face} in the good order for print. The farthest {@link Face} is in first place and the closest in last place</p>
	 * @see Figure#getFaces()
	 * @see Face
	 */
	public void tri(Vecteur vVue,Vecteur vLumière) {
		for(Face f : faces) {
			f.preSort(vVue,vLumière);
		}
		Collections.sort(faces);
	}

	/**
	 * Initializes the center {@link Point}
	 * <p> create the {@link Point} who is at the center of the figures by the average of extremes point</p>
	 * @return {@link Point}
	 * 			The center {@link Point}
	 * 
	 * @see Figure#getCenter()
	 * @see Figure#getExtremePoint()
	 */
	public Point center() {

		double[] extreme = getExtremePoint();
		double x = (extreme[0]+extreme[1])/2;
		double y = (extreme[2]+extreme[3])/2;
		double z = (extreme[4]+extreme[5])/2;
		return new Point(x, y, z);
	}

	/**
	 * {@link String} of the Figure
	 * <p> Exemple Figure [name=cube, faces=(List of Faces), nbFaces=6, center=(center point), points=(List of points)]</p>
	 * 
	 * @see Figure#getName()
	 * @see Figure#getFaces()
	 * @see Figure#getNbFaces()
	 * @see Figure#getCenter()
	 * @see Figure#getPoints()
	 */
	@Override
	public String toString() {
		return "Figure [name=" + name + ", faces=" + faces + ", center=" + center + ", points=" + points + "]";
	}

	/**
	 * Rotate the figure
	 * 
	 * @param i
	 * 			The value of the angle you want to rotate in X axes
	 * @param j
	 * 			The value of the angle you want to rotate in Y axes
	 * @param k
	 * 			The value of the angle you want to rotate in Z axes
	 * @see Mouvement
	 */
	public void rotate(double i, double j, double k) {
		toOrigin();
		Mouvement.rotate(this, i, j, k);
		toCenter();
		this.notifyObservers();
	}
	
	/**
	 * Rotate the figure on the X axes only
	 * @param i
	 * 			The value of the angle you want to rotate
	 * @see Mouvement
	 */
	public void rotateX(double i) {
		toOrigin();
		Mouvement.rotateX(this, i);
		toCenter();
		this.notifyObservers();
	}

	/**
	 * Rotate the figure on the Y axes only
	 * @param d
	 * 			The value of the angle you want to rotate
	 * @see Mouvement
	 */
	public void rotateY(double d) {
		toOrigin();
		Mouvement.rotateY(this, d);
		toCenter();
		this.notifyObservers();
	}

	/**
	 * Rotate the figure on the Z axes only
	 * @param i
	 * 			The value of the angle you want to rotate
	 * @see Mouvement
	 */
	public void rotateZ(double i) {
		toOrigin();
		Mouvement.rotateZ(this, i);
		toCenter();
		this.notifyObservers();
	}
	
	/**
	 * Move the figure on (0,0,0)
	 */
	private void toOrigin() {
		Mouvement.deplacer(this, -center.getX(), -center.getY(), -center.getZ());
	}
	
	/**
	 * Move the figure on the center of the {@link CanvasFigure}
	 * 
	 * @see CanvasFigure
	 * @see Figure#getCenter()
	 * @see Mouvement
	 */
	private void toCenter() {
		Mouvement.deplacer(this, center.getX(), center.getY(), center.getZ());
	}
	/**
	 * Get the extreme points of the figure
	 * <p>Return an array of {@link Double} the two first value are the closest X and the Farthest X, the 2 next are the same but for Y and same things for Z</p>
	 * @return array of {@link Double}
	 * 			All the extreme {@link Point}
	 */
	public double[] getExtremePoint() {
		double[] extreme = new double[6];
		for(int i = 0 ; i < extreme.length ; i++) {
			extreme[i] = 0;
		}
		for(Point p : points) {
			if(extreme[0]>p.getX()) extreme[0] = p.getX(); 
			if(extreme[1]<p.getX()) extreme[1] = p.getX();
			if(extreme[2]>p.getY()) extreme[2] = p.getY(); 
			if(extreme[3]<p.getY()) extreme[3] = p.getY();
			if(extreme[4]>p.getZ()) extreme[4] = p.getZ(); 
			if(extreme[5]<p.getZ()) extreme[5] = p.getZ();
		}
		return extreme;
	}

	/**
	 * Move the figure
	 * <p>Move the figures on all the axes</p>
	 * @param x
	 * 			The value of the number of time you want to move the figure in the X axes.
	 * @param y
	 * 			The value of the number of time you want to move the figure in the Y axes.
	 * @param z
	 * 			The value of the number of time you want to move the figure in the Y axes.
	 * @see Mouvement
	 */
	public void deplace(double x, double y, double z) {
		Mouvement.deplacer(this, x, y, z);
		center.deplacer(x, y, z);
		notifyObservers();
	}

}
