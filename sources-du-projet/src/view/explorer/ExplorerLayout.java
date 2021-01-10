package view.explorer;

import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import view.View;

/**
 * Creation the layout of the explorer
 * <p>This class is used to create the zoom-in and zoom-out buttons linked to the {@link Figure}</p>
 * @author Groupe G1
 */
public class ExplorerLayout extends VBox{
	
	/**
	 * The Layout made to display the FileExplorer.
	 * It's a VBox regrouping the Explorer and the FileChoser.
	 * @param parent
	 * 			The {@link View} to add the explorer and toolbar to
	 */
	public ExplorerLayout(View parent) {
		super();
		
		final ExplorerFilesList listFiles = new ExplorerFilesList(parent);
		final ExplorerToolBar bar = new ExplorerToolBar(listFiles,parent);
		VBox.setVgrow(listFiles, Priority.ALWAYS);
		this.getChildren().addAll(bar, listFiles);
	}
}
