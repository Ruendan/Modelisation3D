package modele.modelisation;

public class AllPoint extends Matrix {
	
	protected static final int COORD_SIZE = 3;
	private static final int X = 0;
	private static final int Y = 1;
	private static final int Z = 2;
	private int nbPoint;
	private int size;
	//private Point point = new Point(0,0,0);
	
	public AllPoint(int size) {
		super(size);
		this.size = size;
		this.nbPoint = 0;
	}

	public boolean add(Point point) {
		if(this.isFull()) return false;
		this.matrice[nbPoint] = point.getCoord();
		nbPoint ++;
		return true;
	}

	private boolean isFull() {
		return this.nbPoint == this.size;
	}

//	public Point get(int i) {
//		return matrice[i];
//	}

	public double size() {
		return size;
	}

	public void agrandir(double zoom) {
		for(int i = 0; i<this.size ; i++) {
			for(int j = 0; j < COORD_SIZE ; j++) {
				matrice[i][j]*=zoom;
			}
		}
	}

	public double[] getExtremePoint() {
		double[] extreme = new double[6];
		for(int i = 0 ; i < extreme.length ; i++) {
			extreme[i] = 0;
		}
		for(int i = 0; i<this.size ; i++) {
			if(extreme[0]>matrice[i][X]) extreme[0] = matrice[i][X]; 
			if(extreme[1]<matrice[i][X]) extreme[1] = matrice[i][X];
			if(extreme[2]>matrice[i][Y]) extreme[2] = matrice[i][Y]; 
			if(extreme[3]<matrice[i][Y]) extreme[3] = matrice[i][Y];
			if(extreme[4]>matrice[i][Z]) extreme[4] = matrice[i][Z]; 
			if(extreme[5]<matrice[i][Z]) extreme[5] = matrice[i][Z];
		}
		return extreme;
	}

	public void rotate(double thetaX, double thetaY, double thetaZ) {
		Matrix.rotateX(this, thetaX);
		Matrix.rotateY(this, thetaY);
		Matrix.rotateZ(this, thetaZ);		
	}
	
	public void rotateX(double theta) {
		Matrix.rotateX(this, theta);
	}
	
	public void rotateY(double theta) {
		Matrix.rotateY(this, theta);
	}
	
	public void rotateZ(double theta) {
		Matrix.rotateZ(this, theta);
	}
	
	public void deplacerX(double x) {
		for(int i = 0 ; i<this.size ; i++) this.matrice[i][X]+=x;
	}
	
	public void deplacerY(double y) {
		for(int i = 0 ; i<this.size ; i++) this.matrice[i][Y]+=y;
	}
	
	public void deplacerZ(double z) {
		for(int i = 0 ; i<this.size ; i++) this.matrice[i][Z]+=z;
	}
	
	public void deplacer(double x,double y,double z) {
		for(int i = 0 ; i<this.size ; i++) {
			this.matrice[i][X]+=x;
			this.matrice[i][Y]+=y;
			this.matrice[i][Z]+=z;
		}
	}

	public boolean isEmpty() {
		return nbPoint == 0;
	}
}
