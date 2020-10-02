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
	void testGetters() {
		assertEquals(4, classique.getNbPoints());
		assertEquals(classiqueList, classique.getPoints());
		
		assertEquals(0, vide.getNbPoints());
		assertEquals(videList, vide.getPoints());
		
		assertEquals(nulle.getNbPoints(), 0);
		assertEquals(new ArrayList<Integer>(), nulle.getPoints());
	}

}
