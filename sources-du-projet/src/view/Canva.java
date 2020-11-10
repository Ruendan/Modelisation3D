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

public class Canva extends Canvas implements Observer {

	private Figure fig;
	private Timeline timeline;

	private Color canvaFillColor = Color.rgb(135, 206, 250, 1);

	private Color figureFillColor = Color.rgb(135, 206, 250, 1);
	private Color figureStrokeColor = Color.BLACK;
	private double figureLineWidth = 0.2;

	private GraphicsContext gc;

	private static final double DEFAULT_WIDTH = 700;
	private static final double DEFAULT_HEIGHT = 500;

	private double[][] coord;

	public Canva(double width, double height) {
		this.gc = this.getGraphicsContext2D();
		this.setWidth(width);
		this.setHeight(height);
		coord = new double[2][1];
	}

	public Canva() {
		this(DEFAULT_WIDTH, DEFAULT_HEIGHT);
	}

	public void setCanvaFillColor(Color rgba) {
		this.canvaFillColor = rgba;
		visualUpdateLite();
	}

	public Color getCanvaFillColor() {
		return canvaFillColor;
	}

	public void setFigureFillColor(Color rgba) {
		this.figureFillColor = rgba;
		visualUpdateLite();
	}

	public Color getFigureFillColor() {
		return figureFillColor;
	}

	public Figure getFigure() {
		return this.fig;
	}

	public void setFigure(Figure fig) {
		if (this.fig != null)
			this.fig.detach(this);

		this.fig = fig;
		this.fig.attach(this);
		this.centerFigure();
		this.printFigure();
		timeline = new Timeline(new KeyFrame(Duration.seconds(0.5), e -> {
			fig.rotate(5, 5 ,5);
			visualUpdate();
		}));
		timeline.setCycleCount(Animation.INDEFINITE);
		timeline.setAutoReverse(true);
	}

	public double getFigureLineWidth() {
		return this.figureLineWidth;
	}

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
		for (Point p : fig.getPoints())
			Matrix.transformation(p);
	}

	public void initialiseCoordsFromFace(Face face) {
		if ((double) face.getNbPoints() != coord[0].length)
			coord = new double[2][face.getNbPoints()];

		for (int j = 0; j < face.getPoints().size(); j++) {
			coord[0][j] = face.getPoints().get(j).getX();
			coord[1][j] = face.getPoints().get(j).getY();
		}
	}

	public void printFigure() {
		convert3d2d();
		printFigureLite();
	}

	public void printFigureLite() {
		for (Face f : fig.getFaces()) {
			initialiseCoordsFromFace(f);
			printFace(f);
		}
	}

	@Override
	public void update(Subject subj) {
		fig.tri();
		visualUpdate();
	}

	@Override
	public void update(Subject subj, Object data) {
		update(subj);
	}

	private void clear() {
		this.gc.setFill(canvaFillColor);
		this.gc.fillRect(0, 0, this.getWidth(), this.getHeight());
	}

	private void visualUpdate() {
		clear();
		printFigure();
	}

	private void visualUpdateLite() {
		clear();
		printFigureLite();
	}

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

	public void startRotation() {
		timeline.play();
	}
	public void stopRotation() {
		timeline.stop();
	}

}
