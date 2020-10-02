package modele;

public class Mouvement {
	
	public Mouvement() {
	}
	
	public void rotate(Figure f, double thetaX, double thetaY, double thetaZ) {
		Point temp = new Point(f.getCenter().getX(), f.getCenter().getY(), f.getCenter().getZ());
		this.deplacer(f,-f.getCenter().getX(), -f.getCenter().getY(), -f.getCenter().getZ());
		
		for(Point p : f.getPoints()) {
			p.rotate(thetaX, thetaY, thetaZ);
		}
		this.deplacer(f,temp.getX(), temp.getY(), temp.getZ());
	}
	
	
	public void deplacer(Figure f, double x, double y, double z) {
		for(Point p : f.getPoints()) {
			p.deplacer(x, y, z);
		}
		f.getCenter().deplacer(x, y, z);
	}
}

