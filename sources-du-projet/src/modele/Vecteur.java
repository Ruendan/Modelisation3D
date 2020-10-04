package modele;

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
	
	public static Vecteur getNormal(Point a,Point b, Point c) {
		double x,y,z;
		Vecteur ab = new Vecteur(a,b);
		Vecteur ac = new Vecteur(a,c);
		removeZ(ab,ac);
		simplAC(ab,ac);
		return null;
	}
	
	private static Vecteur simplAC(Vecteur ab, Vecteur ac) {
		double y = ac.dirX;
		double x = -(ac.dirY);
		double z = (ab.dirX*x+ab.dirY*y)/ab.dirZ;//TODO
		return new Vecteur(ab.dirX,ab.dirY,ab.dirZ);
	}

	private static void removeZ(Vecteur ab, Vecteur ac) {
		double facteur = Math.abs(ac.dirZ)/Math.abs(ab.dirZ);
		ab.dirX*=facteur;
		ab.dirY*=facteur;
		ab.dirZ*=facteur;
		ac.dirX+=ab.dirX;
		ac.dirY+=ab.dirY;
		ac.dirZ+=ab.dirZ;
	}

	public String toString() {
		return ""+dirX+","+dirY+","+dirZ;
	}
	
}
