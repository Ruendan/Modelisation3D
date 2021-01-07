package view.scriptConfiguration.scriptCreation;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.layout.VBox;
import modele.personnalScript.Commands;
import modele.personnalScript.Move;
import modele.personnalScript.Script;
import view.ExistingScriptsConst;

public class CreateNewScriptLayout extends VBox{
	
	private Script res;
	private Commands command;
	
	private ComboBox<Move> cbxMoves;
	private Spinner<Double> timeSpinner;
	private Spinner<Double> speedSpinner;
	private Spinner<Double> strengthSpinner;
	
	private Label scriptActuel;
	
	public CreateNewScriptLayout() {
		res = new Script();
		
		scriptActuel = new Label(res.toString());
		this.getChildren().add(scriptActuel);
		
		cbxMoves = new ComboBox<>();
		cbxMoves.getItems().setAll(Move.values());
		this.getChildren().addAll(new Label("Movement to make : "), cbxMoves);
		
		timeSpinner = new Spinner<Double>(0,Double.MAX_VALUE, 5, 0.01);
		this.getChildren().addAll(new Label("Temps : "), timeSpinner);

		speedSpinner = new Spinner<Double>(0,Double.MAX_VALUE, 5, 0.01);
		this.getChildren().addAll(new Label("Vitesse : "), speedSpinner);
		
		strengthSpinner = new Spinner<Double>(0,Double.MAX_VALUE, 5, 0.01);
		this.getChildren().addAll(new Label("Force : "), strengthSpinner);
		
		Button ajouterCommand = new Button();
		ajouterCommand.setText("Ajouter Commande");
		ajouterCommand.setOnAction(e -> addCommand());
		this.getChildren().add(ajouterCommand);
		
		Button validate = new Button();
		validate.setText("Valider le Script");
		validate.setOnAction(e->validate());
		this.getChildren().add(validate);
	}
	
	public void validate() {
		ExistingScriptsConst.addScript(res);
	}
	
	public void addCommand() {
		if(isCommandGood())res.addCommand(command);
		actualiserLabel();
	}
	
	private void actualiserLabel() {
		this.scriptActuel.setText(res.toString());
	}

	public boolean isCommandGood() {
		if(cbxMoves.getValue() == null) return false;
		if(strengthSpinner.getValue() == null) return false;
		if(speedSpinner.getValue()==null) return false; 
		if(timeSpinner.getValue()==null) return false;
		
		command = new Commands(cbxMoves.getValue(), strengthSpinner.getValue(), speedSpinner.getValue(), timeSpinner.getValue());
		return true;
	}
}
