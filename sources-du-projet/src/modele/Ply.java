package modele;

import java.util.List;

public class Ply {
	
	private String type; //ply
	private String format; //ASCII 
	
	//NbPoints
	private int vertex;
	//NbFaces
	private int face;
	
	// Abcisse du point sur X, Y et Z
	private float x; 
	private float y; 
	private float z; 
	
	/* Normale a : X, Y, Z*/
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
	
	
	private List<Point> points;
	private List<Face> faces;
	
	public Ply(String type, String format, int vertex, int face, float x, float y, float z, 
			float nx, float ny, float nz,
			String red, String green, String blue, String alpha, int vertex_indice_elem,
			List<Integer> vertex_indices, List<Face> faces, List<Point> points) {
		super();
		this.type = type;
		this.format = format;
		this.vertex = vertex;
		this.face = face;
		this.x = x;
		this.y = y;
		this.z = z;
		this.nx = nx;
		this.ny = ny;
		this.nz = nz;
		this.red = red;
		this.green = green;
		this.blue = blue;
		this.alpha = alpha;
		this.vertex_indice_elem = vertex_indice_elem;
		this.vertex_indices = vertex_indices;
		this.faces=faces;
		this.points=points;
	}

	public String getType() {
		return type;
	}

	public String getFormat() {
		return format;
	}

	public int getVertex() {
		return vertex;
	}

	public int getFace() {
		return face;
	}

	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}

	public float getZ() {
		return z;
	}

	public float getNx() {
		return nx;
	}

	public float getNy() {
		return ny;
	}

	public float getNz() {
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

	public List<Point> getPoints() {
		return points;
	}

	public List<Face> getFaces() {
		return faces;
	}

}
