package view.optionConfiguration;

import javafx.geometry.Insets;
import javafx.scene.layout.VBox;
import view.optionConfiguration.boxes.HBoxConfigurationFactory;

/**
 * Creation of configuration fields
 * <p>This class is used to create the configuration fields</p>
 * @author Groupe G1
 */
public class OptionConfigurationLayout extends VBox {
	
	/**
	 * Create a configuration field for each option
	 */
	public OptionConfigurationLayout(){
		super();
		this.setPadding(new Insets(10));
		this.setSpacing(10);
		
		this.getChildren().add(HBoxConfigurationFactory.getConfigurationBox(Element.ROTATEX));
		this.getChildren().add(HBoxConfigurationFactory.getConfigurationBox(Element.ROTATEY));
		this.getChildren().add(HBoxConfigurationFactory.getConfigurationBox(Element.ROTATEZ));
		this.getChildren().add(HBoxConfigurationFactory.getConfigurationBox(Element.TIMELINESPEED));
		this.getChildren().add(HBoxConfigurationFactory.getConfigurationBox(Element.TRANSLATIONX));
		this.getChildren().add(HBoxConfigurationFactory.getConfigurationBox(Element.TRANSLATIONY));
		this.getChildren().add(HBoxConfigurationFactory.getConfigurationBox(Element.ZOOM));
		
	}
}
