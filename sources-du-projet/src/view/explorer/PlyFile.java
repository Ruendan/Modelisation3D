package view.explorer;

import java.io.File;
import java.io.FileNotFoundException;

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
	private final File file;
	private boolean header;
	private final PlyParser parser;

	/**
	 * 
	 * @param file - The File toward the PlyFile
	 * Put the "HeaderPly" in the ply.
	 * @throws FileNotFoundException 
	 * 
	 */
	public PlyFile(File file) throws PlyParserException, FileNotFoundException {
		super(file.getAbsolutePath());
		header = true;
		this.file=file;
		parser = PlyParser.getInstance();
		ply = parser.loadHeader(file);
	}
	
	/**
	 * Verify if the Ply file is the header of a complete Ply File.
	 * If it's still a Header, it turns the PlyFile into a 
	 * Complete PlyFile
	 * @throws FileNotFoundException 
	 */
	private void update() throws PlyParserException, FileNotFoundException {
		if(header) {
			ply = parser.loadPly(file);
			header = false;
		}
	}
	
	/**
	 * 
	 * @return The Ply which targets the file.
	 * @throws PlyParserException 
	 * @throws FileNotFoundException 
	 */
	public Ply getPly() throws PlyParserException, FileNotFoundException {
		update();
		return ply;
	}
	
	public void unload() throws PlyParserException, FileNotFoundException{
		this.ply = parser.loadHeader(file);
		header = true;
	}

	@Override
	public String toString() {
		return ply.getName() + " : " + ply.getNbFace() + " Faces";
	}

}
