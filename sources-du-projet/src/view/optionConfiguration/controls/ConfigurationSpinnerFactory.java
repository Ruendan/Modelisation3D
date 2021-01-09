package view.optionConfiguration.controls;

import view.optionConfiguration.Element;

public final class ConfigurationSpinnerFactory { // On aurait du rajout Factory a la liste en temps que mot de fin
	
	private ConfigurationSpinnerFactory() {}
	
	public static ConfigurationSpinner getSpinner(Element element) {
		switch(element) {
		case ROTATEX:
			return new RotationXSpinner();
		case ROTATEY:
			return new RotationYSpinner();
		case ROTATEZ:
			return new RotationZSpinner();
		case ZOOM:
			return new ZoomSpinner();
		case TRANSLATIONX:
			return new TranslationXSpinner();
		case TRANSLATIONY:
			return new TranslationYSpinner();
		case TIMELINESPEED:
			return new ActualisationTimeSpinner();
		default: return null;
		}
	}
}
