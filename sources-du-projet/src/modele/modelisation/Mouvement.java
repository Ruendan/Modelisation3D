package modele.modelisation;

public class Mouvement {

	public static void rotate(Figure f, double thetaX, double thetaY, double thetaZ) {	
		//Point center = f.getCenter();
		//Point temp = new Point(center.getX(), center.getY(), center.getZ());
		//deplacer(f, center.getX(), center.getY(), center.getZ());
		
		f.getPoints().rotate(thetaX, thetaY, thetaZ);
		
		//deplacer(f, temp.getX(), temp.getY(), temp.getZ());

	}

	public static void rotateX(Figure figure, double i) {
		figure.getPoints().rotateX(i);	
	}
	
	public static void rotateY(Figure figure, double i) {
		figure.getPoints().rotateY(i);	
	}
	
	public static void rotateZ(Figure figure, double i) {
		figure.getPoints().rotateZ(i);	
	}
	
	
	public static void deplacer(Figure f, double x, double y, double z) {
		f.getPoints().deplacer(x, y, z);
	}
	
	public static void deplacerX(Figure f, double x) {
		f.getPoints().deplacerX(x);
	}
	
	public static void deplacerY(Figure f, double y) {
		f.getPoints().deplacerY(y);
	}
	
	public static void deplacerZ(Figure f, double z) {
		f.getPoints().deplacerZ(z);
	}

}

