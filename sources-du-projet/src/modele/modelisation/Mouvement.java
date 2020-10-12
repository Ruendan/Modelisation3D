package modele.modelisation;

public class Mouvement {

	public static void rotate(Figure f, double thetaX, double thetaY, double thetaZ) {		
		Point temp = new Point(f.getCenter().getX(), f.getCenter().getY(), f.getCenter().getZ());
		deplacer(f, -f.getCenter().getX(), -f.getCenter().getY(), -f.getCenter().getZ());
		
//		for(int i = 0; i < f.getPoints().size() ; i++) {
//			f.getPoints().get(i).rotate(thetaX, thetaY, thetaZ);
//		}
		for(Point p : f.getPoints()) p.rotate(thetaX, thetaY, thetaZ);
		
		deplacer(f, temp.getX(), temp.getY(), temp.getZ());

	}
	
	
	public static void deplacer(Figure f, double x, double y, double z) {
//		for(int i = 0; i < f.getPoints().size() ; i++) {
//			f.getPoints().get(i).deplacer(x, y, z);
//		}
		for(Point p : f.getPoints()) p.deplacer(x, y, z);
		
		f.getCenter().deplacer(x, y, z);
	}
}

