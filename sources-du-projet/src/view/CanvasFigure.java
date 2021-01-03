package view;


import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import modele.modelisation.Face;
import modele.modelisation.Figure;
import modele.modelisation.Matrix;
import modele.modelisation.Point;
import utils.Observer;
import utils.Subject;
/**
 * Figure Display
 * <p>This class is used to manage the display of the {@link Figure}</p>
 * @author Groupe G1
 *	Implements {@link Observer}
 *	exctends {@link Canvas}
 */
public class CanvasFigure extends Canvas implements Observer {

	private Figure fig;
	private Timeline timeline;
	
	private boolean rotating;

	private double opacity = 1;
	private Color canvaFillColor = Color.rgb(145, 196, 240, opacity);
	private Color figureFillColor = Color.rgb(135, 206, 250, opacity);
	
	
	private Color figureStrokeColor = Color.BLACK;
	private double figureLineWidth = 0.2;

	private GraphicsContext gc;

	private static final double DEFAULT_WIDTH = 800;
	private static final double DEFAULT_HEIGHT = 800;

	private double[][] coord;

	/**
	 * Create the {@link Canvas} of the {@link Figure} with the width and the height of the {@link Canvas}.
	 * @param width
	 * 			The width of your {@link Canvas}
	 * @param height
	 * 			The height of your {@link Canvas}
	 */
	public CanvasFigure(double width, double height) {
		this.gc = this.getGraphicsContext2D();
		this.setWidth(width);
		this.setHeight(height);

		coord = new double[2][1];
		rotating = false;
		timeline = new Timeline(new KeyFrame(Duration.seconds(TimelineConst.TEMPSDACTUALISATION), e -> {
			fig.rotate(TimelineConst.XROTATIONVALUE, TimelineConst.YROTATIONVALUE ,TimelineConst.ZROTATIONVALUE);
			visualUpdate();
		}));
		timeline.setCycleCount(Animation.INDEFINITE);
		timeline.setAutoReverse(true);
	}
	
	/**
	 * Create the {@link Canvas} of the {@link Figure} with the default width and height
	 * <p> DEFAULT_WIDTH = 800 <br> DEFAULT_HEIGHT = 500 </p>
	 */
	public CanvasFigure() {
		this(DEFAULT_WIDTH, DEFAULT_HEIGHT);
	}
	
	/**
	 * Set the background {@link Color} of your {@link Canvas}
	 * @param rgba
	 * 			The new {@link Color} of the background
	 */
	public void setCanvaFillColor(Color rgba) {
		this.canvaFillColor = rgba;
		visualUpdateLite();
	}
	
	/**
	 * Get the background {@link Color} of the {@link Canvas}
	 * @return {@link Color}
			visualUpdate();
	 * 			 the {@link Color} of the background
	 */
	public Color getCanvaFillColor() {
		return canvaFillColor;
	}

	/**
	 * Set the {@link Figure}'s {@link Color}
	 * @param rgba
	 * 			The new {@link Color} of the {@link Figure}
	 */
	public void setFigureFillColor(Color rgba) {
		this.figureFillColor = Color.color(rgba.getRed(), rgba.getGreen(), rgba.getBlue(), this.opacity);
		visualUpdateLite();
	}

	/**
	 * Get the {@link Figure}'s {@link Color}
	 * @return {@link Figure}
	 * 			the {@link Color} of the {@link Figure}
	 */
	public Color getFigureFillColor() {
		return figureFillColor;
	}

	/**
	 * Get the {@link Figure} draw on the {@link Canvas}
	 * @return {@link Figure}
	 * 			the {@link Figure}
	 */
	public Figure getFigure() {
		return this.fig;
	}
	/**
	 * Set the {@link Canvas}'s {@link Figure}
	 * @param fig
	 * 			the {@link Figure} you want to draw
	 */
	public void setFigure(Figure fig) {
		if (this.fig != null)
			this.fig.detach(this);

		this.fig = fig;
		this.fig.attach(this);
		this.centerFigure();
		this.printFigure();
		this.stopRotation();
	}

	/**
	 * Get the edge's width
	 * @return {@link Double}
	 * 			the edge's width of the {@link Figure}
	 */
	public double getFigureLineWidth() {
		return this.figureLineWidth;
	}
	
