package modele.modelisation;

public class Point{
	private static final int X = 0;
	private static final int Y = 1;
	private static final int Z = 2;
	
	private Double[] coord;
	
	public Double[] getCoord() {
		return coord;
	}
	
	public Double getX() {
		return this.coord[X];
	}
	
	public Double getY() {
		return this.coord[Y];
	}
	
	public Double getZ() {
		return this.coord[Z];
	}
	
	public void setX(Double x) {
		this.coord[X] = x;
	}
	
	public void setY(Double y) {
		this.coord[Y] = y;
	}
	
	public void setZ(Double z) {
		this.coord[Z] = z;
	}
	
	public Point(double x, double y, double z) {
		this.coord = new Double[] {x,y,z};
	}
	public Point(double x, double y) {
		this.coord = new Double[] {x,y};
	}
	
	public Point(int size) {
		this.coord = new Double[size];
	}

	@Override
	public String toString() {
		return "x:" + coord[X] + "y:" + coord[Y] + "z:" + coord[Z] + ";";
	}

	public void setPoint(Double x, Double y, Double z) {
		this.setX(x);
		this.setY(y);
		this.setZ(z);
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(coord[X]);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(coord[Y]);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(coord[Z]);
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
		if (Double.doubleToLongBits(coord[X]) != Double.doubleToLongBits(other.coord[X]))
			return false;
		if (Double.doubleToLongBits(coord[Y]) != Double.doubleToLongBits(other.coord[Y]))
			return false;
		if (Double.doubleToLongBits(coord[Z]) != Double.doubleToLongBits(other.coord[Z]))
			return false;
		return true;
	}

	public void deplacer(double x, double y, double z) {
		this.coord[X]+=x;
		this.coord[Y]+=y;
		this.coord[Z]+=z;
	}

	public void deplacerX(double x) {
		this.coord[X]+=x;
	}
	
	public void deplacerY(double y) {
		this.coord[Y]+=y;
	}

}
