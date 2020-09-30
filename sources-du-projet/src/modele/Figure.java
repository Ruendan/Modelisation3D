package modele;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import modele.modelisation.Matrix;

public class Figure {
	private Ply figure;
	
	
	public Figure(Ply ply){
		this.figure = ply;
	}
	
	public Figure() {
		figure = new Ply();
		figure.getPoints().add(new Point(-1.0, -1.0, -1.0));
		figure.getPoints().add(new Point(1.0, -1.0, -1.0));
		figure.getPoints().add(new Point(1.0, 1.0, -1.0 ));
		figure.getPoints().add(new Point(-1.0, 1.0, -1.0));
		figure.getPoints().add(new Point(-1.0, -1.0, 1.0 ));
		figure.getPoints().add(new Point(1.0, -1.0, 1.0 ));
		figure.getPoints().add(new Point(1.0, 1.0, 1.0 ));
		figure.getPoints().add(new Point(-1.0, 1.0, 1.0 ));

		figure.getFaces().add(new Face(4, Arrays.asList(new Integer[] {0, 1, 2, 3 })));
		figure.getFaces().add(new Face(4, Arrays.asList(new Integer[] {5, 4, 7, 6 })));
		figure.getFaces().add(new Face(4, Arrays.asList(new Integer[] {6, 2, 1, 5 })));
		figure.getFaces().add(new Face(4, Arrays.asList(new Integer[] {3, 7, 4, 0 })));
		figure.getFaces().add(new Face(4, Arrays.asList(new Integer[] {7, 3, 2, 6 })));
		figure.getFaces().add(new Face(4, Arrays.asList(new Integer[] {5, 1, 0, 4 })));

	}
	
	public List<Face> initialisation() {
		for(int i=0;i<figure.getPoints().size();i++) {
			figure.getPoints().set(i, Matrix.rotateZ(figure.getPoints().get(i),45));//O
			figure.getPoints().set(i, Matrix.rotateX(figure.getPoints().get(i),45));//|
			figure.getPoints().set(i, Matrix.rotateY(figure.getPoints().get(i),0));//-
			figure.getPoints().set(i, agrandir(figure.getPoints().get(i)));
			
		}
		tri();
		return figure.getFaces();
	}
	
	private Point agrandir(Point point2) {
		point2.agrandir(100);
		point2.deplacer(300, 300, 300);
		
		return point2;
	}
	
	public double getZ(int i) {
		return figure.getPoints().get(i).getZ();
	}
	
	public double moyenneZ(Face f) {
		double res=0;
		for(int i = 0; i<f.getNbPoints();i++) {
			res+=getZ(f.getPoints().get(i));
		}
		return res/f.getNbPoints();
	}
	
	public void tri() {
		List<Double> moyennesZ = new ArrayList<Double>();
		List<Face> faces = figure.getFaces();
		for(Face f : faces) {
			moyennesZ.add(moyenneZ(f));
		}
		Face tempInt;
		double tempDouble;
		for(int i = 0; i< moyennesZ.size();i++) {
			for(int j = i+1 ; j<moyennesZ.size();j++) {
				if(moyennesZ.get(i)>moyennesZ.get(j)) {
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

}
