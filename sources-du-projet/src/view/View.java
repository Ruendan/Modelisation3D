package view;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import modele.modelisation.Figure;
import modele.parser.PlyParser;
import modele.parser.exception.PlyParserException;
import utils.Observer;
import utils.Subject;
import view.buttons.Rotation;
import view.buttons.Translation;
import view.buttons.Zoom;

public class View extends Stage implements Observer{
	
	private Rotation buttons_rotation;
	private Translation buttons_translation;
	private Zoom buttons_zoom;
	private VBox right;
	private BorderPane bb;
	
	private CustomChangeListener gg;
	
	public View(Figure fig) {
		
		gg = new CustomChangeListener(fig);
		gg.attach(this);

		Explorer modelsList = new Explorer(gg);
		right = createRight(fig);
		right.prefWidthProperty().bind((this.widthProperty().multiply(0.3)));
		
		bb = new BorderPane();		
		bb.setLeft(modelsList);
		bb.setRight(right);		
		
		
		
		bb.setBackground(new Background(new BackgroundFill(Color.BLACK,CornerRadii.EMPTY, Insets.EMPTY)));
		
		Scene mainScene = new Scene(bb, 1000, 800);
		this.setScene(mainScene);
		this.setTitle("Visionneuse PLY 3D");
		this.show();
	}
	
	private VBox createRight(Figure fig) {
		VBox res = new VBox();
		
		this.buttons_rotation = new Rotation(fig);
		this.buttons_translation = new Translation(fig);
		this.buttons_zoom = new Zoom(fig);
		
		HBox buttons = new HBox();
		buttons.getChildren().addAll(buttons_rotation, new VBox(buttons_translation,buttons_zoom));
		//buttons.setStyle("-fx-border-width: 2px; -fx-border-color: blue;");
		
		Canvas display = new Canva(fig,700.0,500.0);
		
		//res.setStyle("-fx-border-width: 2px; -fx-border-color: blue;");
		res.getChildren().addAll(display, buttons);
		
		return res;
	} 
	

	@Override
	public void update(Subject subj){
		try {
			right = createRight(new Figure(PlyParser.loadPly("cube")));
			bb.setRight(right);
		} catch (PlyParserException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void update(Subject subj, Object data) {
		right = createRight((Figure) data);
		bb.setRight(right);
		
	}
}
