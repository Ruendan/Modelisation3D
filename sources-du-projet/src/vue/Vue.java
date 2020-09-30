package vue;

import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;

public class Vue extends Application{
	public static void main(String[] args) {
		Application.launch(args);
	}
	
	private List<Double[]> point;
	private List<Integer[]> faces;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		int vertex = 5;
		int face = 6;
		Polygon[] pol= new Polygon[face]; 
		point = new ArrayList<>();
		point.add(new Double[] {-1.0, -1.0, -1.0});//0
		point.add(new Double[] {1.0, -1.0, -1.0});//1
		point.add(new Double[] {1.0, 1.0, -1.0 });//2
		point.add(new Double[] {-1.0, 1.0, -1.0});//3
		point.add(new Double[] {-1.0, -1.0, 1.0 });//4
		point.add(new Double[] {1.0, -1.0, 1.0 });//5
		point.add(new Double[] {1.0, 1.0, 1.0 });//6
		point.add(new Double[] {-1.0, 1.0, 1.0 });//7
		Group root = new Group();
		
		faces = new ArrayList<>();
		faces.add(new Integer[] {4, 0, 1, 2, 3 });
		faces.add(new Integer[] {4, 5, 4, 7, 6 });
		faces.add(new Integer[] {4, 6, 2, 1, 5 });
		faces.add(new Integer[] {4, 3, 7, 4, 0 });
		faces.add(new Integer[] {4, 7, 3, 2, 6 });
		faces.add(new Integer[] {4, 5, 1, 0, 4 });
		
		for(int i=0;i<point.size();i++) {
			point.set(i, rotateZ(point.get(i),45));//O
			point.set(i, rotateX(point.get(i),45));//|
			point.set(i, rotateY(point.get(i),0));//-
			point.set(i, agrandir(point.get(i)));
			
		}
		tri();
		for(int i=0; i<faces.size();i++) {
			Double[] coord = convert3d2d(faces.get(i));	
			pol[i] = getPolygon(coord);
		}
	
		root.getChildren().addAll(pol);
		Scene scene = new Scene(root,1000,1000);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	
	private Double[] agrandir(Double[] point) {
		for(int j=0;j<point.length;j++) {
			point[j] *= 100;
			point[j] +=300;
		} 
		return point;
	}

	private Polygon getPolygon(Double[] coord) {
		Polygon poly = new Polygon();
		poly.setFill(Color.rgb(135,206,250,0.7));
		poly.getPoints().setAll(coord);
		poly.setStroke(Color.BLACK);
		poly.setStrokeWidth(2);
		return poly;
	}

	private Double[] convert3d2d(Integer[] face) {
		Double[] coord = new Double[(face[0]*2)];
		for(int j=1; j<face.length;j++) {
			Double[] test = transformation(point.get((int)(double) face[j]));
			coord[(j-1)*2]= test[0];
			coord[(j-1)*2+1] = test[1];
		}
		return coord;
	}

	public static Double[] transformation(Double[] valeurs) {
		Double[][] matrice = new Double[][] {
			{1.0,	0.0,	0.0},
			{0.0,	1.0,	0.0}};
			
		return calculMatrice(matrice,valeurs);

	}
	
	
	public static Double[] rotateZ(Double[] valeurs,double theta) {
		theta = Math.toRadians(theta);
		Double[][] matrice = new Double[][] {
			{Math.cos(theta),	-Math.sin(theta),	0.0},
			{Math.sin(theta),	Math.cos(theta),	0.0},
			{0.0,				0.0,				1.0}};	
			
		return calculMatrice(matrice,valeurs);
	}
	public static Double[] rotateX(Double[] valeurs,double theta) {
		theta = Math.toRadians(theta);
		Double[][] matrice = new Double[][] {
			{1.0,				0.0,						0.0},
			{0.0,				Math.cos(theta),			-Math.sin(theta)},
			{0.0,				Math.sin(theta),			Math.cos(theta)}};
			
		return calculMatrice(matrice,valeurs);
	}
	
	
	public static Double[] rotateY(Double[] valeurs,double theta) {
		theta = Math.toRadians(theta);
		Double[][] matrice = new Double[][] {
			{Math.cos(theta),		0.0,		-Math.sin(theta)},
			{0.0,					1.0,		0.0},
			{Math.sin(theta),		0.0,		Math.cos(theta)}};
			
		return calculMatrice(matrice,valeurs);

	}
	
	public static Double[] calculMatrice(Double[][] matrice, Double[] valeurs) {
		Double[] res = new Double[matrice.length];
		for(int i=0; i<matrice.length;i++) {
			res[i]=0.0;
			for(int j = 0 ; j<valeurs.length;j++) {
				res[i]+=(valeurs[j])*matrice[i][j];
			}
			
		}
		return res;
	}
	
	public double getZ(int i) {
		return point.get(i)[2];
	}
	
	public double moyenneZ(Integer[] face) {
		double res=0;
		for(int i = 1; i<=face[0];i++) {
			res+=getZ(face[i]);
		}
		return res/face[0];
	}
	
	public void tri() {
		List<Double> moyennesZ = new ArrayList<Double>();
		for(Integer[] f : faces) {
			moyennesZ.add(moyenneZ(f));
		}
		Integer[] tempInt;
		double tempDouble;
		for(int i = 0; i< moyennesZ.size();i++) {
			for(int j = i+1 ; j<moyennesZ.size();j++) {
				if(moyennesZ.get(i)>moyennesZ.get(j)) {
					tempInt = faces.get(i);
					faces.set(i, faces.get(j));
					faces.set(j, tempInt);
					
					tempDouble = moyennesZ.get(i);
					moyennesZ.set(i, moyennesZ.get(j));
					moyennesZ.set(j, tempDouble);
				}
			}
		}
	}
}
