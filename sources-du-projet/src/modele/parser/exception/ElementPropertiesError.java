package modele.parser.exception;

public class ElementPropertiesError extends PlyParserException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static final String classic = "Les propriétés 'element' ne sont pas conformes.";
	
	public ElementPropertiesError() {
		this(classic);
	}
	
	public ElementPropertiesError(String message) {
		super(classic + "(" + message + ")");
	}
}
