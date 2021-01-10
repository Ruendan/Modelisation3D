package modele.modelisation;

import com.sun.org.apache.bcel.internal.generic.POP;

import sun.security.util.Length;

public class Matrix {
	
	private Double[][] matrice;
	
	
	private static final Matrix MATRICETRANSFORMATION = new Matrix( new Double[][]{
		{1.0,	0.0,	0.0},
		{0.0,	1.0,	0.0}});
	
	/**
	 * Create the matrix of a {@link Point}
	 * @param p
	 * 		The {@link Point} which is use for create the matrix
	 */
	public Matrix(Point p){
		this.matrice = new Double[][]{{p.getX(), p.getY(), p.getZ()}};
	}
	
	/**
	 * Create a matrix from an array of {@link Double}
	 * @param matrice
	 * 		The array of {@link Double} which is use for create the matrix
	 */
	public Matrix(Double[][] matrice){
		this.matrice = matrice;
	}
	
	/**
	 * Get the length of the matrix
	 * @return
	 * 		Return the length of the matrix
	 */
	public int length() {
		return matrice.length;
	}
	
	/**
	 * Get the matrix
	 * @return
	 * 		The matrix
	 */
	public Double[][] getMatrix(){
		return matrice;
	}
	
	/**
	 * Rotate a {@link Point} in the Z axis
	 * @param point2
	 * 		the {@link Point} we are going to rotate
	 * @param theta
	 * 		the angle of the rotation
	 */
	public static void rotateZ(Point point2,double theta) {
		theta = Math.toRadians(theta);
		Matrix matrice = new Matrix(new Double[][]{
			{Math.cos(theta),	-Math.sin(theta),	0.0},
			{Math.sin(theta),	Math.cos(theta),	0.0},
			{0.0,				0.0,				1.0}});	
			
		multiplyMatrice(matrice,point2);
	}
	
	/**
	 * Rotate a {@link Point} in the X axis
	 * @param point2
	 * 		the {@link Point} we are going to rotate
	 * @param theta
	 * 		the angle of the rotation
	 */
	public static void rotateX(Point point2,double theta) {
		theta = Math.toRadians(theta);
		Matrix matrice = new Matrix(new Double[][]{
			{1.0,				0.0,						0.0},
			{0.0,				Math.cos(theta),			-Math.sin(theta)},
			{0.0,				Math.sin(theta),			Math.cos(theta)}});
		
		multiplyMatrice(matrice,point2);
	}
	
	/**
	 * Rotate a {@link Point} in the Y axis
	 * @param point2
	 * 		the {@link Point} we are going to rotate
	 * @param theta
	 * 		the angle of the rotation
	 */
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
	
	/**
	 * transfers the point of a 3d space to a 2d plane
	 * @param point2
	 */
	public static void transformation(Point point2) {
		multiplyMatrice(MATRICETRANSFORMATION,point2);
	}
	
	
}
