package modele;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FaceTest {

	private Face classique;
	private List<Point> classiqueList = Arrays.asList(new Point[] {
			new Point(0,0,0),
			new Point(0,1,0),
			new Point(1,0,0),
			new Point(1,1,0)});
	
	private Face nulle;
	
	private List<Point> videList = Arrays.asList(new Point[] {});
	private Face vide;
	
	@BeforeEach
	public void initialise() {
		classique = new Face(4,classiqueList);
		nulle = new Face(0,null);
		vide = new Face(0,videList);
	}
	
	@Test
	public void testGetters() {
		assertEquals(4, classique.getNbPoints());
		assertEquals(classiqueList, classique.getPoints());
		
		assertEquals(0, vide.getNbPoints());
		assertEquals(videList, vide.getPoints());
		
		
		//Il faut que tu gère le Null Exception dans le constructeur de Face
		assertEquals(nulle.getNbPoints(), 0);
		assertEquals(new ArrayList<Integer>(), nulle.getPoints());
	}
	
	@Test
	public void test_point_moyen_classique() {
		//Indice, il faut que tu ecrive le public equals(Object o) de Face :D )
		assertEquals(new Point(0.5, 0.5, 0), classique.pointMoyen());
	}
	
	@Test
	public void test_point_moyen_vide() {
		assertEquals(new Point(Double.NaN, Double.NaN, Double.NaN), vide.pointMoyen());
	}
	
	@Test
	public void test_point_moyen_nulle() {
		//Normalement, si le test getter fonctionne, alors lui aussi
		assertEquals(new Point(Double.NaN, Double.NaN, Double.NaN), nulle.pointMoyen());
	}
	
	@Test
	public void test_moyenneX_classique() {
		assertEquals(0.5, classique.moyenneX());
	}
	
	@Test
	public void test_moyenneY_classique() {
		assertEquals(0.5, classique.moyenneY());
	}
	
	@Test
	public void test_moyenneZ_classique() {
		assertEquals(0, classique.moyenneZ());
	}
	
	@Test
	public void test_moyenneX_vide() {
		assertEquals(0, vide.moyenneX());
	}
	
	@Test
	public void test_moyenneY_vide() {
		assertEquals(0, vide.moyenneY());
	}
	
	@Test
	public void test_moyenneZ_vide() {
		assertEquals(0, vide.moyenneZ());
	}
	
	@Test
	public void test_compareTo_classique() {
		fail("C'est pas encore implémenté. Il faut qu'on se pose calmement dessus");
	}

}
