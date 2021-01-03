package view.optionConfiguration.boxes;

import view.optionConfiguration.Element;

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
		default:
			return null;
		}
	}
}
