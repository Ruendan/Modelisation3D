package modele.modelisation;

public class Face implements Comparable<Face> {
	
	private int nbPoints;
	private AllPoint points;
	private Vecteur normal;
	private Double closest;
	private double exposition;
	private boolean isUpper;
	private static final Vecteur vVue = new Vecteur(0,0,-1);
	
	public Face(int nbPoints,AllPoint points) {
		this.nbPoints=nbPoints;
		if(points==null) this.points = new AllPoint(nbPoints);
		else this.points=points;
		setClosest();
		setNormal();
	}

	public Point pointMoyen() {
		double x = 0;
		double y = 0;
		double z = 0;
		for(int i = 0 ; i<points.size() ; i++) {
			x+=points.getMatrix()[i][0];
			y+=points.getMatrix()[i][1];
			z+=points.getMatrix()[i][2];
		}
		return new Point(x/nbPoints,y/nbPoints,z/nbPoints);
	}
	
	public double moyenneZ() {
		double res = 0;
		for(int i = 0 ; i<points.size() ; i++) {
			res+=points.getMatrix()[i][2];
		}
		return res/nbPoints;
	}
	
	public double moyenneY() {
		double res = 0;
		for(int i = 0 ; i<points.size() ; i++) {
			res+=points.getMatrix()[i][1];
		}
		return res/nbPoints;
	}

	public double moyenneX() {
		double res = 0;
		for(int i = 0 ; i<points.size() ; i++) {
			res+=points.getMatrix()[i][0];
		}
		return res/nbPoints;
	}
	
	public void preSort() {
		setNormal();
		setClosest();
	}
	
	public void setNormal() {
		if(points!=null && !points.isEmpty())normal = Vecteur.getNormal(points);
		if(normal!=null) {
			exposition = -vVue.produitScalaire(normal);
			if(exposition>0)isUpper = true;
			else isUpper = false;
		}
	}
	
	@Override
	public int compareTo(Face o) {
		
		int point = this.closest.compareTo(o.closest);
		if(point!=0)return point;
		Double moyZ1 = normal.getDirZ();
		Double moyZ2= o.getNormal().getDirZ();
		
		return moyZ1.compareTo(moyZ2);
	}
 
	public void setClosest() {
		double petit;
		if(this.getNbPoints()==0)
			petit = Double.NaN;
		else petit = points.get(0).getZ();
		
		for(int i = 0 ; i<points.size() ; i++) {
			if(points.getMatrix()[i][2]<petit)petit=points.getMatrix()[i][2];
		}
		this.closest = petit;
	}
	
	public Double getClosest() {
		return this.closest;
	}

	public Vecteur getNormal() {
		return this.normal;
	}
	public boolean isUpper() {
		return isUpper;
	}
	public int getNbPoints() {
		return nbPoints;
	}
	
	public AllPoint getPoints() {
		return points;
	}
	
	@Override
	public String toString() {
		return "Face [nbPoints=" + nbPoints + ", points:(" + points + ")";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((points == null) ? 0 : points.hashCode());
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
		Face other = (Face) obj;
		
		if (points == null) {
			if (other.points != null)
				return false;
		} else {
			for(int i=0; i<points.size(); i++) {
				if(!this.points.get(i).equals(other.getPoints().get(i))) return false;
			}
		}
		return true;
	}

	public double getExposition() {
		return exposition;
	}
	
}
