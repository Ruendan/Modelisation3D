package view.explorer;

import javafx.scene.layout.VBox;

public class ExplorerLayout extends VBox{
	
	/**
	 * The Layout made to display the FileExplorer.
	 * It's a VBox regrouping the Explorer and the FileChoser.
	 * @param cgl
	 */
	public ExplorerLayout(CustomChangeListener cgl) {
		Explorer listFiles = new Explorer(cgl);
		FileExplorerButton feb = new FileExplorerButton();
		feb.setOnAction(e -> listFiles.addFile(feb.getFile()));
		this.getChildren().addAll(feb, listFiles);
	}
}
