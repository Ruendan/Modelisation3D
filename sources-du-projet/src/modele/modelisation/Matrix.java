package modele.modelisation;

public class Matrix {
	
	private Double[][] matrice;
	public static final Matrix MATRICETRANSFORMATION = new Matrix( new Double[][]{
		{1.0,	0.0,	0.0},
		{0.0,	1.0,	0.0}});
	
	public Matrix(Point p){
		this.matrice = new Double[][]{{p.getX(), p.getY(), p.getZ()}};
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
	
	
	public static void rotateZ(Point point2,double theta) {
		theta = Math.toRadians(theta);
		Matrix matrice = new Matrix(new Double[][]{
			{Math.cos(theta),	-Math.sin(theta),	0.0},
			{Math.sin(theta),	Math.cos(theta),	0.0},
			{0.0,				0.0,				1.0}});	
			
		multiplyMatrice(matrice,point2);
	}
	
	public static void rotateX(Point point2,double theta) {
		theta = Math.toRadians(theta);
		Matrix matrice = new Matrix(new Double[][]{
			{1.0,				0.0,						0.0},
			{0.0,				Math.cos(theta),			-Math.sin(theta)},
			{0.0,				Math.sin(theta),			Math.cos(theta)}});
		
		multiplyMatrice(matrice,point2);
	}
	
	
	public static void rotateY(Point point2,double theta) {
		theta = Math.toRadians(theta);
		Matrix matrice = new Matrix(new Double[][]{
			{Math.cos(theta),		0.0,		-Math.sin(theta)},
			{0.0,					1.0,		0.0},
			{Math.sin(theta),		0.0,		Math.cos(theta)}});
		
		multiplyMatrice(matrice,point2);
	}
	
	private static void multiplyMatrice(Matrix matrice, Point point2) {
		Double[] res = new Double[matrice.length()];
		Double[] p = new Double[] {point2.getX(),point2.getY(),point2.getZ()};
		
		
		for(int i=0; i<matrice.length();i++) {
			res[i]=0.0;
			for(int j = 0 ; j<p.length;j++) {
				res[i]+=(p[j])*matrice.getMatrix()[i][j];
			}
			
		}
		point2.setX(res[0]);
		point2.setY(res[1]);
		if(res.length==3) point2.setZ(res[2]); 
	}
	
	public static void transformation(Point point2) {
		multiplyMatrice(MATRICETRANSFORMATION,point2);
	}
	
	private static void multiplyMatrice(Matrix matrice, Matrix points) {
		Matrix res = new Matrix(matrice.matrice.length, points.matrice[0].length);
		for(int i = 0; i<matrice.matrice.length; i++) { // Itère sur chaque ligne de la 1e matrice
			for(int j=0; j<points.matrice.length;j++) { // Itère sur chaque ligne de la 2e matrice
				double res2 = 0;
				for(int k=0; k<points.matrice[j].length; k++) { //Itère sur chaque colonne des 2 matrices
					res2 += (matrice.matrice[i][k] * points.matrice[j][k]);
				}
				res.matrice[i][j] = res2;
			}
		}
		System.out.println(res);
	}
	
	public static void transformation(Matrix points) {
		multiplyMatrice(MATRICETRANSFORMATION,points);
	}
	
	public static void main(String[] args) {
		Matrix m1 = new Matrix(new Double[][]{
			{1.0,2.0,3.0},
			{4.0,5.0,6.0},
			{7.0,8.0,9.0}
		});
		
		Matrix m2 = new Matrix(new Double[][]{
			{1.0,2.0,3.0},
			{4.0,5.0,6.0},
			{7.0,8.0,9.0}
		});
		
		multiplyMatrice(m1, m2);
	}
}
