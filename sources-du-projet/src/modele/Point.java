package modele;

public class Point {
	private double x;
	private double y;
	private double z;
	private boolean dim2;
	
	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public double getZ() {
		return z;
	}
	
	public void deplacer(double x,double y,double z) {
		this.x+=x;
		this.y+=y;
		this.z+=z;
	}
	
	public void agrandir(double multi) {
		this.x*=multi;
		this.y*=multi;
		this.z*=multi;
	}

	public Point(double x, double y, double z) {
		this.x=x;
		this.y=y;
		this.z=z;
		this.dim2=false;
	}
	public Point(double x, double y) {
		this.x=x;
		this.y=y;
		this.z=0;
		this.dim2=true;
	}

	public boolean isDim2() {
		return dim2;
	}
}
