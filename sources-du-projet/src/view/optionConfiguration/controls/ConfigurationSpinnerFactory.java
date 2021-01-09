package view.optionConfiguration.controls;

import view.optionConfiguration.Element;

/**
 * Factory for all the configurations's spinners
 * @author Groupe G1
 */
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
		case TimelineSpeed:
			return new ActualisationTimeSpinner();
		default: return null;
		}
	}
}
