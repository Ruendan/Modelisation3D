package view;

import java.io.File;
import java.io.FileNotFoundException;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import modele.modelisation.Figure;
import modele.parser.PlyParser;
import modele.parser.exception.PlyParserException;
import view.buttons.ButtonsControls;
import view.buttons.ButtonsOthers;
import view.explorer.ExplorerFilesList;
import view.explorer.ExplorerLayout;

/**
 * Creation of the window of the application
 * <p>This class is used to create the {@link Stage} that will be shown to the user composed with the {@link ExplorerFilesList}, the {@link ButtonsControls}, the {@link CansFigure} and the {@link ButtinsOthers}</p>
 * @author Groupe G1
 */
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
	private static String fs = File.separator;
	public static final String ICONPATH = "ressources"+fs+"imgs"+fs+"appli_icon"+fs+"icon.png";
	
	private static final String DEFAULT_MODEL = "cube";

	private static final Color BACKGROUND_COLOR = Color.BLACK;
	private static final CornerRadii BACKGROUND_CORNER_RADII = CornerRadii.EMPTY;
	private static final Insets BACKGROUND_INSETS = Insets.EMPTY;

	private double x = 0;
	private double y = 0;
	
	/**
	 * Default constructor that will show the defined model
	 */
	public View() throws PlyParserException, FileNotFoundException {
		this(new Figure(PlyParser.getInstance().loadPly(DEFAULT_MODEL)));
	}
	/**
	 * Constructor that opens the stage with a given model
	 * @param fig
	 * 			The {@link Figure} to open the stage with
	 */
	public View(Figure fig) {
		super();
		display = new CanvasFigure(this);
		
		middle = createMiddle(fig);
		middle.prefWidthProperty().bind((this.widthProperty().multiply(WIDTH_MULTIPLY)));
		middle.setMinWidth(0);
		final ExplorerLayout modelsList = new ExplorerLayout(this);
		
		final ButtonsOthers right = new ButtonsOthers(display);
		
		
		layout = new BorderPane();		
		layout.setLeft(modelsList);
		layout.setCenter(middle);
		layout.setRight(right);
		layout.setBackground(new Background(new BackgroundFill(BACKGROUND_COLOR,BACKGROUND_CORNER_RADII, BACKGROUND_INSETS)));
		
		final Scene mainScene = new Scene(layout, SCENE_WIDTH, SCENE_HEIGHT);
		this.setScene(mainScene);
		this.widthProperty().addListener((obs, oldVal, newVal) -> {
			setDisplayWidth(newVal.doubleValue());
		});
		this.heightProperty().addListener((obs, oldVal, newVal) -> {
			setDisplayHeight(newVal.doubleValue());
		});
		this.setMinWidth(SCENE_MIN_WIDTH);
		this.setMinHeight(SCENE_MIN_HEIGHT);
		this.getIcons().add(new Image("file:"+View.ICONPATH));
		this.show();
	}
	
	private void setDisplayWidth(double doubleValue) {
		display.modifyWidth(doubleValue-248-234);
	}
	
	private void setDisplayHeight(double doubleValue) {
		display.modifyHeight(doubleValue);
	}
	/**
	 * Create the middle part of the stage with the {@link Figure} and the {@link ButtonsControls}
	 * @param fig
	 * 			The {@link Figure} to create the middle part with
	 */
	private StackPane createMiddle(Figure fig) {
		final StackPane res = new StackPane();
		
		display.setFigure(fig);
		display.setOnScroll(e -> fig.zoom(e.getDeltaY()>0?1.25:0.8));		
		
		final HBox buttons = new ButtonsControls(display);
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
				fig.hDeplace(e.getX()-x);
				fig.vDeplace(e.getY()-y);
			}
			if (e.getButton() == MouseButton.MIDDLE) {
				fig.rotateZ(e.getX()-x);
			}
			x=e.getX();
			y=e.getY();
		  });
		
		return res;
	}
	/**
	 * Update the middle part of the stage
	 * @param fig
	 * 			The new {@link Figure} to update the middle with
	 */
	public void updateMiddle(Figure f){
		middle = createMiddle(f);
		layout.setCenter(middle);
		
	}
	/**
	 * Update the title of the stage with {@link Figure}'s name
	 * @param fig
	 * 			The new {@link Figure}'s name to update the title with
	 */
	public void updateTitle(String name) {
		if(name==null||name.equals(""))this.setTitle(TITRE);
		this.setTitle(TITRE+" - "+name);
	}
	/**
	 * Get the {@link Figure} actually displayed 
	 * @param fig
	 * 			The {@link Figure} that is displayed on the stage
	 */
	public Figure getActualFigure() {
		return this.display.getFigure();
	}
}
