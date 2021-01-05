package view.explorer;

import java.io.File;

import modele.modelisation.Ply;
import modele.parser.PlyParser;
import modele.parser.exception.PlyParserException;

/**
 * 
 * @author Quentin Dubois
 * That's a File used to store a PlyFile and its File.
 * It's a specific kind of file which is assigned to PlyFile.
 *
 */
public class PlyFile extends File{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Ply ply;
	private File file;
	boolean header;

	/**
	 * 
	 * @param file - The File toward the PlyFile
	 * Put the "HeaderPly" in the ply.
	 * 
	 */
	public PlyFile(File file) throws PlyParserException {
		super(file.getAbsolutePath());
		header = true;
		this.file=file;
		ply = PlyParser.loadHeader(file);
	}
	
	/**
	 * Verify if the Ply file is the header of a complete Ply File.
	 * If it's still a Header, it turns the PlyFile into a 
	 * Complete PlyFile
	 */
	private void update() throws PlyParserException {
		if(header) {
			ply = PlyParser.loadPly(file);
			header = false;
		}
	}
	
	/**
	 * 
	 * @return The Ply which targets the file.
	 * @throws PlyParserException 
	 */
	public Ply getPly() throws PlyParserException {
		update();
		return ply;
	}
	
	public void unload() throws PlyParserException{
		this.ply = PlyParser.loadHeader(file);
		header = true;
	}

	@Override
	public String toString() {
		return ply.getName() + " : " + ply.getNbFace() + " Faces";
	}

}
