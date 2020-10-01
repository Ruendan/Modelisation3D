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

}
