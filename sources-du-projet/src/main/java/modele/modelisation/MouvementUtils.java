package modele.modelisation;

public class MouvementUtils {

	public static void rotate(Figure f, double thetaX, double thetaY, double thetaZ) {	
		//Point center = f.getCenter();
		//Point temp = new Point(center.getX(), center.getY(), center.getZ());
		//deplacer(f, center.getX(), center.getY(), center.getZ());
		
		for(final Point p : f.getPoints()) p.rotate(thetaX, thetaY, thetaZ);
		
		//deplacer(f, temp.getX(), temp.getY(), temp.getZ());

	}

	public static void rotateX(Figure figure, double i) {
		for(final Point p : figure.getPoints()) p.rotateX(i);	
	}
	
	public static void rotateY(Figure figure, double i) {
		for(final Point p : figure.getPoints()) p.rotateY(i);	
	}
	
	public static void rotateZ(Figure figure, double i) {
		for(final Point p : figure.getPoints()) p.rotateZ(i);	
	}
	
	
	public static void deplacer(Figure f, double x, double y, double z) {
		for(final Point p : f.getPoints()) p.deplacer(x, y, z);
	}
	
	public static void deplacerX(Figure f, double x) {
		for(final Point p : f.getPoints()) p.deplacerX(x);
	}
	
	public static void deplacerY(Figure f, double y) {
		for(final Point p : f.getPoints()) p.deplacerY(y);
	}
	
	public static void deplacerZ(Figure f, double z) {
		for(final Point p : f.getPoints()) p.deplacerZ(z);
	}

}

