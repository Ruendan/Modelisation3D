package modele.parser.exception;

public abstract class PlyParserException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static final String classic = "Une Erreur de Parser à été provoquée";

	public PlyParserException() {
		this(classic);
	}
	
	public PlyParserException(String message) {
		super(classic + "(" + message + ")");
	}
	
	
}
