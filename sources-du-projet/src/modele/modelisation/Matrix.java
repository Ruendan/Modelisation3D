package modele.modelisation;

public class Matrix {
	
	protected Double[][] matrice;
	
	public static final Matrix MATRICETRANSFORMATION = new Matrix( new Double[][]{
		{1.0,	0.0,	0.0},
		{0.0,	1.0,	0.0}});
	
	public Matrix(int size){
		this.matrice = new Double[size][];
	}
	
	public Matrix(Double[][] matrice){
		this.matrice = matrice;
	}
	
	public Matrix(int size1, int size2) {
		matrice = new Double[size1][size2];
	}
	
	public int length() {
		return matrice.length;
	}
	
	public Double[][] getMatrix(){
		return matrice;
	}
	
	
	public static void rotateX(AllPoint points,double theta) {
		theta = Math.toRadians(theta);
		Matrix matrice = new Matrix(new Double[][]{
			{1.0,				0.0,						0.0},
			{0.0,				Math.cos(theta),			-Math.sin(theta)},
			{0.0,				Math.sin(theta),			Math.cos(theta)}});
		
		multiplyMatrice(matrice,points);
	}
	
	
	public static void rotateY(AllPoint point2,double theta) {
		theta = Math.toRadians(theta);
		Matrix matrice = new Matrix(new Double[][]{
			{Math.cos(theta),		0.0,		-Math.sin(theta)},
			{0.0,					1.0,		0.0},
			{Math.sin(theta),		0.0,		Math.cos(theta)}});
		
		multiplyMatrice(matrice,point2);
	}
	
	public static void rotateZ(AllPoint points,double theta) {
		theta = Math.toRadians(theta);
		Matrix matrice = new Matrix(new Double[][]{
			{Math.cos(theta),	-Math.sin(theta),	0.0},
			{Math.sin(theta),	Math.cos(theta),	0.0},
			{0.0,				0.0,				1.0}});	
			
		multiplyMatrice(matrice,points);
	}
	
	private static void multiplyMatrice(Matrix matrice, AllPoint points) {
		Point res = new Point(matrice.length());
		Point p = new Point(3);
		for(int k = 0 ; k<points.size() ; k++) {
			p.setPoint(points.matrice[k][0], points.matrice[k][1], points.matrice[k][2]);
			for(int i=0; i<matrice.length();i++) {
				res.getCoord()[i]=0.0;
				for(int j = 0 ; j<p.getCoord().length;j++) {
					res.getCoord()[i]+=(p.getCoord()[j])*matrice.getMatrix()[i][j];
				}
				
			}
			points.matrice[k][0] = res.getCoord()[0];
			points.matrice[k][0] = res.getCoord()[1];
			if(res.getCoord().length==3) points.matrice[k][2] = res.getCoord()[2]; 
		}
	}
	
	public static void transformation(AllPoint points) {
		multiplyMatrice(MATRICETRANSFORMATION,points);
	}
	
	
}
