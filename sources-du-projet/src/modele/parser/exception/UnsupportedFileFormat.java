package modele.parser.exception;

public class UnsupportedFileFormat extends PlyParserException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static final String classic = "Le format de ce fichier n'est pas support�.";
	
	public UnsupportedFileFormat() {
		this(classic);
	}
	
	public UnsupportedFileFormat(String message) {
		super(classic + "(" + message + ")");
	}
}
