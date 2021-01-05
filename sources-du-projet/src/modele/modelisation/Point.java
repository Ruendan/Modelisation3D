package modele.modelisation;

public class Point extends Matrix{
	private static final int X = 0;
	private static final int Y = 1;
	private static final int Z = 2;
	
	
	public Double[] getCoord() {
		return matrice[0];
	}
	
	public Double getX() {
		return matrice[0][X];
	}
	
	public Double getY() {
		return matrice[0][Y];
	}
	
	public Double getZ() {
		return matrice[0][Z];
	}
	
	public void setX(Double x) {
		matrice[0][X] = x;
	}
	
	public void setY(Double y) {
		matrice[0][Y] = y;
	}
	
	public void setZ(Double z) {
		matrice[0][Z] = z;
	}
	
	public Point(double x, double y, double z) {
		this(3);
		matrice[0][X] = x;
		matrice[0][Y] = y;
		matrice[0][Z] = z;
	}
	public Point(double x, double y) {
		this(2);
		matrice[0][X] = x;
		matrice[0][Y] = y;
	}
	
	public Point(int size) {
		super(1,size);
	}

	@Override
	public String toString() {
		return "x:" + matrice[0][X] + "y:" + matrice[0][Y] + "z:" + matrice[0][Z] + ";";
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
		temp = Double.doubleToLongBits(matrice[0][X]);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(matrice[0][Y]);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(matrice[0][Z]);
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
		if (Double.doubleToLongBits(matrice[0][X]) != Double.doubleToLongBits(other.matrice[0][X]))
			return false;
		if (Double.doubleToLongBits(matrice[0][Y]) != Double.doubleToLongBits(other.matrice[0][Y]))
			return false;
		if (Double.doubleToLongBits(matrice[0][Z]) != Double.doubleToLongBits(other.matrice[0][Z]))
			return false;
		return true;
	}

	public void deplacer(double x, double y, double z) {
		matrice[0][X]+=x;
		matrice[0][Y]+=y;
		matrice[0][Z]+=z;
	}

	public void deplacerX(double x) {
		matrice[0][X]+=x;
	}
	
	public void deplacerY(double y) {
		matrice[0][Y]+=y;
	}

}
