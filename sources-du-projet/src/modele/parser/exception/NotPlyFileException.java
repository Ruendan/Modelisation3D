package modele.parser.exception;

public class NotPlyFileException extends PlyParserException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static final String CLASSIC = "Le fichier lu ne correspond pas à un fichier de polygones (.ply)";
	
	public NotPlyFileException() {
		this(CLASSIC);
	}
	
	public NotPlyFileException(String message) {
		super(CLASSIC + "(" + message + ")");
	}
}
