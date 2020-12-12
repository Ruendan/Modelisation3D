package view.explorer;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import modele.modelisation.Figure;
import utils.Subject;

public class CustomChangeListener extends Subject implements ChangeListener<PlyFile> {

	Figure fig;
	
	public CustomChangeListener(Figure fig) {
		this.fig = fig;
	}

	@Override
	public void changed(ObservableValue<? extends PlyFile> observable, PlyFile oldValue, PlyFile newValue) {
		this.fig = new Figure(newValue.getPly());
		notifyObservers(fig);
	}

}
