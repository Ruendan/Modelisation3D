package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import modele.modelisation.Figure;
import modele.parser.PlyParser;
import modele.parser.exception.PlyParserException;
import view.buttons.ButtonsControls;
import view.buttons.ButtonsOthers;
import view.explorer.ExplorerLayout;

public class View extends Stage{
	
	private StackPane middle;
	private BorderPane layout;
	
	private CanvasFigure display;

	private static final double SCENE_WIDTH = 1420;
	private static final double SCENE_HEIGHT = 800;
	
	private static final double SCENE_MIN_WIDTH = 700;
	private static final double SCENE_MIN_HEIGHT = 400;
	
	private static final double WIDTH_MULTIPLY = 0.3;
	
	private static final String TITRE = "Visionneuse PLY 3D";
	
	private static final String DEFAULT_MODEL = "cube";

	private static final Color BACKGROUND_COLOR = Color.BLACK;
	private static final CornerRadii BACKGROUND_CORNER_RADII = CornerRadii.EMPTY;
	private static final Insets BACKGROUND_INSETS = Insets.EMPTY;
	
	public View() throws PlyParserException {
		this(new Figure(PlyParser.loadPly(DEFAULT_MODEL)));
	}
	
	public View(Figure fig) {

		//Explorer modelsList = new Explorer(ccl); //Fonctionnel mais Obsolete 
		ExplorerLayout modelsList = new ExplorerLayout(this);
		
		display = new CanvasFigure();
		
		middle = createMiddle(fig);
		middle.prefWidthProperty().bind((this.widthProperty().multiply(WIDTH_MULTIPLY)));
		
		ButtonsOthers right = new ButtonsOthers(display);
		
		
		layout = new BorderPane();		
		layout.setLeft(modelsList);
		layout.setCenter(middle);
		layout.setRight(right);
		layout.setBackground(new Background(new BackgroundFill(BACKGROUND_COLOR,BACKGROUND_CORNER_RADII, BACKGROUND_INSETS)));
		
		Scene mainScene = new Scene(layout, SCENE_WIDTH, SCENE_HEIGHT);
		this.setScene(mainScene);
		
		this.setMinWidth(SCENE_MIN_WIDTH);
		this.setMinHeight(SCENE_MIN_HEIGHT);
		this.setTitle(TITRE);
		this.show();
	}
	
	private StackPane createMiddle(Figure fig) {
		StackPane res = new StackPane();
		
		display.setFigure(fig);
		display.setOnScroll(e -> fig.zoom(e.getDeltaY()>0?1.25:0.8));
		//display.widthProperty().bind(res.widthProperty());
		
		
		HBox buttons = new ButtonsControls(display);

		res.getChildren().addAll(display,buttons);
		StackPane.setAlignment(buttons, Pos.TOP_LEFT);
		
		display.setOnMousePressed(e -> {
			x=e.getX();
			y=e.getY();
		  });
		display.setOnMouseDragged(e -> {
			
			if (e.getButton() == MouseButton.PRIMARY) {
				fig.rotateY(x-e.getX());
				fig.rotateX(y-e.getY());
			}
			if (e.getButton() == MouseButton.SECONDARY) {
				fig.HDeplace(e.getX()-x);
				fig.VDeplace(e.getY()-y);
			}
			if (e.getButton() == MouseButton.MIDDLE) {
				fig.rotateZ(e.getX()-x);
			}
			x=e.getX();
			y=e.getY();
		  });
		
		return res;
	} 
	double x = 0;
	double y = 0;
	
	public void updateMiddle(Figure f){
		middle = createMiddle(f);
		layout.setCenter(middle);
		
	}
}
