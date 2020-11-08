package view;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import modele.modelisation.Figure;
import modele.parser.PlyParser;
import modele.parser.exception.PlyParserException;
import utils.Subject;

public class CustomChangeListener extends Subject implements ChangeListener<String> {

	Figure fig;
	
	public CustomChangeListener(Figure fig) {
		this.fig = fig;
	}

	@Override
	public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
		try {
			this.fig = new Figure(PlyParser.loadPly(newValue.split(" ")[0]));
		} catch (PlyParserException e) {
			e.printStackTrace();
		}
		notifyObservers(fig);
	}

}
