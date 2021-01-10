package view.explorer;

import java.io.FileNotFoundException;

import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import modele.modelisation.Figure;
import modele.parser.PlyParser;
import modele.parser.exception.PlyParserException;
import utils.IconConstants;
import view.View;
import view.errors.ErrorSceneConstants;

/**
 * Creation of the new window button
 * <p>This class is used to create a new window with the actual {@link Figure} in it</p>
 * @author Groupe G1
 */
public class NewTabButton extends Button{
	
	/**
	 * Create the new window button with its tooltip
	 * @param parent
	 * 			The {@link View} containing the figure
	 */
	public NewTabButton(View parent) {
		super("",IconConstants.createButtonIcon("newWindow"));
		Tooltip.install(this, new Tooltip("Creer une nouvelle fenetre"));
		this.setOnAction(e -> {
			try {
				System.out.println(parent.getActualFigure());
				openNewWindow(parent.getActualFigure());
			} catch (PlyParserException | FileNotFoundException e1) {
				ErrorSceneConstants.display(e1);
			}
		});
	}
	
	/**
	 * Show the new window button and load a copy of the previous model
	 * @param parent
	 * 			The previous {@link Figure}
	 */
	private void openNewWindow(Figure parent) throws PlyParserException, FileNotFoundException {
		final String figName = parent.getName();
		
		final PlyParser parser = PlyParser.getInstance();
		
		final Figure newFigure = new Figure(parser.loadPly(figName.substring(0, figName.length()-4))); // Oui
		new View(newFigure);
	}
}
