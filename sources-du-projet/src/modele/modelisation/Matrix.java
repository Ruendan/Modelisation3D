package modele.modelisation;

public class Matrix {
	
	private Double[][] matrice;
	
	public Matrix(Point p){
		this.matrice = new Double[][]{{p.getX(), p.getY(), p.getZ()}};
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
	
	
	public static void rotateZ(Point point2,double theta) {
		theta = Math.toRadians(theta);
		Matrix matrice = new Matrix(new Double[][]{
			{Math.cos(theta),	-Math.sin(theta),	0.0},
			{Math.sin(theta),	Math.cos(theta),	0.0},
			{0.0,				0.0,				1.0}});	
			
		point2.setPoint(calculMatrice(matrice,point2));
	}
	
	public static void rotateX(Point point2,double theta) {
		theta = Math.toRadians(theta);
		Matrix matrice = new Matrix(new Double[][]{
			{1.0,				0.0,						0.0},
			{0.0,				Math.cos(theta),			-Math.sin(theta)},
			{0.0,				Math.sin(theta),			Math.cos(theta)}});
			
		point2.setPoint(calculMatrice(matrice,point2));
	}
	
	
	public static void rotateY(Point point2,double theta) {
		theta = Math.toRadians(theta);
		Matrix matrice = new Matrix(new Double[][]{
			{Math.cos(theta),		0.0,		-Math.sin(theta)},
			{0.0,					1.0,		0.0},
			{Math.sin(theta),		0.0,		Math.cos(theta)}});
			
		point2.setPoint(calculMatrice(matrice,point2));
	}
	
	public static Point calculMatrice(Matrix matrice, Point point2) {
		Point rep;
		Double[] res = new Double[matrice.length()];
		Double[] p = new Double[] {point2.getX(),point2.getY(),point2.getZ()};
		
		
		for(int i=0; i<matrice.length();i++) {
			res[i]=0.0;
			for(int j = 0 ; j<p.length;j++) {
				res[i]+=(p[j])*matrice.getMatrix()[i][j];
			}
			
		}
		if(res.length==2) rep = new Point(res[0],res[1]) ; 
		else rep = new Point(res[0],res[1],res[2]);
		return rep;
	}
	
	public static Point transformation(Point point2) {
		Matrix matrice = new Matrix( new Double[][]{
			{1.0,	0.0,	0.0},
			{0.0,	1.0,	0.0}});
			
		return calculMatrice(matrice,point2);

	}
	
	
}
