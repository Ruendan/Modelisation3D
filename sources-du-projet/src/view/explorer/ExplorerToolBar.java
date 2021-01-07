package view.explorer;

import javafx.scene.control.Separator;
import javafx.scene.control.ToolBar;
import view.View;

public class ExplorerToolBar extends ToolBar{
	
	public ExplorerToolBar(Explorer items, View parent) {
		FileExplorerButton feb = new FileExplorerButton(items);
		NewTabButton ntb = new NewTabButton(parent);
		OptionButton option = new OptionButton();
		ScriptButton sb = new ScriptButton();
		this.getItems().addAll(feb, new Separator(), ntb, new Separator(), option, new Separator(), sb);
	}
	
}
