package modele;

import java.util.List;

public class Ply {
	
	/*
	private String type; //ply
	private String format; //ASCII 
	*/
	//NbPoints (sommets)
	private int vertex;
	//NbFaces
	private int face;
	/*
	// Abcisse du point sur X, Y et Z
	private double x; 
	private double y; 
	private double z; 
	
	// Normale a : X, Y, Z
	private float nx; 
	private float ny; 
	private float nz; 

	// Codes RGB + Transparency
	private String red; 
	private String green; 
	private String blue;
	private String alpha;
	
	
	private int vertex_indice_elem;
	
	private List<Integer> vertex_indices; 
	*/
	
	private List<Point> points;
	private List<Face> faces;
	
	/*
	public String getType() {
		return type;
	}

	public String getFormat() {
		return format;
	}
    */
	public int getVertex() {
		return vertex;
	}

	public int getFace() {
		return face;
	}
	
	/*
	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public double getZ() {
		return z;
	}

	public double getNx() {
		return nx;
	}

	public double getNy() {
		return ny;
	}

	public double getNz() {
		return nz;
	}

	public String getRed() {
		return red;
	}

	public String getGreen() {
		return green;
	}

	public String getBlue() {
		return blue;
	}

	public String getAlpha() {
		return alpha;
	}

	public int getVertex_indice_elem() {
		return vertex_indice_elem;
	}

	public List<Integer> getVertex_indices() {
		return vertex_indices;
	}
	*/
	public List<Point> getPoints() {
		return points;
	}

	public List<Face> getFaces() {
		return faces;
	}
	
	public void setFaces(List<Face> faces) {
		this.faces = faces;
	}

	public void setPoints(List<Point> points) {
		this.points = points;
	}

	public void setFace(int face) {
		this.face = face;
	}
	
	public void setVertex(int vertex) {
		this.vertex = vertex;
	}

	/*
	public void setFormat(String format) {
		this.format = format;
	}
	*/
	
	public Ply(int vertex, int face, List<Point> points, List<Face> faces) {
		this.vertex = vertex;
		this.face = face;
		this.points = points;
		this.setFaces(faces);
	}

	public Ply() {}

	@Override
	public String toString() {
		return "Ply [vertex=" + vertex + ", face=" + face + ", points=" + points + ", faces=" + faces + "]";
	}
	
	
	
}
