package view;

import java.util.ArrayList;
import java.util.List;

import modele.personnalScript.Script;

public class ExistingScriptsConst {
	
	private ExistingScriptsConst() {}
	
	private static List<Script> existingScripts = new ArrayList<>();
	
	public static List<Script> getExistingScripts(){
		return existingScripts;
	}
	
	public static boolean addScript(Script s) {
		return existingScripts.add(s);
	}
}
