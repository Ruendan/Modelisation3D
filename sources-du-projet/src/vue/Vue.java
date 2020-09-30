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

	@Override
	public void start(Stage primaryStage) throws Exception {
		int vertex = 5;
		int face = 6;
		Polygon[] pol= new Polygon[face]; 
		List<Double[]> point = new ArrayList<>();
		point.add(new Double[] {0.0,0.0,0.0});//0
		point.add(new Double[] {1.0,0.0,0.0});//1
		point.add(new Double[] {1.0,1.0,0.0});//2
		point.add(new Double[] {0.0,1.0,0.0});//3
		point.add(new Double[] {0.5,0.5,1.6});//4
		Group root = new Group();
		
		List<Integer[]> faces = new ArrayList<>();
		faces.add(new Integer[] {3 ,1, 0 ,3});
		faces.add(new Integer[] {3 ,1, 3 ,2});
		faces.add(new Integer[] {3 ,0, 1 ,4});
		faces.add(new Integer[] {3 ,0, 4 ,3});
		faces.add(new Integer[] {3 ,3, 4 ,2});
		faces.add(new Integer[] {3 ,1, 2 ,4});
		
		
		for(int i=0;i<point.size();i++) {
			point.set(i, rotateZ(point.get(i),-20));
			point.set(i, rotateX(point.get(i),100));
			point.set(i, rotateY(point.get(i),-15));
			point.set(i, agrandir(point.get(i)));
			
		}
		
		for(int i=0; i<faces.size();i++) {
			Double[] coord = convert3d2d(faces.get(i),point);	
			pol[i] = getPolygon(coord);
			System.out.println("test");
		}
		System.out.println("done");
	
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
		poly.setFill(Color.rgb(135,206,250,0.5));
		poly.getPoints().setAll(coord);
		poly.setStroke(Color.BLACK);
		poly.setStrokeWidth(2);
		return poly;
	}

	private Double[] convert3d2d(Integer[] face, List<Double[]> point) {
		Double[] coord = new Double[(face[0]*2)];
		for(int j=1; j<face.length;j++) {
			Double[] test = transformation(point.get((int)(double) face[j]));
			System.out.println((j-1)+"\n"+test[0]+"\n"+test[1]);
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
}
