package modele;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Figure {
	private Ply figure;
	private Point center;
	
	public Figure(Ply ply) {
		this.figure = ply;
		this.center = new Point(0, 0, 0);
	}

	public Figure() {
		figure = new Ply();
		figure.setPoints(new ArrayList<Point>());
		figure.getPoints().add(new Point(-1.0, -1.0, -1.0));
		figure.getPoints().add(new Point(1.0, -1.0, -1.0));
		figure.getPoints().add(new Point(1.0, 1.0, -1.0));
		figure.getPoints().add(new Point(-1.0, 1.0, -1.0));
		figure.getPoints().add(new Point(-1.0, -1.0, 1.0));
		figure.getPoints().add(new Point(1.0, -1.0, 1.0));
		figure.getPoints().add(new Point(1.0, 1.0, 1.0));
		figure.getPoints().add(new Point(-1.0, 1.0, 1.0));

		figure.setFaces(new ArrayList<Face>());
		figure.getFaces().add(new Face(4, Arrays.asList(new Integer[] { 0, 1, 2, 3 })));
		figure.getFaces().add(new Face(4, Arrays.asList(new Integer[] { 5, 4, 7, 6 })));
		figure.getFaces().add(new Face(4, Arrays.asList(new Integer[] { 6, 2, 1, 5 })));
		figure.getFaces().add(new Face(4, Arrays.asList(new Integer[] { 3, 7, 4, 0 })));
		figure.getFaces().add(new Face(4, Arrays.asList(new Integer[] { 7, 3, 2, 6 })));
		figure.getFaces().add(new Face(4, Arrays.asList(new Integer[] { 5, 1, 0, 4 })));

	}
	
	boolean initialisation = false; //TODO
	
	public List<Face> initialisation() {
		if(!initialisation) {
			for (int i = 0; i < figure.getPoints().size(); i++) {
				figure.getPoints().get(i).rotate(135, 45, 0);
				figure.getPoints().get(i).agrandir(50);
				figure.getPoints().get(i).deplacer(250, 250, 250);
			}
			center.deplacer(250, 250, 250);
			initialisation= !initialisation;
		}
		tri();
		return figure.getFaces();
	}

	private void deplacer(double x, double y, double z) {
		for(int i = 0; i < figure.getPoints().size() ; i++) {
			figure.getPoints().get(i).deplacer(x, y, z);
		}
		center.deplacer(x, y, z);
	}

	private void zoom( int zoom) {
		for(int i = 0; i < figure.getPoints().size() ; i++) {
			figure.getPoints().get(i).agrandir(50);
		}
		center.agrandir(zoom);
	}

	public double getZ(int i) {
		return figure.getPoints().get(i).getZ();
	}

	public double moyenneZ(Face f) {
		double res = 0;
		for (int i = 0; i < f.getNbPoints(); i++) {
			res += getZ(f.getPoints().get(i));
		}
		return res / f.getNbPoints();
	}

	public void tri() {
		List<Double> moyennesZ = new ArrayList<Double>();
		List<Face> faces = figure.getFaces();
		for (Face f : faces) {
			moyennesZ.add(moyenneZ(f));
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

	public Ply getPly() {
		// TODO Auto-generated method stub
		return this.figure;
	}

	public void rotate( double thetaX, double thetaY, double thetaZ) {
		Point temp = new Point(center.getX(), center.getY(), center.getZ());
		deplacer(-center.getX(), -center.getY(), -center.getZ());
		for(int i = 0; i < figure.getPoints().size() ; i++) {
			figure.getPoints().get(i).rotate(thetaX, thetaY, thetaZ);
		}
		deplacer(temp.getX(), temp.getY(), temp.getZ());
	}

}
