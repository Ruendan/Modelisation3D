package modele.parser.exception;

public class PropertyPropertiesError extends PlyParserException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static final String classic = "Les propriétés 'propriété' ne sont pas conformes.";
	
	public PropertyPropertiesError() {
		this(classic);
	}
	
	public PropertyPropertiesError(String message) {
		super(classic + "(" + message + ")");
	}
}
