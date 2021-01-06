package modele.personnalScript;

import java.util.Arrays;
import java.util.List;

public class Script {
	private List<Commands> commands;
	
	public Script(Commands...commands) {
		this.commands = Arrays.asList(commands);
	}
}
