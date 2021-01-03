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
		//System.out.println(a.getX()+" "+b.getX());
	}
	
	public static Vecteur getNormal(AllPoint liste) {
		return getNormal(liste.get(0), liste.get(1), liste.get(2));
	}
	
	public static Vecteur getNormal(Point a,Point b, Point c) {
		double nx,ny,nz,nn;
		Vecteur ab = new Vecteur(a,b);
		Vecteur ac = new Vecteur(a,c);
		nx = ab.dirY*ac.dirZ-ab.dirZ*ac.dirY;
		ny = ab.dirZ*ac.dirX-ab.dirX*ac.dirZ;
		nz = ab.dirX*ac.dirY-ab.dirY*ac.dirX;
		nn = Math.sqrt(nx*nx+ny*ny+nz*nz);
		Vecteur normal = new Vecteur(nx/nn, ny/nn, nz/nn);
		return normal;
	}
	
	public double produitScalaire(Vecteur vb) {
		return this.getDirX()*vb.getDirX()+this.getDirY()*vb.getDirY()+this.getDirZ()*vb.getDirZ();
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
