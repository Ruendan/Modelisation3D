package view.explorer;

import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import modele.modelisation.Figure;
import modele.parser.PlyParser;
import modele.parser.exception.PlyParserException;
import utils.Icon;
import view.View;
import view.errors.ErrorScene;

public class NewTabButton extends Button{
	
	public NewTabButton(View parent) {
		super("",Icon.createButtonIcon("newWindow"));
		Tooltip.install(this, new Tooltip("Creer une nouvelle fenetre"));
		this.setOnAction(e -> {
			try {
				System.out.println(parent.getActualFigure());
				openNewWindow(parent.getActualFigure());
			} catch (PlyParserException e1) {
				ErrorScene.display(e1);
			}
		});
	}
	
	private void openNewWindow(Figure parent) throws PlyParserException {
		String figName = parent.getName();
		Figure newFigure = new Figure(PlyParser.loadPly(figName.substring(0, figName.length()-4)));
		new View(newFigure);
	}
}
