package modele;

import java.util.Collections;
import java.util.List;

public class Figure {
	
	private List<Face> faces;
	private int nbFaces;
	private Point center;
	private List<Point> points;
	
	public Figure(Ply ply) {
		this.faces = ply.getFaces();
		this.points = ply.getPoints();
		this.center = center();
		this.nbFaces=faces.size();
		this.initialisation();
	}

	public Figure() {
		this(PlyParser.loadPly("cube"));
	}
	
	public Figure(String nom) {
		this(PlyParser.loadPly(nom));
	}
	
	public List<Point> getPoints(){
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
	
	/**
	 * IL FAUT METTRE TOUTES LES VALEURS DANS DES VARIABLES
	 */
	private void initialisation() {
		Mouvement.deplacer(this, -center.getX(), -center.getY(), -center.getZ());
		for(Point p : this.getPoints()) {
			p.rotate(70,  0,  70);
			p.agrandir(100);
			p.deplacer(250, 250, 250);
		}
		center.deplacer(250, 250, 250);
		//this.zoom(0);
		tri();
	}


	public void zoom(double zoom) {
		Point temp = new Point(center.getX(), center.getY(), center.getZ());
		Mouvement.deplacer(this, -center.getX(), -center.getY(), -center.getZ());
		for(int i = 0; i < this.getPoints().size() ; i++) {
			this.getPoints().get(i).agrandir(zoom);
		}
		Mouvement.deplacer(this, temp.getX(), temp.getY(), temp.getZ());
	}


	public void tri() {
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

}
