package view.scriptConfiguration;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import modele.personnalScript.Script;
import view.ExistingScriptsConst;
import view.scriptConfiguration.scriptCreation.CreateNewScriptStage;

public class ScriptConfigurationLayout extends VBox {
	
	private ListView<Script> existingScripts;
	
	public ScriptConfigurationLayout(){
		this.setPadding(new Insets(10));
		this.setSpacing(10);
		this.getChildren().add(new Label("Existing Scripts"));
		
		existingScripts = new ListView<>();
		updateScripts();
		this.getChildren().add(existingScripts);
		
		Button createScriptButton = new Button();
		createScriptButton.setText("Creer un Nouveau Script");
		createScriptButton.setOnAction(e -> afficheNewScriptStage());
		
		this.getChildren().add(new CreateScriptButton());
		
//		this.getChildren().add(HBoxConfigurationFactory.getConfigurationBox(Element.RotateX));
//		this.getChildren().add(HBoxConfigurationFactory.getConfigurationBox(Element.RotateY));
//		this.getChildren().add(HBoxConfigurationFactory.getConfigurationBox(Element.RotateZ));
//		this.getChildren().add(HBoxConfigurationFactory.getConfigurationBox(Element.TimelineSpeed));
//		this.getChildren().add(HBoxConfigurationFactory.getConfigurationBox(Element.TranslationX));
//		this.getChildren().add(HBoxConfigurationFactory.getConfigurationBox(Element.TranslationY));
//		this.getChildren().add(HBoxConfigurationFactory.getConfigurationBox(Element.Zoom));
		
	}
	
	public void afficheNewScriptStage() {
		CreateNewScriptStage s = new CreateNewScriptStage();
		s.setOnCloseRequest(e -> updateScripts());
		s.showAndWait();
	}
	
	public void updateScripts() {
		existingScripts.getItems().clear();
		for(Script s : ExistingScriptsConst.getExistingScripts()) {
			existingScripts.getItems().add(s);
		}
	}
}
