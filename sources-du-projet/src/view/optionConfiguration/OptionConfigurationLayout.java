package view.optionConfiguration;

import javafx.geometry.Insets;
import javafx.scene.layout.VBox;
import view.optionConfiguration.boxes.HBoxConfigurationFactory;

public class OptionConfigurationLayout extends VBox {
	
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
