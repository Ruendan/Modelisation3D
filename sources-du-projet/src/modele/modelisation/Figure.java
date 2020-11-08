package modele.modelisation;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import modele.parser.PlyParser;
import modele.parser.exception.PlyParserException;
import utils.Subject;

public class Figure extends Subject {
	
	private String name;
	private List<Face> faces;
	private int nbFaces;
	private Point center;
	private Set<Point> points;
	
	public Figure(Ply ply) {
		this.name = ply.getName();
		this.faces = ply.getFaces();
		this.points = ply.getPoints();
		this.center = center();
		this.nbFaces=faces.size();
		this.initialisation();
	}

	public Figure() throws PlyParserException {
		this(PlyParser.loadPly("cube"));
	}
	
	public Figure(String nom) throws PlyParserException {
		this(PlyParser.loadPly(nom));
	}
	
	public Set<Point> getPoints(){
		return points;
	}
	
	public Point getCenter() {
		return center;
	}
	
	public int getNbFaces() {
		return nbFaces;
	}
	
	public List<Face> getFaces(){
		return faces;
	}
	
	public String getName() {
		return this.name;
	}
	
	/**
	 * IL FAUT METTRE TOUTES LES VALEURS DANS DES VARIABLES
	 */
	private void initialisation() {
		Mouvement.deplacer(this, -center.getX(), -center.getY(), -center.getZ());
		center.deplacer(-center.getX(), -center.getY(), -center.getZ());
		Mouvement.rotate(this, 180, 180, 0);
		//zoom(50);
		tri();
	}


	public void zoom(double zoom) {
		toOrigin();
		for(Point p : this.getPoints()) p.agrandir(zoom);
		toCenter();
		this.notifyObservers();
	}

	public void HDeplace(double value) {
		center.deplacerX(value);
		Mouvement.deplacer(this, value, 0, 0);
		notifyObservers();
	}
	
	public void VDeplace(double value){
		center.deplacerY(value);
		Mouvement.deplacer(this, 0, value, 0);
		notifyObservers();
	}

	public void tri() {
		for(Face f : faces) {
			f.preSort();
		}
		Collections.sort(faces);
		int i=0;
		for(Face f : faces) {
			f.setId(i);
			i++;
		}
	}

	public Point center() {
		
//		double x = 0;
//		double y = 0;
//		double z = 0;
//		for(Face f : faces) {
//			Point c = f.pointMoyen();
//			x += c.getX();
//			z += c.getY();
//			y += c.getZ();
//		}
//		return new Point(x/faces.size(),y/faces.size(),z/faces.size());
		

		double x1 = ((Point) points.toArray()[0]).getX();
		double y1 = ((Point) points.toArray()[0]).getY();
		double z1 = ((Point) points.toArray()[0]).getZ();
		double x2 = ((Point) points.toArray()[1]).getX();
		double y2 = ((Point) points.toArray()[1]).getY();
		double z2 = ((Point) points.toArray()[1]).getZ();
		double dx1, dy1, dz1, dx2, dy2, dz2, cpx, cpy, cpz, area, sx = 0, sy = 0, sz = 0, sarea = 0;
		int i = 0;
		for (Point p : points) {
			if(i<2) i++;
			else {
				dx1 = p.getX() - x1;
				dy1 = p.getY() - y1;
				dz1 = p.getZ() - z1;
				dx2 = p.getX() - x2;
				dy2 = p.getY() - y2;
				dz2 = p.getZ() - z2;
				cpx = dy1*dz2 - dz1*dy2;
				cpy = dz1*dx2 - dx1*dz2;
				cpz = dx1*dy2 - dy1*dx2;
				area = Math.sqrt(cpx*cpx + cpy*cpy + cpz*cpz)/2;
				sx+=(x1 + x2 + p.getX())/3*area;
				sy+=(y1 + y2 + p.getY())/3*area;
				sz+=(z1 + z2 + p.getZ())/3*area;
				sarea+=area;
			}
		}
		return new Point(sx/sarea, sy/sarea, sz/sarea);
	}

	@Override
	public String toString() {
		return "Figure [faces=" + faces + ", nbFaces=" + nbFaces + ", center=" + center + ", points=" + points;
	}

	public void rotate(int i, int j, int k) {
		toOrigin();
		Mouvement.rotate(this, i, j, k);
		toCenter();
		this.notifyObservers();
	}
	
	public void rotateX(int i) {
		toOrigin();
		Mouvement.rotateX(this, i);
		toCenter();
		this.notifyObservers();
	}

	public void rotateY(int i) {
		toOrigin();
		Mouvement.rotateY(this, i);
		toCenter();
		this.notifyObservers();
	}

	public void rotateZ(int i) {
		toOrigin();
		Mouvement.rotateZ(this, i);
		toCenter();
		this.notifyObservers();
	}
	
	private void toOrigin() {
		Mouvement.deplacer(this, -center.getX(), -center.getY(), -center.getZ());
	}
	
	private void toCenter() {
		Mouvement.deplacer(this, center.getX(), center.getY(), center.getZ());
	}

	public void centerFigure(double width, double height) {
		zoom((height/2)/Math.abs(getHighestPoint()));
		Mouvement.deplacer(this, width/2, height/2, 0);
		center.deplacer(width/2, height/2, 0);
		notifyObservers();
	}

	private double getHighestPoint() {
		double highest = 0;
		for(Point p : points) {
			if(highest>p.getY()) highest = p.getY(); 
			if(highest>p.getX()) highest = p.getX();
			
		}
		return highest;
	}
}
