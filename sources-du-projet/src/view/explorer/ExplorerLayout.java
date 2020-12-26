package view.explorer;

import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import view.View;

public class ExplorerLayout extends VBox{
	
	/**
	 * The Layout made to display the FileExplorer.
	 * It's a VBox regrouping the Explorer and the FileChoser.
	 * @param cgl
	 */
	public ExplorerLayout(View parent) {
		Explorer listFiles = new Explorer(parent);
		ExplorerToolBar bar = new ExplorerToolBar(listFiles);
		VBox.setVgrow(listFiles, Priority.ALWAYS);
		this.getChildren().addAll(bar, listFiles);
	}
}
