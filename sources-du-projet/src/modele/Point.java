package modele;

import modele.modelisation.Matrix;

public class Point {
	private double x;
	private double y;
	private double z;
	
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
	}
	public Point(double x, double y) {
		this.x=x;
		this.y=y;
		this.z=0;
	}

	@Override
	public String toString() {
		return "x:" + x + "y:" + y + "z:" + z + ";";
	}

	public void setPoint(Point point) {
		this.x = point.getX();
		this.y = point.getY();
		this.z = point.getZ();
	}
	
	
	public void rotate(double thetaX, double thetaY, double thetaZ) {
		this.setPoint(Matrix.rotateX(Matrix.rotateY(Matrix.rotateZ(this, thetaZ), thetaY), thetaX));		
	}
	
	public void deplacerX(double x) {
		this.x+=x;
	}
	
	public void deplacerY(double y) {
		this.y+=y;
	}
	
	public void deplacerZ(double z) {
		this.z+=z;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(x);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(y);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(z);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point other = (Point) obj;
		if (Double.doubleToLongBits(x) != Double.doubleToLongBits(other.x))
			return false;
		if (Double.doubleToLongBits(y) != Double.doubleToLongBits(other.y))
			return false;
		if (Double.doubleToLongBits(z) != Double.doubleToLongBits(other.z))
			return false;
		return true;
	}
	
	

}
