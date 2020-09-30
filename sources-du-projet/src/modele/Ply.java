package modele;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class Ply {
	
	private static String url = "ressources/plys/";
	
	private String type; //ply
	private String format; //ASCII 
	
	//NbPoints (sommets)
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
	
	
	
	public static Ply loadPly(String nom) {
		Ply res = new Ply();
		
		try(Scanner sc = new Scanner(new File(url + nom + ".ply"))){
			while(sc.hasNextLine()) {
				System.out.println(sc.nextLine());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static void main(String[] args) {
		loadPly("cube");
	}

}
