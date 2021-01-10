package modele.modelisation;

public class Mouvement {

	/**
	 * Rotate the {@link Figure}
	 * @param f
	 * 		The {@link Figure} rotated
	 * @param thetaX
	 * 		The angle of rotation of the X axis
	 * @param thetaY
	 * 		The angle of rotation of the Y axis
	 * @param thetaZ
	 * 		The angle of rotation of the Z axis
	 */
	public static void rotate(Figure f, double thetaX, double thetaY, double thetaZ) {	
		for(Point p : f.getPoints()) p.rotate(thetaX, thetaY, thetaZ);
	}
	
	/**
	 * Rotate the {@link Figure} on the X axis
	 * @param figure
	 * 		The {@link Figure} rotated	
	 * @param tetha
	 * 		The angle of rotation
	 */
	public static void rotateX(Figure figure, double theta) {
		for(Point p : figure.getPoints()) p.rotateX(theta);	
	}
	
	/**
	 * Rotate the {@link Figure} on the Y axis
	 * @param figure
	 * 		The {@link Figure} rotated
	 * @param tetha
	 * 		The angle of rotation
	 */
	public static void rotateY(Figure figure, double tetha) {
		for(Point p : figure.getPoints()) p.rotateY(tetha);	
	}
	
	/**
	 * Rotate the {@link Figure} on the Z axis
	 * @param figure
	 * 		The {@link Figure} rotated
	 * @param tetha
	 * 		The angle of rotation
	 */
	public static void rotateZ(Figure figure, double tetha) {
		for(Point p : figure.getPoints()) p.rotateZ(tetha);	
	}
	
	/**
	 * Move the figure
	 * @param f
	 * 		The {@link Figure} moved
	 * @param x
	 * 		Moving value on the X axis
	 * @param y
	 * 		Moving value on the Y axis
	 * @param z
	 * 		Moving value on the Z axis
	 */
	public static void deplacer(Figure f, double x, double y, double z) {
		for(Point p : f.getPoints()) p.deplacer(x, y, z);
	}
	
	/**
	 * Move the {@link Figure} on the X axis
	 * @param f
	 * 		The {@link Figure} moved
	 * @param x
	 * 		Moving value
	 */
	public static void deplacerX(Figure f, double x) {
		for(Point p : f.getPoints()) p.deplacerX(x);
	}
	
	
	/**
	 * Move the {@link Figure} on the Y axis
	 * @param f
	 * 		The {@link Figure} moved
	 * @param y
	 * 		Moving value 
	 */
	public static void deplacerY(Figure f, double y) {
		for(Point p : f.getPoints()) p.deplacerY(y);
	}
	
	
	/**
	 * Move the {@link Figure} on the Z axis
	 * @param f
	 * 		The {@link Figure} moved
	 * @param z
	 * 		Moving value
	 */
	public static void deplacerZ(Figure f, double z) {
		for(Point p : f.getPoints()) p.deplacerZ(z);
	}

}

