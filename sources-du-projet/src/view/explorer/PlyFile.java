package view.explorer;

import java.io.File;

import modele.modelisation.Ply;
import modele.parser.PlyParser;
import modele.parser.exception.PlyParserException;

public class PlyFile extends File{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Ply ply;
	private File file;
	boolean header;

	public PlyFile(File file) {
		super(file.getAbsolutePath());
		try {
			header = true;
			this.file=file;
			ply = PlyParser.loadHeader(file);
		} catch (PlyParserException e) {
			e.printStackTrace();
		}
	}
	
	
	
	public Ply getPly() {
		if(header) {
			try {
				ply = PlyParser.loadPly(file);
				header = false;
			} catch (PlyParserException e) {
				e.printStackTrace();
			}
		}
		return ply;
	}
	
	@Override
	public String toString() {
		return ply.getName() + " : " + ply.getNbFace() + " Faces";
	}
	

}
