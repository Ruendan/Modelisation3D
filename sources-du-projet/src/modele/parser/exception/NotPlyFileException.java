package modele.parser.exception;

public class NotPlyFileException extends PlyParserException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static final String classic = "Le fichier lu ne correspond pas à un fichier de polygones (.ply)";
	
	public NotPlyFileException() {
		this(classic);
	}
	
	public NotPlyFileException(String message) {
		super(classic + "(" + message + ")");
	}
}
