package view.optionConfiguration.optionConfigurationControls;

import view.optionConfiguration.Element;

public class ConfigurationSpinnerFactory {
	
	private ConfigurationSpinnerFactory() {}
	
	public static ConfigurationSpinner getSpinner(Element element) {
		switch(element) {
		case RotateX:
			return new RotationXSpinner();
		case RotateY:
			return new RotationYSpinner();
		case RotateZ:
			return new RotationZSpinner();
		case Zoom:
			return new ZoomSpinner();
		case TranslationX:
			return new TranslationXSpinner();
		case TranslationY:
			return new TranslationYSpinner();
		default:
			return null;
		}
	}
}
