package view.optionConfiguration.boxes;

import view.optionConfiguration.Element;

/**
 * Factory for all the configurations's label and fields
 * @author Groupe G1
 */
public class HBoxConfigurationFactory {
	private HBoxConfigurationFactory() {}
	
	public static ConfigurationHBox getConfigurationBox(Element element) {
		switch(element) {
		case RotateX:
			return new HBoxRotationX();
		case RotateY:
			return new HBoxRotationY();
		case RotateZ:
			return new HBoxRotationZ();
		case Zoom:
			return new ZoomBox();
		case TranslationX:
			return new HBoxTranslationX();
		case TranslationY:
			return new HBoxTranslationY();
		case TimelineSpeed:
			return new HBoxActualisationTime();
		default:
			return null;
		}
	}
}
