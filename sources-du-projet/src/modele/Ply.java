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
	private double x; 
	private double y; 
	private double z; 
	
	/* Normale a : X, Y, Z*/
	private double nx; 
	private double ny; 
	private double nz; 
	
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
	
	public static void setUrl(String url) {
		Ply.url = url;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public void setVertex(int vertex) {
		this.vertex = vertex;
	}

	public void setFace(int face) {
		this.face = face;
	}

	public void setX(double x) {
		this.x = x;
	}

	public void setY(double y) {
		this.y = y;
	}

	public void setZ(double z) {
		this.z = z;
	}

	public void setNx(double nx) {
		this.nx = nx;
	}

	public void setNy(double ny) {
		this.ny = ny;
	}

	public void setNz(double nz) {
		this.nz = nz;
	}

	public void setRed(String red) {
		this.red = red;
	}

	public void setGreen(String green) {
		this.green = green;
	}

	public void setBlue(String blue) {
		this.blue = blue;
	}

	public void setAlpha(String alpha) {
		this.alpha = alpha;
	}

	public void setVertex_indice_elem(int vertex_indice_elem) {
		this.vertex_indice_elem = vertex_indice_elem;
	}

	public void setVertex_indices(List<Integer> vertex_indices) {
		this.vertex_indices = vertex_indices;
	}

	public void setPoints(List<Point> points) {
		this.points = points;
	}

	public void setFaces(List<Face> faces) {
		this.faces = faces;
	}

	public static void main(String[] args) {
		loadPly("cube");
	}

}
