package view.explorer;

import java.io.FileNotFoundException;

import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.Tooltip;
import modele.modelisation.Figure;
import modele.parser.PlyParser;
import modele.parser.exception.PlyParserException;
import utils.ErrorSceneUtils;
import utils.IconConstants;
import view.View;

/**
 * Creation of the new window button
 * <p>This class is used to create a new window with the actual {@link Figure} in it</p>
 * @author Groupe G1
 */
public class NewWindow extends SplitMenuButton{
	
	/**
	 * Create the new window button with its tooltip
	 * @param parent
	 * 			The {@link View} containing the figure
	 */
	public NewWindow(View parent) {
		super();
		getItems().add(getMenuItem(parent));
		this.setGraphic(IconConstants.createButtonIcon("newWindow"));
		Tooltip.install(this, new Tooltip("Creer une nouvelle fenetre"));
		this.setOnAction(e -> {
			try {
				openNewWindow(parent.getActualFigure());
			} catch (PlyParserException | FileNotFoundException e1) {
				ErrorSceneUtils.display(e1);
			}
		});
	}
	
	private MenuItem getMenuItem(View parent) {
		MenuItem boutonCopie = new MenuItem("Copie de la vue");
		boutonCopie.setOnAction(e -> {
			new View(parent.getActualFigure());
		});
		return boutonCopie;
	}

	/**
	 * Show the new window button and load a copy of the previous model
	 * @param parent
	 * 			The previous {@link Figure}
	 */
	private void openNewWindow(Figure parent) throws PlyParserException, FileNotFoundException {
		final String figName = parent.getName();
		final PlyParser parser = PlyParser.getInstance();
		
		final Figure newFigure = new Figure(parser.loadPly(figName.substring(0, figName.length())));
		new View(newFigure);
	}
}
