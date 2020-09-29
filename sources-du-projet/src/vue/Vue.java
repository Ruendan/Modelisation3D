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
		
		List<Double[]> faces = new ArrayList<>();
		faces.add(new Double[] {3.0 ,1.0, 0.0 ,3.0});
		faces.add(new Double[] {3.0 ,1.0, 3.0 ,2.0});
		faces.add(new Double[] {3.0 ,0.0, 1.0 ,4.0});
		faces.add(new Double[] {3.0 ,0.0, 4.0 ,3.0});
		faces.add(new Double[] {3.0 ,3.0, 4.0 ,2.0});
		faces.add(new Double[] {3.0 ,1.0, 2.0 ,4.0});
		
		
		for(int i=0;i<point.size();i++) {
			point.set(i, rotateZ(point.get(i),22.5));
			point.set(i, rotateX(point.get(i),100));
			point.set(i, rotateY(point.get(i),22.5));
			for(int j=0;j<point.get(i).length;j++) {
				point.get(i)[j] *= 100;
				point.get(i)[j] +=300;
			} 
		}
		for(int i=0; i<faces.size();i++) {
			Double[] coord = new Double[(int) (faces.get(i)[0]*2)];
			System.out.println(i);
			for(int j=1; j<faces.get(i).length;j++) {
//				System.out.println(i);
//				System.out.println(j);
				
				Double[] test = calculMatrice(point.get((int)(double) faces.get(i)[j]));
				System.out.println((j-1)+"\n"+test[0]+"\n"+test[1]);
				coord[(j-1)*2]= test[0];
				coord[(j-1)*2+1] = test[1];
			}
			Polygon square = new Polygon();
			//square.setFill(Color.LIGHTSKYBLUE);
			square.getPoints().setAll(coord);
			square.setStroke(Color.BLACK);
			square.setStrokeWidth(2);
			
			square.setFill(null);
			pol[i] = square;
			System.out.println("test");
		}
		System.out.println("done");
	
		root.getChildren().addAll(pol);
		Scene scene = new Scene(root,1000,1000);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static Double[] calculMatrice(Double[] integers) {
		Double[][] matrice = new Double[][] {{1.0,0.0,0.0},{0.0,1.0,0.0}};
		Double[] res = new Double[2];
		for(int i=0; i<matrice.length;i++) {
			res[i]=0.0;
			for(int j = 0 ; j<integers.length;j++) {
				res[i]+=integers[j]*matrice[i][j];
			}
		}
		return res;
	}
	
	public static Double[] rotateZ(Double[] integers,double theta) {
		Double[] valeurs = new Double[] {(double) integers[0],(double) integers[1],(double) integers[2]};
		theta = Math.toRadians(theta);
		Double[][] matrice = new Double[][] {
			{Math.cos(theta),	-Math.sin(theta),	0.0},
			{Math.sin(theta),	Math.cos(theta),	0.0},
			{0.0,				0.0,				1.0}};	
		Double[] res = new Double[3];
		for(int i=0; i<matrice.length;i++) {
			res[i]=0.0;
			for(int j = 0 ; j<valeurs.length;j++) {
				res[i]+=(valeurs[j])*matrice[i][j];
			}
			
		}
		return res;
	}
	public static Double[] rotateX(Double[] integers,double theta) {
		Double[] valeurs = new Double[] {(double) integers[0],(double) integers[1],(double) integers[2]};
		theta = Math.toRadians(theta);
		Double[][] matrice = new Double[][] {
			{1.0,				0.0,				0.0},
			{0.0,				Math.cos(theta),	-Math.sin(theta)},
			{0.0,				Math.sin(theta),	Math.cos(theta)}};
		Double[] res = new Double[3];
		for(int i=0; i<matrice.length;i++) {
			res[i]=0.0;
			for(int j = 0 ; j<valeurs.length;j++) {
				res[i]+=(valeurs[j])*matrice[i][j];
			}
		}
		return res;
	}
	public static Double[] rotateY(Double[] integers,double theta) {
		Double[] valeurs = new Double[] {(double) integers[0],(double) integers[1],(double) integers[2]};
		theta = Math.toRadians(theta);
		Double[][] matrice = new Double[][] {
			{Math.cos(theta),	0.0,				-Math.sin(theta)},
			{0.0,				1.0,				0.0},
			{Math.sin(theta),	0.0,	Math.cos(theta)}};
		Double[] res = new Double[3];
		for(int i=0; i<matrice.length;i++) {
			res[i]=0.0;
			for(int j = 0 ; j<valeurs.length;j++) {
				res[i]+=(valeurs[j])*matrice[i][j];
			}
		}
		return res;
	}
}
