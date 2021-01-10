package view;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import modele.modelisation.Face;
import modele.modelisation.Figure;

public class Painter {

	private final GraphicsContext gc;
	private final CanvasFigure canva;
	
	private boolean lowImpact;
	private boolean drawEdges;
	private boolean useShadow;
	private boolean faceVisible;
	private boolean colorCustom;
	
	private double opacity = 1;
	private Color canvaFillColor = Color.rgb(145, 196, 240, opacity);
	private Color figureFillColor = Color.rgb(135, 206, 250, opacity);
	
	
	private final Color figureStrokeColor = Color.BLACK;
	private double figureLineWidth = 0.15;
	
	public Painter(CanvasFigure canva) {
		this.canva = canva;
		this.gc = canva.getGraphicsContext2D();
	}
	
	public void printFace(Face f, double[][] coord) {
		
		if(f.isUpper()) {
			final boolean faceok = opacity>0&&faceVisible;
			final Color faceFillColor = setFigureColor(f);
			if(faceok) {
				printFill(f,coord,faceFillColor);
			}
			if(drawEdges&&figureLineWidth>0) {
				printEdge(f,coord,figureStrokeColor,figureLineWidth);
			} else if(faceok&&!lowImpact) {
				printEdge(f,coord,faceFillColor,0.5);
			}
		} else {
			if(drawEdges&&(opacity<1||!faceVisible)&&figureLineWidth>0) {
				printEdge(f,coord,figureStrokeColor,figureLineWidth);
			}
		}
	}

	private Color setFigureColor(Face f) {
		Color faceFillColor = figureFillColor;
		if(canva.isFigureColored()&&colorCustom) {
			faceFillColor = Color.rgb(f.getCouleur().getRed(),f.getCouleur().getGreen(),f.getCouleur().getBlue()); //DE ME TEEEER
		}
		if(useShadow) {
			double red = faceFillColor.getRed()*(f.getExposition()+((1-f.getExposition())/3));
			double green = faceFillColor.getGreen()*(f.getExposition()+((1-f.getExposition())/3));
			double blue = faceFillColor.getBlue()*(f.getExposition()+((1-f.getExposition())/3));
			if(red<0)red = 0.0;
			if(blue<0)blue = 0.0;
			if(green<0)green = 0.0;
			faceFillColor = Color.color(red, green, blue, opacity);
		}
		return faceFillColor;
	}

	private void printFill(Face f, double[][] coord, Color faceFillColor) {
		this.gc.setFill(faceFillColor);
		this.gc.fillPolygon(coord[0], coord[1], f.getNbPoints());
	}

	private void printEdge(Face f,double[][] coord, Color couleur, double largeur) {
		this.gc.setStroke(couleur);
		this.gc.setLineWidth(largeur);
		this.gc.strokePolygon(coord[0], coord[1], f.getNbPoints());
	}

	
	
	/**
	 * Clear the {@link Canvas}
	 */
	public void clear(double width,double height) {
		this.gc.setFill(canvaFillColor);
		this.gc.fillRect(0, 0, width, height);
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
	 * Set the background {@link Color} of your {@link Canvas}
	 * @param rgba
	 * 			The new {@link Color} of the background
	 */
	public void setCanvaFillColor(Color value) {
		canvaFillColor = value;
		canva.visualUpdateLite();
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
	 * Set the {@link Figure}'s {@link Color}
	 * @param rgba
	 * 			The new {@link Color} of the {@link Figure}
	 */
	public void setFigureFillColor(Color value) {
		figureFillColor = value;
		canva.visualUpdateLite();
	}

	public double getFigureOpacity() {
		return opacity;
	}

	public void setFigureOpacity(double newValue) {
		opacity = newValue;
		canva.visualUpdateLite();
	}

	/**
	 * Set the edge's width
	 * @param value
	 * 			the value of the new edge's width of the {@link Figure}
	 */
	public void setFigureLineWidth(double value) {
		figureLineWidth = value;
		canva.visualUpdateLite();
	}

	public void setAllEdgeVisible(boolean newValue) {
		drawEdges = newValue;
		canva.visualUpdateLite();
	}

	public void setLowImpact(boolean newValue) {
		lowImpact = newValue;
		canva.visualUpdateLite();
	}
	
	public void setShadowView(boolean newValue) {
		useShadow = newValue;
		canva.visualUpdateLite();
	}

	public void setFaceVisible(boolean newValue) {
		faceVisible = newValue;
		canva.visualUpdateLite();
	}

	public void setCouleurCustom(boolean newValue) {
		colorCustom = newValue;
		canva.visualUpdateLite();
	}
	
}
