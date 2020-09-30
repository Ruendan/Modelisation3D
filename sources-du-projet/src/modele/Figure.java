package modele;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Figure {
	private Ply figure;
	private List<Point> point;
	private List<Face> faces;
	
	public Figure() {
		figure = new Ply();
		point = new ArrayList<Point>();
		point.add(new Point(-1.0, -1.0, -1.0));//0
		point.add(new Point(1.0, -1.0, -1.0));//1
		point.add(new Point(1.0, 1.0, -1.0 ));//2
		point.add(new Point(-1.0, 1.0, -1.0));//3
		point.add(new Point(-1.0, -1.0, 1.0 ));//4
		point.add(new Point(1.0, -1.0, 1.0 ));//5
		point.add(new Point(1.0, 1.0, 1.0 ));//6
		point.add(new Point(-1.0, 1.0, 1.0 ));//7

		List<Integer[]> facesPoint = new ArrayList<Integer[]>();
		facesPoint.add(new Integer[] {0, 1, 2, 3 });
		facesPoint.add(new Integer[] {5, 4, 7, 6 });
		facesPoint.add(new Integer[] {6, 2, 1, 5 });
		facesPoint.add(new Integer[] {3, 7, 4, 0 });
		facesPoint.add(new Integer[] {7, 3, 2, 6 });
		facesPoint.add(new Integer[] {5, 1, 0, 4 });
		
		faces = new ArrayList<Face>();
		for(Integer[] i : facesPoint) {
			faces.add(new Face(4,Arrays.asList(i),point));
		}	
	}
	
	public Figure(Ply ply){
		this.figure = ply;
		this.point = ply.getPoints();
		this.faces = ply.getFaces();
	}
	
	public List<Double[]> initialisation() {
		for(int i=0;i<point.size();i++) {
			point.set(i, rotateZ(point.get(i),45));//O
			point.set(i, rotateX(point.get(i),45));//|
			point.set(i, rotateY(point.get(i),0));//-
			point.set(i, agrandir(point.get(i)));
			
		}
		tri();
		List<Double[]> allCoord = new ArrayList<Double[]>();
		for(int i=0; i<faces.size();i++) {
			Double[]coord = convert3d2d(faces.get(i));	
			allCoord.add(coord);
		}
		return allCoord;
	}
	
	
	private Point agrandir(Point point2) {
		point2.agrandir(100);
		point2.deplacer(300, 300, 300);
		
		return point2;
	}


	private Double[] convert3d2d(Face face) {
		Double[] coord = new Double[(face.getNbPoints()*2)];
		for(int j=0; j<face.getPoints().size();j++) {
			Point test = transformation(point.get((int)(double) face.getPoints().get(j)));
			coord[j*2]= test.getX();
			coord[j*2+1] = test.getY();
		}
		return coord;
	}

	public static Point transformation(Point point2) {
		Double[][] matrice = new Double[][] {
			{1.0,	0.0,	0.0},
			{0.0,	1.0,	0.0}};
			
		return calculMatrice(matrice,point2);

	}
	
	
	public static Point rotateZ(Point point2,double theta) {
		theta = Math.toRadians(theta);
		Double[][] matrice = new Double[][] {
			{Math.cos(theta),	-Math.sin(theta),	0.0},
			{Math.sin(theta),	Math.cos(theta),	0.0},
			{0.0,				0.0,				1.0}};	
			
		return calculMatrice(matrice,point2);
	}
	public static Point rotateX(Point point2,double theta) {
		theta = Math.toRadians(theta);
		Double[][] matrice = new Double[][] {
			{1.0,				0.0,						0.0},
			{0.0,				Math.cos(theta),			-Math.sin(theta)},
			{0.0,				Math.sin(theta),			Math.cos(theta)}};
			
		return calculMatrice(matrice,point2);
	}
	
	
	public static Point rotateY(Point point2,double theta) {
		theta = Math.toRadians(theta);
		Double[][] matrice = new Double[][] {
			{Math.cos(theta),		0.0,		-Math.sin(theta)},
			{0.0,					1.0,		0.0},
			{Math.sin(theta),		0.0,		Math.cos(theta)}};
			
		return calculMatrice(matrice,point2);

	}
	
	public static Point calculMatrice(Double[][] matrice, Point point2) {
		Point rep;
		Double[] res = new Double[matrice.length];
		Double[] p = new Double[] {point2.getX(),point2.getY(),point2.getZ()};
		for(int i=0; i<matrice.length;i++) {
			res[i]=0.0;
			for(int j = 0 ; j<p.length;j++) {
				res[i]+=(p[j])*matrice[i][j];
			}
			
		}
		if(res.length==2) rep = new Point(res[0],res[1]) ; 
		else rep = new Point(res[0],res[1],res[2]);
		return rep;
	}
	
	public double getZ(int i) {
		return point.get(i).getZ();
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

}
