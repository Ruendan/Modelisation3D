package view.explorer;

import javafx.scene.control.Separator;
import javafx.scene.control.ToolBar;
import view.View;

public class ExplorerToolBar extends ToolBar{
	
	public ExplorerToolBar(ExplorerFilesList items, View parent) {
		FileExplorerButton feb = new FileExplorerButton(items);
		NewWindow ntb = new NewWindow(parent);
		OptionButton option = new OptionButton();
		this.getItems().addAll(feb, new Separator(), ntb, new Separator(), option);
	}
	
}
