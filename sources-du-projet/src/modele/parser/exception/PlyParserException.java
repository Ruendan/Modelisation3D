package modele.parser.exception;

public abstract class PlyParserException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static final String CLASSIC = "Une Erreur de Parser à été provoquée";

	public PlyParserException() {
		this(CLASSIC);
	}
	
	public PlyParserException(String message) {
		super(CLASSIC + "(" + message + ")");
	}
	
	
}
