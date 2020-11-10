package view;

import javafx.geometry.Insets;
import javafx.scene.Scene;
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
import view.buttons.Buttons;

public class View extends Stage implements Observer{
	

	private VBox right;
	private BorderPane layout;
	
	private CustomChangeListener ccl;
	
	private Canva display;

	private static final double SCENE_WIDTH = 1000;
	private static final double SCENE_HEIGHT = 800;
	
	private static final double SCENE_MIN_WIDTH = 500;
	private static final double SCENE_MIN_HEIGHT = 400;
	
	private static final double WIDTH_MULTIPLY = 0.3;
	
	private static final String TITRE = "Visionneuse PLY 3D";
	
	private static final String DEFAULT_MODEL = "cube";

	private static final Color BACKGROUND_COLOR = Color.BLACK;
	private static final CornerRadii BACKGROUND_CORNER_RADII = CornerRadii.EMPTY;
	private static final Insets BACKGROUND_INSETS = Insets.EMPTY;
	
	public View(Figure fig) {
		
		ccl = new CustomChangeListener(fig);
		ccl.attach(this);

		Explorer modelsList = new Explorer(ccl);
		
		display = new Canva();
		
		right = createRight(fig);
		right.prefWidthProperty().bind((this.widthProperty().multiply(WIDTH_MULTIPLY)));
		
		
		layout = new BorderPane();		
		layout.setLeft(modelsList);
		layout.setRight(right);
		layout.setBackground(new Background(new BackgroundFill(BACKGROUND_COLOR,BACKGROUND_CORNER_RADII, BACKGROUND_INSETS)));
		
		Scene mainScene = new Scene(layout, SCENE_WIDTH, SCENE_HEIGHT);
		this.setScene(mainScene);
		
		this.setMinWidth(SCENE_MIN_WIDTH);
		this.setMinHeight(SCENE_MIN_HEIGHT);
		this.setTitle(TITRE);
		this.show();
	}
	
	private VBox createRight(Figure fig) {
		VBox res = new VBox();
		
		display.setFigure(fig);
		HBox buttons = new Buttons(display);
		
		//res.setStyle("-fx-border-width: 2px; -fx-border-color: blue;");
		res.getChildren().addAll(display, buttons);
		
		return res;
	} 
	
	
	

	@Override
	public void update(Subject subj){
		try {
			right = createRight(new Figure(PlyParser.loadPly(DEFAULT_MODEL)));
			layout.setRight(right);
		} catch (PlyParserException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void update(Subject subj, Object data) {
		right = createRight((Figure) data);
		layout.setRight(right);
		
	}
}
