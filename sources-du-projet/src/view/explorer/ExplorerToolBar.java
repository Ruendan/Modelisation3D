package view.explorer;

import javafx.scene.control.ToolBar;

public class ExplorerToolBar extends ToolBar{
	
	public ExplorerToolBar(Explorer items) {
		FileExplorerButton feb = new FileExplorerButton(items);
		NewTabButton ntb = new NewTabButton();
		this.getItems().add(feb);
	}
	
}
