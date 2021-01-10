package modele.parser;

public class VertexElement extends PlyElement {

	int xpos = -1;
	int ypos = -1;
	int zpos = -1;
	
	int pred = -1;
	int pgreen = -1;
	int pblue = -1;
	
	public VertexElement(int i) {
		super();
		this.nbElement = i;
		this.indicatif = "vertex";
	}

	private int getNbVertex(String vert) {
		if(vert.matches("[0-9]+")) {
			return Integer.parseInt(vert);
		}
		return -1;
	}
	
}
