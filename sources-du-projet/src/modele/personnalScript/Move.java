package modele.personnalScript;

import modele.modelisation.Figure;

public enum Move {
	TranslateX, TranslateY, Zoom, RotateX, RotateY, RotateZ;

	public void moveFigure(Figure fig, double value) {
		switch(this) {
		case RotateX:
			fig.rotateX(value);
			break;
		case RotateY:
			fig.rotateY(value);
			break;
		case RotateZ:
			fig.rotateZ(value);
			break;
		case TranslateX:
			fig.deplace(value, 0, 0);
			break;
		case TranslateY:
			fig.deplace(0, value, 0);
			break;
		case Zoom:
			fig.zoom(value);
			break;
		default:
			break;
		}
	}
}
