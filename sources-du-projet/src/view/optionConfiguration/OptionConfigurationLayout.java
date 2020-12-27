package view.optionConfiguration;

import javafx.geometry.Insets;
import javafx.scene.layout.VBox;
import view.optionConfiguration.boxes.HBoxConfigurationFactory;

public class OptionConfigurationLayout extends VBox {
	
	public OptionConfigurationLayout(){
		this.setPadding(new Insets(10));
		this.setSpacing(10);
		
		this.getChildren().add(HBoxConfigurationFactory.getConfigurationBox(Element.RotateX));
		this.getChildren().add(HBoxConfigurationFactory.getConfigurationBox(Element.RotateY));
		this.getChildren().add(HBoxConfigurationFactory.getConfigurationBox(Element.RotateZ));
		this.getChildren().add(HBoxConfigurationFactory.getConfigurationBox(Element.TranslationX));
		this.getChildren().add(HBoxConfigurationFactory.getConfigurationBox(Element.TranslationY));
		this.getChildren().add(HBoxConfigurationFactory.getConfigurationBox(Element.Zoom));
		
	}
}