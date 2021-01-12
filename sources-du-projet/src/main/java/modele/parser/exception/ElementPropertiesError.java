package modele.parser.exception;

public class ElementPropertiesError extends PlyParserException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static final String CLASSIC = "Les propriétés 'element' ne sont pas conformes.";
	
	public ElementPropertiesError() {
		this(CLASSIC);
	}
	
	public ElementPropertiesError(String message) {
		super(CLASSIC + "(" + message + ")");
	}
}
