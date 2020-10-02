package modele;

import java.util.ArrayList;
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
		System.out.println(center);
		System.out.println(faces.get(0).getPoints().get(0).hashCode());
		System.out.println(points.get(0).hashCode());
		System.out.println(nbFaces);
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
	
	
	
	boolean initialisation = false; //TODO
	
	public void initialisation() {
		if(!initialisation) {
			new Mouvement().deplacer(this, -center.getX(), -center.getY(), -center.getZ());
			for(Point p : this.getPoints()) {
				p.rotate(30,  70,  20);
				p.agrandir(100);
				p.deplacer(250, 250, 250);
			}
			center.deplacer(250, 250, 250);
			initialisation= !initialisation;
		}
		tri();
	}


//	public void zoom(double zoom) {
//		Point temp = new Point(center.getX(), center.getY(), center.getZ());
//		deplacer(-center.getX(), -center.getY(), -center.getZ());
//		for(int i = 0; i < figure.getPoints().size() ; i++) {
//			figure.getPoints().get(i).agrandir(zoom);
//		}
//		deplacer(temp.getX(), temp.getY(), temp.getZ());
//	}


	public void tri() {
		List<Double> moyennesZ = new ArrayList<Double>();
		for (Face f : faces) {
			moyennesZ.add(f.moyenneZ());
		}
		Face tempInt;
		double tempDouble;
		for (int i = 0; i < moyennesZ.size(); i++) {
			for (int j = i + 1; j < moyennesZ.size(); j++) {
				if (moyennesZ.get(i) > moyennesZ.get(j)) {
					tempInt = faces.get(i);
					faces.set(i, faces.get(j));
					faces.set(j, tempInt);

					tempDouble = moyennesZ.get(i);
					moyennesZ.set(i, moyennesZ.get(j));
					moyennesZ.set(j, tempDouble);
				}
			}
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
		return "Figure [faces=" + faces + ", nbFaces=" + nbFaces + ", center=" + center + ", points=" + points
				+ ", initialisation=" + initialisation + "]";
	}
	
	
	
}
