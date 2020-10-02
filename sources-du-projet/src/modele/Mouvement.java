package modele;

import java.util.ArrayList;
import java.util.List;

public class Mouvement {
	
	private List<Point> alreadyMoved;
	private List<Point> alreadyRotated;
	
	public Mouvement() {
		alreadyMoved= new ArrayList<Point>();
		alreadyRotated = new ArrayList<Point>();
	}
	
	public void rotate(Figure f, double thetaX, double thetaY, double thetaZ) {
		Point temp = new Point(f.getCenter().getX(), f.getCenter().getY(), f.getCenter().getZ());
		this.deplacer(f,-f.getCenter().getX(), -f.getCenter().getY(), -f.getCenter().getZ());
		
		for(Face face : f.getFaces()) {
			for(Point p : face.getPoints()) {
				if(!alreadyRotated.contains(p)) {
					p.rotate(thetaX, thetaY, thetaZ);
					alreadyRotated.add(p);
				}
			}
		}
		this.deplacer(f,temp.getX(), temp.getY(), temp.getZ());
	}
	
	public void deplacer(Figure f, double x, double y, double z) {
		for(Face face : f.getFaces()){
			for(Point p : face.getPoints()) {
				if(!alreadyMoved.contains(p)) {
					p.deplacer(x, y, z);
				}
			}
		}
		f.getCenter().deplacer(x, y, z);
	}
}
