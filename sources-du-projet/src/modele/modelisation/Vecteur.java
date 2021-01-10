package modele.modelisation;

import java.util.List;

public class Vecteur {

	private double dirX;
	private double dirY;
	private double dirZ;
	
	private double norm;
	
	/**
	 * Create a vector using coordinate
	 * @param dirX
	 * 		The X coordinate
	 * @param dirY
	 * 		The Y coordinate
	 * @param dirZ
	 * 		The Z coordinate
	 */
	public Vecteur(double dirX, double dirY, double dirZ) {
		this.dirX = dirX;
		this.dirY = dirY;
		this.dirZ = dirZ;
		double x = Math.pow(dirX, 2);
		double y = Math.pow(dirY, 2);
		double z = Math.pow(dirZ, 2);
		this.norm = Math.sqrt(x+y+z);
	}
	
	/**
	 * Create a vector using 2 {@link Point}
	 * @param a
	 * 		1st  {@link Point}
	 * @param b
	 * 		2nd {@link Point}
	 */
	public Vecteur(Point a,Point b) {
		this(b.getX()-a.getX(),b.getY()-a.getY(),b.getZ()-a.getZ());
	}
	
	/**
	 * Get the normal vector of a {@link List} of {@link Point}
	 * @param liste
	 * 		{@link List} of {@link Point}
	 * @return
	 * 		The normal director of a {@link List} of {@link Point}
	 */
	public static Vecteur getNormal(List<Point> liste) {
		return getNormal(liste.get(0), liste.get(1), liste.get(2));
	}
	
	/**
	 * Get the normal vector of 3 {@link Point}
	 * @param a
	 *		1st {@link Point} 		
	 * @param b
	 * 		2nd {@link Point}
	 * @param c
	 * 		3rd {@link Point}
	 * @return
	 * 		return the normal vector of these {@link Point}
	 */
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
	
	/**
	 * Do the scalar product between this vector an another vector
	 * @param vb
	 * 		The other vector
	 * @return
	 * 		The result of the scalar product between these two vector
	 */
	public double produitScalaire(Vecteur vb) {
		return this.getDirX()*vb.getDirX()+this.getDirY()*vb.getDirY()+this.getDirZ()*vb.getDirZ();
	}
	
	/**
	 * Create a director vector from 3 components
	 * @param x
	 * 		1st component
	 * @param y
	 * 		2nd component
	 * @param z
	 * 		3rd component
	 * @return
	 * 		return the director vector of these three component
	 */
	public static Vecteur getDirecteur(double x,double y,double z) {
		double norm = Math.sqrt(x*x+y*y+z*z);
		Vecteur directeur = new Vecteur(-x/norm, -y/norm, -z/norm);
		return directeur;
	}
	
	/**
	 * Get the direction on the X axis
	 * @return
	 * 		The direction
	 */
	public double getDirX() {
		return dirX;
	}
	
	/**
	 * Set the new direction of X
	 * @param dirX
	 * 		The new direction
	 */
	public void setDirX(double dirX) {
		this.dirX = dirX;
	}
	
	/**
	 * Get the direction on the Y axis
	 * @return
	 * 		The direction
	 */
	public double getDirY() {
		return dirY;
	}
	/**
	 * Set the new direction of Y
	 * @param dirY
	 * 		The new direction
	 */
	public void setDirY(double dirY) {
		this.dirY = dirY;
	}
	
	/**
	 * Get the direction on the Z axis
	 * @return
	 * 		The direction
	 */
	public double getDirZ() {
		return dirZ;
	}
	/**
	 * Set the new direction of Z
	 * @param dirZ
	 * 		The new direction
	 */
	public void setDirZ(double dirZ) {
		this.dirZ = dirZ;
	}
	/**
	 * Get the norm value
	 * @return
	 * 		norm
	 */
	public double getNorm() {
		return norm;
	}
	/**
	 * Set the norm value
	 * @param norm
	 * 		The new value of norm
	 */
	public void setNorm(double norm) {
		this.norm = norm;
	}
	
	@Override
	public String toString() {
		return ""+dirX+","+dirY+","+dirZ;
	}
	
}
