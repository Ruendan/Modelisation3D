package view.optionConfiguration.boxes;

import view.optionConfiguration.Element;

/**
 * Factory for all the configurations's label and fields
 * @author Groupe G1
 */
public final class HBoxConfigurationFactory {  // On aurait du rajouter Factory au PMD
	private HBoxConfigurationFactory() {}
	
	public static ConfigurationHBox getConfigurationBox(Element element) {
		switch(element) {
		case ROTATEX:
			return new HBoxRotationX();
		case ROTATEY:
			return new HBoxRotationY();
		case ROTATEZ:
			return new HBoxRotationZ();
		case ZOOM:
			return new ZoomBox();
		case TRANSLATIONX:
			return new HBoxTranslationX();
		case TRANSLATIONY:
			return new HBoxTranslationY();
		case TIMELINESPEED:
			return new HBoxActualisationTime();
		default:
			return null;
		}
	}
}
