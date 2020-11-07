package view;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import modele.modelisation.Face;
import modele.modelisation.Figure;
import modele.modelisation.Matrix;
import utils.Observer;
import utils.Subject;

public class Canva extends Canvas implements Observer{

	private Figure fig;
	//private Timeline timeline;
	
	private GraphicsContext gc;
	
	private double[][] coord;
	
	public Canva(Figure figure, double width, double height) {
		this.setWidth(width);
		this.setHeight(height);
		figure.attach(this);
		this.fig = figure;
		coord = new double[1][1];
		
		this.gc = this.getGraphicsContext2D();
		
		this.printFigure();
		
		/*
		timeline= new Timeline(new KeyFrame(Duration.seconds(0.033333), e -> {
			fig.tri();
			Mouvement.rotate(fig, 1, 1, 1);
			this.getChildren().clear();
			this.getChildren().addAll(this.getFigure());
		}));
		timeline.setCycleCount(Animation.INDEFINITE);
		timeline.setAutoReverse(true);
		
		timeline.play();
		*/
    	
	}

	private void printPolygon(double[][] coord,  Face f) {
		this.gc.setFill(Color.rgb(135, 206, 250, 1));
		this.gc.setStroke(Color.BLACK);
		this.gc.setLineWidth(0.2);
		this.gc.fillPolygon(coord[0], coord[1], f.getNbPoints());
		this.gc.strokePolygon(coord[0], coord[1], f.getNbPoints());
		
		/*poly.setFill(Color.rgb(135, 206, 250, 1));
		poly.getPoints().setAll(coord);
		poly.setStroke(Color.BLACK);
		poly.setStrokeWidth(0.2);*/
	}

	private void convert3d2d(Face face) {
		/*
		 * 
		 */
		if((double) face.getNbPoints()!=coord[0].length)
			coord = new double[2][face.getNbPoints()];
		for (int j = 0; j < face.getPoints().size(); j++) {
			Matrix.transformation(face.getPoints().get(j));
			coord[0][j] = face.getPoints().get(j).getX();
			coord[1][j] = face.getPoints().get(j).getY();
		}	
	}
	
	public void printFigure() {
		/*
		 * CA DOIT MODIFIER ET NON CHANGER LE POLYGONE
		 */
		
		for(Face f : fig.getFaces()) {
			convert3d2d((f));
			printPolygon(coord,f);
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
		this.gc.setFill(Color.WHITE);
		this.gc.fillRect(0,0,this.getWidth(),this.getHeight());

	}
}