	/**
	 * Set the edge's width
	 * @param value
	 * 			the value of the new edge's width of the {@link Figure}
	 */
	public void setFigureLineWidth(double value) {
		this.figureLineWidth = value;
		visualUpdateLite();
	}

	private void printFace(Face f) {
		this.gc.setFill(figureFillColor);
		this.gc.setStroke(figureStrokeColor);
		this.gc.setLineWidth(figureLineWidth);
		this.gc.fillPolygon(coord[0], coord[1], f.getNbPoints());
		this.gc.strokePolygon(coord[0], coord[1], f.getNbPoints());

	}

	private void convert3d2d() {
		Matrix.transformation(fig.getPoints());
	}
	

	private void initialiseCoordsFromFace(Face face) {
		if ((double) face.getNbPoints() != coord[0].length)
			coord = new double[2][face.getNbPoints()];

		for (int j = 0; j < face.getPoints().size(); j++) {
			coord[0][j] = face.getPoints().get(j).getX();
			coord[1][j] = face.getPoints().get(j).getY();
			System.out.println(j+": "+coord[0][j]+";"+coord[1][j]+"\n");
		}
		System.out.println("---------------------------------------");
	}
	
	/**
	 * Draw the {@link Figure}
	 * <p> Convert the coordinate of the {@link Figure} before printing </p>
	 * @see CanvasFigure#printFigureLite()
	 */
	public void printFigure() {
		convert3d2d();
		printFigureLite();
	}

	/**
	 * Draw the {@link Figure} without convert the coordinate
	 * <p> This function is useful if you have only do minor change on the {@link CanvasFigure} and not on the {@link Figure}</p>
	 * @see CanvasFigure#printFigure()
	 */
	public void printFigureLite() {
		for (Face f : fig.getFaces()) {
			if(f.isUpper()) {
				initialiseCoordsFromFace(f);
				printFace(f);
			}
		}
	}
	
	/**
	 * Update the {@link Figure} when it changes
	 * @see Observer
	 * @see Subject
	 * @see CanvasFigure#update(Subject, Object)
	 */
	@Override
	public void update(Subject subj) {
		fig.tri();
		visualUpdate();
	}

	/**
	 * Update the {@link Figure} when it changes
	 * @see Observer
	 * @see Subject
	 * @see CanvasFigure#update(Subject)
	 */
	@Override
	public void update(Subject subj, Object data) {
		update(subj);
	}

	/**
	 * Clear the {@link Canvas}
	 */
	private void clear() {
		this.gc.setFill(canvaFillColor);
		this.gc.fillRect(0, 0, this.getWidth(), this.getHeight());
	}

	/**
	 * Update the figure on the {@link Canvas}
	 * <p> use {@link CanvasFigure#printFigure()}</p>
	 * @see CanvasFigure#visualUpdateLite()
	 */
	private void visualUpdate() {
		clear();
		printFigure();
	}
	
	/**
	 * Update the figure on the {@link Canvas}
	 * <p> use {@link CanvasFigure#printFigureLite()}</p>
	 * @see CanvasFigure#visualUpdate()
	 */
	private void visualUpdateLite() {
		clear();
		printFigureLite();
	}

	/**
	 * Put the {@link Figure} on the center of the {@link Canvas}
	 */
	public void centerFigure() {
		double[] extreme = fig.getExtremePoint();
		double ext = 0;
		for (int i = 0; i < extreme.length - 2; i++) {
			if (ext < Math.abs(extreme[i]))
				ext = Math.abs(extreme[i]);
		}
		fig.zoom((this.getHeight() / 3) / ext);

		fig.deplace(this.getWidth() / 2, this.getHeight() / 2, 0);

	}
	
	/**
	 * Begin the rotation of the {@link Figure}
	 */
	public void startRotation() {
		rotating = true;
		timeline.play();
	}
	
	/**
	 * 
	 * @return {@link boolean}
	 * 		true if the canva is rotating, false otherwise.
	 * 		@see CanvasFigure#startRotation()
	 * 		@see CanvasFigure#stopRotation()
	 */
	public boolean isRotating() {
		return this.rotating;
	}
	
	/**
	 * Stop the rotation of the {@link Figure}
	 */
	public void stopRotation() {
		rotating = false;
		timeline.stop();
	}

	public double getFigureOpacity() {
		return opacity;
	}

	public void setFigureOpacity(double newValue) {
		this.opacity = newValue;
		this.setFigureFillColor(this.figureFillColor);
	}

}
