package view.explorer;

import javafx.scene.layout.VBox;

public class ExplorerLayout extends VBox{
	
	public ExplorerLayout(CustomChangeListener cgl) {
		Explorer listFiles = new Explorer(cgl);
		FileExplorerButton feb = new FileExplorerButton();
		feb.setOnAction(e -> listFiles.addFile(feb.getFile()));
		this.getChildren().addAll(feb, listFiles);
	}
}
