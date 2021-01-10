package modele.modelisation;

public class Point {
	private double x;
	private double y;
	private double z;
	
	/**
	 * Get the X coordinate of the point
	 * @return
	 * 		The X coordinate
	 */
	public Double getX() {
		return x;
	}

	/**
	 * Get the Y coordinate of the point
	 * @return
	 * 		The Y coordinate
	 */
	public Double getY() {
		return y;
	}

	/**
	 * Get the Z coordinate of the point
	 * @return
	 * 		The Z coordinate
	 */
	public Double getZ() {
		return z;
	}
	
	/**
	 * Set the X coordinate
	 * @param x
	 * 		The new value of x
	 */
	public void setX(double x) {
		this.x = x;
	}

	/**
	 * Set the Y coordinate
	 * @param y
	 * 		The new value of y
	 */
	public void setY(double y) {
		this.y = y;
	}

	/**
	 * Set the Z coordinate
	 * @param z
	 * 		The new value of z
	 */
	public void setZ(double z) {
		this.z = z;
	}
	
	/**
	 * Move the point
	 * @param x
	 * 		Moving Value of X
	 * @param y
	 * 		Moving Value of Y
	 * @param z
	 * 		Moving Value of Z
	 */
	public void deplacer(double x,double y,double z) {
		this.x+=x;
		this.y+=y;
		this.z+=z;
	}
	
	/**
	 * Zoom the point
	 * @param multi
	 * 		Zooming value
	 */
	public void agrandir(double multi) {
		this.x*=multi;
		this.y*=multi;
		this.z*=multi;
	}
	
	/**
	 * Create a Point
	 * @param x
	 * 		The X coordinate
	 * @param y
	 * 	 	The Y coordinate
	 * @param z
	 * 		The Z coordinate
	 */
	public Point(double x, double y, double z) {
		this.x=x;
		this.y=y;
		this.z=z;
	}
	/**
	 * Create a 2D Point
	 * @param x
	 * 		The X coordinate
	 * @param y
	 * 	 	The Y coordinate
	 */
	public Point(double x, double y) {
		this.x=x;
		this.y=y;
		this.z=0;
	}

	@Override
	public String toString() {
		return "x:" + x + "y:" + y + "z:" + z + ";";
	}

	/*
	 * Set new coordinate of a Point with an other Point
	 */
	public void setPoint(Point point) {
		this.x = point.getX();
		this.y = point.getY();
		this.z = point.getZ();
	}
	
	/**
	 * Rotate the Point
	 * @param thetaX
	 * 		The angle of rotation of the X axis
	 * @param thetaY
	 * 		The angle of rotation of the Y axis
	 * @param thetaZ
	 * 		The angle of rotation of the Z axis
	 */
	public void rotate(double thetaX, double thetaY, double thetaZ) {
		Matrix.rotateX(this, thetaX);
		Matrix.rotateY(this, thetaY);
		Matrix.rotateZ(this, thetaZ);		
	}
	
	/**
	 * Rotate the point on the X axis
	 * @param theta
	 * 		The angle of rotation
	 */
	public void rotateX(double theta) {
		Matrix.rotateX(this, theta);
	}
	
	/**
	 * Rotate the point on the Y axis
	 * @param theta
	 * 		The angle of rotation
	 */
	public void rotateY(double theta) {
		Matrix.rotateY(this, theta);
	}
	
	/**
	 * Rotate the point on the Z axis
	 * @param theta
	 * 		The angle of rotation
	 */
	public void rotateZ(double theta) {
		Matrix.rotateZ(this, theta);
	}
	
	/**
	 * Move the point on the X axis
	 * @param x
	 * 		The moving value
	 */
	public void deplacerX(double x) {
		this.x+=x;
	}
	
	/**
	 * Move the point on the Y axis
	 * @param y
	 * 		The moving value
	 */
	public void deplacerY(double y) {
		this.y+=y;
	}
	
	/**
	 * Move the point on the Z axis
	 * @param z
	 * 		The moving value
	 */
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
	
	/**
	 * Set new coordinate of the point
	 * @param x
	 * 		new X
	 * @param y
	 * 		new Y
	 * @param z
	 * 		new Z
	 */
	public void setPoint(Double x, Double y, Double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
}
