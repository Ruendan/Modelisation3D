package view;

import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;
import modele.modelisation.Face;
import modele.modelisation.Figure;
import modele.modelisation.Matrix;
import modele.modelisation.Point;
import modele.modelisation.Vecteur;
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
	
	private TimelineUtils timeline;
	
	private final Vecteur vVue = Vecteur.getDirecteur(0,0,1);
	private final Vecteur vLumiere = Vecteur.getDirecteur(1,1,1); //faut que je le fasse (Sylvain)
	
	private Painter painter;
	private View mainWindow;
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
		super();
		this.painter = new Painter(this);
		this.setWidth(width);
		this.setHeight(height);
		coord = new double[2][1];
		timeline = new TimelineUtils(this);
		
	}
	
	/**
	 * Create the {@link Canvas} of the {@link Figure} with the default width and height
	 * <p> DEFAULT_WIDTH = 800 <br> DEFAULT_HEIGHT = 500 </p>
	 * @param view 
	 */
	public CanvasFigure(View view) {
		this(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		this.mainWindow = view;
	}
	
	/**
	 * Set the background {@link Color} of your {@link Canvas}
	 * @param rgba
	 * 			The new {@link Color} of the background
	 */
	public void setCanvaFillColor(Color rgba) {
		painter.setCanvaFillColor(rgba);
	}
	
	/**
	 * Set the {@link Figure}'s {@link Color}
	 * @param rgba
	 * 			The new {@link Color} of the {@link Figure}
	 */
	public void setFigureFillColor(Color rgba) {
		painter.setFigureFillColor(rgba);
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
		this.mainWindow.updateTitle(fig.getName());
		this.fig = fig;
		this.fig.attach(this);
		this.centerFigure();
		this.printFigure();
		this.stopRotation();
	}
	
	private void initialiseCoordsFromFace(Face face) {
		if ((double) face.getNbPoints() != coord[0].length)
			coord = new double[2][face.getNbPoints()];

		for (int j = 0; j < face.getPoints().size(); j++) { //demeter
			coord[0][j] = face.getPoints().get(j).getX();
			coord[1][j] = face.getPoints().get(j).getY();
		}
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
		for (final Face f : fig.getFaces()) {
			initialiseCoordsFromFace(f);
			painter.printFace(f,coord);
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
		fig.tri(vVue,vLumiere);
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

	private void convert3d2d() {
		for (final Point p : fig.getPoints())
			Matrix.transformation(p);
	}

	/**
	 * Update the figure on the {@link Canvas}
	 * <p> use {@link CanvasFigure#printFigure()}</p>
	 * @see CanvasFigure#visualUpdateLite()
	 */
	private void visualUpdate() {
		painter.clear(this.getWidth(), this.getHeight());
		printFigure();
	}
	
	/**
	 * Update the figure on the {@link Canvas}
	 * <p> use {@link CanvasFigure#printFigureLite()}</p>
	 * @see CanvasFigure#visualUpdate()
	 */
	public void visualUpdateLite() {
		painter.clear(this.getWidth(), this.getHeight());
		printFigureLite();
	}

	/**
	 * Put the {@link Figure} on the center of the {@link Canvas}
	 */
	public void centerFigure() {
		final double[] extreme = fig.getExtremePoint();
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
		timeline.play();
	}

	
	/**
	 * Stop the rotation of the {@link Figure}
	 */
	public void stopRotation() {
		timeline.stop();
	}

	public Painter getPainter() {
		return painter;
	}
	
	public boolean isRotating() {
		return timeline.isRunning();
	}

	public boolean isFigureColored() {
		return fig.isColored();
	}
	
}
