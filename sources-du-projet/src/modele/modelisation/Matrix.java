package modele.modelisation;

import modele.Point;

public class Matrix {
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
	
	public static Point transformation(Point point2) {
		Double[][] matrice = new Double[][] {
			{1.0,	0.0,	0.0},
			{0.0,	1.0,	0.0}};
			
		return calculMatrice(matrice,point2);

	}
	
	
}
