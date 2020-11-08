package view;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import modele.modelisation.Face;
import modele.modelisation.Figure;
import modele.modelisation.Matrix;
import utils.Observer;
import utils.Subject;

public class Canva extends Canvas implements Observer {

	private Figure fig;
	// private Timeline timeline;
	
	private Color canvaFillColor = Color.rgb(135, 206, 250, 1);
	
	private Color figureFillColor = Color.rgb(135, 206, 250, 1);
	private Color figureStrokeColor = Color.BLACK;
	private double figureLineWidth = 0.2;

	private GraphicsContext gc;

	private double[][] coord;

	public Canva(double width, double height) {
		this.gc = this.getGraphicsContext2D();
		this.setWidth(width);
		this.setHeight(height);
		coord = new double[2][1];
	}
	
	public void setCanvaFillColor(Color rgba) {
		this.canvaFillColor = rgba;
		this.clear();
		this.printFigure();
	}
	
	public Color getCanvaFillColor() {
		return canvaFillColor;
	}
	
	public void setFigureFillColor(Color rgba) {
		this.figureFillColor=rgba;
		this.clear();
		this.printFigure();
	}
	
	public Color getFigureFillColor() {
		return figureFillColor;
	}
	
	public Figure getFigure() {
		return this.fig;
	}
	
	public void setFigure(Figure fig) {
		if(this.fig!=null)this.fig.detach(this);
		this.fig = fig;
		this.fig.attach(this);
		this.fig.centerFigure(this.getWidth(), this.getHeight());
		this.printFigure();
	}

	private void printPolygon(double[][] coord, Face f) {
		this.gc.setFill(figureFillColor);
		this.gc.setStroke(figureStrokeColor);
		this.gc.setLineWidth(figureLineWidth);
		this.gc.fillPolygon(coord[0], coord[1], f.getNbPoints());
		this.gc.strokePolygon(coord[0], coord[1], f.getNbPoints());

	}

	private void convert3d2d(Face face) {
		if ((double) face.getNbPoints() != coord[0].length)
			coord = new double[2][face.getNbPoints()];
		for (int j = 0; j < face.getPoints().size(); j++) {
			Matrix.transformation(face.getPoints().get(j));
			coord[0][j] = face.getPoints().get(j).getX();
			coord[1][j] = face.getPoints().get(j).getY();
		}
	}

	public void printFigure() {
		for (Face f : fig.getFaces()) {
			convert3d2d((f));
			printPolygon(coord, f);
		}
	}

	@Override
	public void update(Subject subj) {
		fig.tri();
		this.clear();
		this.printFigure();
	}

	@Override
	public void update(Subject subj, Object data) {
		update(subj);
	}

	private void clear() {
		this.gc.setFill(canvaFillColor);
		this.gc.fillRect(0, 0, this.getWidth(), this.getHeight());
	}

	

	

	

	/*
	 * CODE POUR LA TIMELINE timeline= new Timeline(new
	 * KeyFrame(Duration.seconds(0.033333), e -> { fig.tri(); Mouvement.rotate(fig,
	 * 1, 1, 1); this.getChildren().clear();
	 * this.getChildren().addAll(this.getFigure()); }));
	 * timeline.setCycleCount(Animation.INDEFINITE); timeline.setAutoReverse(true);
	 * 
	 * timeline.play();
	 */
}
