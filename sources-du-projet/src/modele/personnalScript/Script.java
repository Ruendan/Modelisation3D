package modele.personnalScript;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import modele.modelisation.Figure;

public class Script {
	private List<Commands> commands;
	
	public Script(Commands...commands) {
		this.commands = Arrays.asList(commands);
	}
	
	public Script() {
		commands = new ArrayList<>();
	}
	
	public boolean addCommand(Commands command) {
		return commands.add(command);
	}
	
	public void executeScript(Figure fig) {
		for(Commands c : commands) {
			c.executeCommand(fig);
		}
	}
	
	public int getNbCommands() {
		return commands.size();
	}
	
	public String toString() {
		StringBuilder res = new StringBuilder();
		res.append(this.getNbCommands());
		for(Commands c : commands){
			res.append(c.toString());
			res.append(':');
		}
		return res.toString();
	}
}
