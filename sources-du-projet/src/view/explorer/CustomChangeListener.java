package view.explorer;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import modele.modelisation.Figure;
import modele.parser.PlyParser;
import modele.parser.exception.PlyParserException;
import utils.Subject;

public class CustomChangeListener extends Subject implements ChangeListener<PlyFile> {

	Figure fig;
	
	public CustomChangeListener(Figure fig) {
		this.fig = fig;
	}

	@Override
	public void changed(ObservableValue<? extends PlyFile> observable, PlyFile oldValue, PlyFile newValue) {
		try {
			this.fig = new Figure(PlyParser.loadPly(newValue.getPly().getName()));
		} catch (PlyParserException e) {
			e.printStackTrace();
		}
		notifyObservers(fig);
	}

}
