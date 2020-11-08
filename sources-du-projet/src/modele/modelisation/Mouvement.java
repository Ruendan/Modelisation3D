package modele.modelisation;

public class Mouvement {

	public static void rotate(Figure f, double thetaX, double thetaY, double thetaZ) {	
		//Point center = f.getCenter();
		//Point temp = new Point(center.getX(), center.getY(), center.getZ());
		//deplacer(f, center.getX(), center.getY(), center.getZ());
		
		for(Point p : f.getPoints()) p.rotate(thetaX, thetaY, thetaZ);
		
		//deplacer(f, temp.getX(), temp.getY(), temp.getZ());

	}

	public static void rotateX(Figure figure, int i) {
		for(Point p : figure.getPoints()) p.rotateX(i);	
	}
	
	public static void rotateY(Figure figure, int i) {
		for(Point p : figure.getPoints()) p.rotateY(i);	
	}
	
	public static void rotateZ(Figure figure, int i) {
		for(Point p : figure.getPoints()) p.rotateZ(i);	
	}
	
	
	public static void deplacer(Figure f, double x, double y, double z) {
		for(Point p : f.getPoints()) p.deplacer(x, y, z);
	}
	
	public static void deplacerX(Figure f, double x) {
		for(Point p : f.getPoints()) p.deplacerX(x);
	}
	
	public static void deplacerY(Figure f, double y) {
		for(Point p : f.getPoints()) p.deplacerY(y);
	}
	
	public static void deplacerZ(Figure f, double z) {
		for(Point p : f.getPoints()) p.deplacerZ(z);
	}

}

