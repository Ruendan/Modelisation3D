package modele;

import java.util.List;

public class Ply {
	
	private int vertex;
	
	private int nbFace;
	
	private List<String> comment;
	private List<Point> points;
	private List<Face> faces;
	
	public int getVertex() {
		return vertex;
	}

	public void setVertex(int vertex) {
		this.vertex = vertex;
	}
	
	public int getNbFace() {
		return nbFace;
	}
	
	public void setNbFace(int nbFace) {
		this.nbFace = nbFace;
	}
	
	public List<Point> getPoints() {
		return points;
	}

	public void setPoints(List<Point> points) {
		this.points = points;
	}
	
	public List<Face> getFaces() {
		return faces;
	}
	
	public void setFaces(List<Face> faces) {
		this.faces = faces;
	}

	public List<String> getComment() {
		return comment;
	}

	public void setComment(List<String> comment) {
		this.comment = comment;
	}

	public Ply(int vertex, int nbFace, List<Point> points, List<Face> faces) {
		this.vertex = vertex;
		this.nbFace = nbFace;
		this.points = points;
		this.faces = faces;
	}

	public Ply() {}

	@Override
	public String toString() {
		return "Ply [vertex=" + vertex + ", face=" + nbFace + ", points=" + points + ", faces=" + faces + "]";
	}
	
}
