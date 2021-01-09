package view.explorer;

import javafx.scene.control.Separator;
import javafx.scene.control.ToolBar;
import view.View;

public class ExplorerToolBar extends ToolBar{
	
	public ExplorerToolBar(Explorer items, View parent) {
		super();
		final FileExplorerButton feb = new FileExplorerButton(items);
		final NewTabButton ntb = new NewTabButton(parent);
		final OptionButton option = new OptionButton();
		this.getItems().addAll(feb, new Separator(), ntb, new Separator(), option);
	}
	
}
