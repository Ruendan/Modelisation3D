package modele.modelisation;

public class Matrix {
	
	private final Double[][] matrice;
	public static final Matrix MATRICETRANSFORMATION = new Matrix( new Double[][]{
		{1.0,	0.0,	0.0},
		{0.0,	1.0,	0.0}});
	
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
		final Matrix matrice = new Matrix(new Double[][]{
			{Math.cos(theta),	-Math.sin(theta),	0.0},
			{Math.sin(theta),	Math.cos(theta),	0.0},
			{0.0,				0.0,				1.0}});	
			
		multiplyMatrice(matrice,point2);
	}
	
	public static void rotateX(Point point2,double theta) {
		theta = Math.toRadians(theta);
		final Matrix matrice = new Matrix(new Double[][]{
			{1.0,				0.0,						0.0},
			{0.0,				Math.cos(theta),			-Math.sin(theta)},
			{0.0,				Math.sin(theta),			Math.cos(theta)}});
		
		multiplyMatrice(matrice,point2);
	}
	
	
	public static void rotateY(Point point2,double theta) {
		theta = Math.toRadians(theta);
		final Matrix matrice = new Matrix(new Double[][]{
			{Math.cos(theta),		0.0,		-Math.sin(theta)},
			{0.0,					1.0,		0.0},
			{Math.sin(theta),		0.0,		Math.cos(theta)}});
		
		multiplyMatrice(matrice,point2);
	}
	
	private static void multiplyMatrice(Matrix matrice, Point point2) {
		Double[] res = new Double[matrice.length()];
		final Double[] p = {point2.getX(),point2.getY(),point2.getZ()};
		
		
		for(int i=0; i<matrice.length();i++) {
			res[i]=0.0;
			for(int j = 0 ; j<p.length;j++) {
				res[i]+=(p[j])*matrice.getMatrix()[i][j];
			}
			
		}
		point2.setX(res[0]);
		point2.setY(res[1]);
		final int nbCoord = 3;
		if(res.length==nbCoord) point2.setZ(res[2]); 
	}
	
	public static void transformation(Point point2) {
		multiplyMatrice(MATRICETRANSFORMATION,point2);
	}
	
	
}
