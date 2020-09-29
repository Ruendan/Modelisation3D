package modele;

import java.util.List;

public class Ply {
	
	private String type;
	private String format;
	
	//NdPoints
	private int vertex;
	
	private float x; // l'abscisse du point sur l'axe des x
	private float y; // l'ordonnée du point sur l'axe des y
	private float z; // la cote sur l'axe des z
	
	private float nx; // la normale a x
	private float ny; // la normale a x
	private float nz; // la normale a x
	
	private String red; // le rouge du code RGB
	private String green; // le vert
	private String blue; // le bleu
	private String alpha; // la transparence
	private int face;  // Cette ligne signifie qu'il y a 1000 faces
	
	private int vertex_indice_elem;
	private List<Integer> vertex_indices; // liste des nombres de points qui vont se trouver dans chaque facette
	
	private List<Point> points;
	private List<Face> faces;
	
	public Ply(String type, String format, int vertex, int face, float x, float y, float z, 
			float nx, float ny, float nz,
			String red, String green, String blue, String alpha, int vertex_indice_elem,
			List<Integer> vertex_indices) {
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
	}

	


}
