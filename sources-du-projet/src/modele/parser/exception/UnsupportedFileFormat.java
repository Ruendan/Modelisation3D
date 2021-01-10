package modele.parser.exception;

public class UnsupportedFileFormat extends PlyParserException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static final String CLASSIC = "Le format de ce fichier n'est pas supporté.";
	
	public UnsupportedFileFormat() {
		this(CLASSIC);
	}
	
	public UnsupportedFileFormat(String message) {
		super(CLASSIC + "(" + message + ")");
	}
}
