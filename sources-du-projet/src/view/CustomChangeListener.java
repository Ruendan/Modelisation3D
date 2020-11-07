package view;

import javafx.beans.value.ChangeListener;
import modele.modelisation.Figure;
import utils.Subject;

public abstract class CustomChangeListener extends Subject implements ChangeListener<String> {

	Figure fig;
	
	public CustomChangeListener(Figure fig) {
		this.fig = fig;
	}
	
	public void setFig(Figure fig) {
		this.fig = fig;
		notifyObservers();
	}

}
