package view.explorer;

import java.io.File;

import modele.modelisation.Ply;

public class PlyFile extends File{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Ply ply;

	public PlyFile(File f, Ply ply) {
		super(f.getAbsolutePath());
		this.ply = ply;
	}
	
	public Ply getPly() {
		return ply;
	}
	
	@Override
	public String toString() {
		return ply.getName() + " : " + ply.getNbFace() + " Faces";
	}
	

}
