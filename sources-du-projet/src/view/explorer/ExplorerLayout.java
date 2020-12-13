package view.explorer;

import javafx.geometry.Insets;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class ExplorerLayout extends VBox{
	
	/**
	 * The Layout made to display the FileExplorer.
	 * It's a VBox regrouping the Explorer and the FileChoser.
	 * @param cgl
	 */
	public ExplorerLayout(CustomChangeListener cgl) {
		this.setPadding(new Insets(20));
		this.setSpacing(20);
		Explorer listFiles = new Explorer(cgl);
		ExplorerToolBar bar = new ExplorerToolBar(listFiles);
		VBox.setVgrow(listFiles, Priority.ALWAYS);
		this.getChildren().addAll(bar, listFiles);
	}
}
