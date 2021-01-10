package view.explorer;

import javafx.scene.control.Separator;
import javafx.scene.control.ToolBar;
import view.View;

/**
 * Creation the toolbar of the explorer
 * <p>This class is used to create the toolbar that allows the user to add a new file of his own, create a new window, configure the application</p>
 * @author Groupe G1
 */
public class ExplorerToolBar extends ToolBar{
	
	/**
	 * The Toolbar that contains the {@link FileExplorerButton}, the {@link NewTabButton} and the {@link OptionButton}.
	 * @param items
	 * 			The {@link Explorer} to add files to
	 * @param parent
	 * 			The {@link View} that contains the {@link Figure} to show in the new window
	 */
	public ExplorerToolBar(Explorer items, View parent) {
		super();
		final FileExplorerButton feb = new FileExplorerButton(items);
		final NewTabButton ntb = new NewTabButton(parent);
		final OptionButton option = new OptionButton();
		this.getItems().addAll(feb, new Separator(), ntb, new Separator(), option);
	}
	
}
