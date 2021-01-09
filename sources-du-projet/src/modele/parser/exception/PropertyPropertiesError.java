package modele.parser.exception;

public class PropertyPropertiesError extends PlyParserException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static final String CLASSIC = "Les propriétés 'propriété' ne sont pas conformes.";
	
	public PropertyPropertiesError() {
		this(CLASSIC);
	}
	
	public PropertyPropertiesError(String message) {
		super(CLASSIC + "(" + message + ")");
	}
}
