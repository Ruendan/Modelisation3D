package modele.modelisation;

import java.util.List;

public class Vecteur {

	private double dirX;
	private double dirY;
	private double dirZ;
	
	private double norm;
	
	public Vecteur(double dirX, double dirY, double dirZ) {
		this.dirX = dirX;
		this.dirY = dirY;
		this.dirZ = dirZ;
		double x = Math.pow(dirX, 2);
		double y = Math.pow(dirY, 2);
		double z = Math.pow(dirZ, 2);
		this.norm = Math.sqrt(x+y+z);
	}
	
	public Vecteur(Point a,Point b) {
		this(b.getX()-a.getX(),b.getY()-a.getY(),b.getZ()-a.getZ());
	}
	
	public static Vecteur getNormal(List<Point> liste) {
		return getNormal(liste.get(0), liste.get(1), liste.get(2));
	}
	
	public static Vecteur getNormal(Point a,Point b, Point c) {
		double x,y,z;
		Vecteur ab = new Vecteur(a,b);
		Vecteur ac = new Vecteur(a,c);
		x = ab.dirY*ac.dirZ-ab.dirZ*ac.dirY;
		y = ab.dirZ*ac.dirX-ab.dirX*ac.dirZ;
		z = ab.dirX*ac.dirY-ab.dirY*ac.dirX;
		Vecteur vn = new Vecteur(x, y, z);
		return new Vecteur(vn.dirX/vn.norm, vn.dirY/vn.norm, vn.dirZ/vn.norm);
	}
	
	public double getDirX() {
		return dirX;
	}

	public void setDirX(double dirX) {
		this.dirX = dirX;
	}

	public double getDirY() {
		return dirY;
	}

	public void setDirY(double dirY) {
		this.dirY = dirY;
	}

	public double getDirZ() {
		return dirZ;
	}

	public void setDirZ(double dirZ) {
		this.dirZ = dirZ;
	}

	public double getNorm() {
		return norm;
	}

	public void setNorm(double norm) {
		this.norm = norm;
	}

	public String toString() {
		return ""+dirX+","+dirY+","+dirZ;
	}
	
}
