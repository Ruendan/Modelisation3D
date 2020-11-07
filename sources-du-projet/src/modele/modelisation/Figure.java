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
		for(Point p : this.getPoints()) {
			p.rotate(180,  180,  0);
			p.agrandir(50);
			p.deplacer(250, 250, 250);
		}
		center.deplacer(250, 250, 250);
		//this.zoom(0);
		tri();
	}


	public void zoom(double zoom) {
		Point temp = new Point(center.getX(), center.getY(), center.getZ());
		Mouvement.deplacer(this, -center.getX(), -center.getY(), -center.getZ());
//		for(int i = 0; i < this.getPoints().size() ; i++) {
//			this.getPoints().get(i).agrandir(zoom);
//		}
		for(Point p : this.getPoints()) p.agrandir(zoom);
		
		Mouvement.deplacer(this, temp.getX(), temp.getY(), temp.getZ());
		this.notifyObservers();
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
		
		double x = 0;
		double y = 0;
		double z = 0;
		for(Face f : faces) {
			Point c = f.pointMoyen();
			x += c.getX();
			z += c.getY();
			y += c.getZ();
		}
		return new Point(x/faces.size(),y/faces.size(),z/faces.size());
	}

	@Override
	public String toString() {
		return "Figure [faces=" + faces + ", nbFaces=" + nbFaces + ", center=" + center + ", points=" + points;
	}

	public void rotate(int i, int j, int k) {
		Mouvement.rotate(this, i, j, k);
		this.notifyObservers();
	}
	
	public void rotateX(int i) {
		Mouvement.rotateX(this, i);
		this.notifyObservers();
	}

	public void rotateY(int i) {
		Mouvement.rotateY(this, i);
		this.notifyObservers();
	}

	public void rotateZ(int i) {
		Mouvement.rotateZ(this, i);
		this.notifyObservers();
	}

}
