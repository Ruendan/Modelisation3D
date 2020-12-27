package view.explorer;

import javafx.scene.control.Separator;
import javafx.scene.control.ToolBar;

public class ExplorerToolBar extends ToolBar{
	
	public ExplorerToolBar(Explorer items, String parent) {
		FileExplorerButton feb = new FileExplorerButton(items);
		NewTabButton ntb = new NewTabButton(parent);
		OptionButton option = new OptionButton();
		this.getItems().addAll(feb, new Separator(), ntb, new Separator(), option);
	}
	
}
