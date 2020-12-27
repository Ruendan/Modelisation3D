package modele.modelisation;

import java.util.Collection;

public class Matrix {
	
	private Double[][] matrice;
	public static final Matrix MATRICETRANSFORMATION = new Matrix( new Double[][]{
		{1.0,	0.0,	0.0},
		{0.0,	1.0,	0.0}});
	
	public Matrix(Point p){
		this.matrice = new Double[][]{{p.getX(), p.getY(), p.getZ()}};
	}
	
	public Matrix(Collection<Point> points){
		this.matrice = new Double[points.size()][3];
		int i = 0;
		for(Point p : points) {
			this.matrice[i][0] = p.getX();
			this.matrice[i][1] = p.getY();
			this.matrice[i][2] = p.getZ();
			i++;
		}
	}
	
	public Matrix(Point...p){
		this.matrice = new Double[p.length][3];
		for(int i = 0; i<p.length; i++) {
			this.matrice[i][0] = p[i].getX();
			this.matrice[i][1] = p[i].getY();
			this.matrice[i][2] = p[i].getZ();
		}
	}
	
	public Matrix(int len1, int len2){
		this.matrice = new Double[len1][len2];
	}
	
	public Matrix(Double[][] matrice){
		this.matrice = matrice;
	}

	public int length() {
		return matrice.length;
	}
	
	public Double[][] getMatrix(){
		return matrice;
	}
	
	public void aggrandir(double val) {
		for(Double[] tab : this.matrice) {
			for(Double d : tab) {
				d*=val;
			}
		}
	}
	
	public String toString() {
		StringBuilder res = new StringBuilder();
		for(int i = 0; i<matrice.length;i++) {
			res.append('|');
			for(int j = 0; j<matrice[i].length;j++) {
				res.append(matrice[i][j]);
				res.append('|');
			}
			res.append('\n');
		}
		return res.toString();
	}
	
	
//	public static void rotateZ(Point point2,double theta) {
//		theta = Math.toRadians(theta);
//		Matrix matrice = new Matrix(new Double[][]{
//			{Math.cos(theta),	-Math.sin(theta),	0.0},
//			{Math.sin(theta),	Math.cos(theta),	0.0},
//			{0.0,				0.0,				1.0}});	
//			
//		multiplyMatrice(matrice,point2);
//	}
	
	public static void rotateZ(Matrix point2,double theta) {
		theta = Math.toRadians(theta);
		Matrix matrice = new Matrix(new Double[][]{
			{Math.cos(theta),	-Math.sin(theta),	0.0},
			{Math.sin(theta),	Math.cos(theta),	0.0},
			{0.0,				0.0,				1.0}});	
			
		multiplyMatrice(matrice,point2);
	}
	
//	public static void rotateX(Point point2,double theta) {
//		theta = Math.toRadians(theta);
//		Matrix matrice = new Matrix(new Double[][]{
//			{1.0,				0.0,						0.0},
//			{0.0,				Math.cos(theta),			-Math.sin(theta)},
//			{0.0,				Math.sin(theta),			Math.cos(theta)}});
//		
//		multiplyMatrice(matrice,point2);
//	}
	
	public static void rotateX(Matrix point2,double theta) {
		theta = Math.toRadians(theta);
		Matrix matrice = new Matrix(new Double[][]{
			{1.0,				0.0,						0.0},
			{0.0,				Math.cos(theta),			-Math.sin(theta)},
			{0.0,				Math.sin(theta),			Math.cos(theta)}});
		
		multiplyMatrice(matrice,point2);
	}
	
	
//	public static void rotateY(Point point2,double theta) {
//		theta = Math.toRadians(theta);
//		Matrix matrice = new Matrix(new Double[][]{
//			{Math.cos(theta),		0.0,		-Math.sin(theta)},
//			{0.0,					1.0,		0.0},
//			{Math.sin(theta),		0.0,		Math.cos(theta)}});
//		
//		multiplyMatrice(matrice,point2);
//	}
	
	public static void rotateY(Matrix point2,double theta) {
		theta = Math.toRadians(theta);
		Matrix matrice = new Matrix(new Double[][]{
			{Math.cos(theta),		0.0,		-Math.sin(theta)},
			{0.0,					1.0,		0.0},
			{Math.sin(theta),		0.0,		Math.cos(theta)}});
		
		multiplyMatrice(matrice,point2);
	}
	
//	private static void multiplyMatrice(Matrix matrice, Point point2) {
//		Double[] res = new Double[matrice.length()];
//		Double[] p = new Double[] {point2.getX(),point2.getY(),point2.getZ()};
//		
//		
//		for(int i=0; i<matrice.length();i++) {
//			res[i]=0.0;
//			for(int j = 0 ; j<p.length;j++) {
//				res[i]+=(p[j])*matrice.getMatrix()[i][j];
//			}
//			
//		}
//		point2.setX(res[0]);
//		point2.setY(res[1]);
//		if(res.length==3) point2.setZ(res[2]); 
//	}
	
//	public static void transformation(Point point2) {
//		multiplyMatrice(MATRICETRANSFORMATION,point2);
//	}
	
	private static void multiplyMatrice(Matrix matrice, Matrix points) {
		Matrix res = new Matrix(matrice.matrice.length, points.matrice[0].length);
		for(int i = 0; i<matrice.matrice.length; i++) { // Itère sur chaque ligne de la 1e matrice
			for(int j=0; j<points.matrice[0].length;j++) { // Itère sur chaque ligne de la 2e matrice
				double res2 = 0;
				for(int k=0; k<points.matrice[j].length; k++) { //Itère sur chaque colonne des 2 matrices
					res2 += (matrice.matrice[i][k] * points.matrice[j][k]);
				}
				//System.out.println("i="+ i + " et j=" + j);
				res.matrice[i][j] = res2;
			}
		}
		//System.out.println(res);
	}
	
	public static void transformation(Matrix points) {
		multiplyMatrice(MATRICETRANSFORMATION,points);
	}
	
	public static void main(String[] args) {
		Point p1 = new Point(1.0, 2.0, 3.0);
		Point p2 = new Point(4.0, 5.0, 6.0);
		Point p3 = new Point(7.0, 8.0, 9.0);
		
		Matrix m1 = new Matrix(p1, p2, p3);
		System.out.println(m1);
		
		Matrix m2 = new Matrix(new Double[][]{
			{1.0,2.0,3.0},
			{4.0,5.0,6.0},
			{7.0,8.0,9.0}
		});
		
		multiplyMatrice(m1, m2);
	}

	public static void rotate(Matrix m, double thetaX, double thetaY, double thetaZ) {
		rotateX(m, thetaX);
		rotateY(m, thetaY);
		rotateZ(m, thetaZ);
	}
	
	public static void deplacer(Matrix m, double x, double y, double z) {
		for(Double[] points : m.matrice) {
			points[0]+=x;
			points[1]+=y;
			points[2]+=z;
		}
	}
	
	public static void deplacerX(Matrix m, double x) {
		for(Double[] points : m.matrice) {
			points[0]+=x;
		}
	}
	
	public static void deplacerY(Matrix m, double y) {
		for(Double[] points : m.matrice) {
			points[0]+=y;
		}
	}
	
	public static void deplacerZ(Matrix m, double z) {
		for(Double[] points : m.matrice) {
			points[2]+=z;
		}
	}

	public boolean isEmpty() {
		return matrice.length==0;
	}
}
