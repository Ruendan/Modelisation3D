package modele;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FaceTest {

	private Face classique;
	private List<Integer> classiqueList = Arrays.asList(new Integer[] {0,1,2,3});
	
	private Face nulle;
	
	private List<Integer> videList = Arrays.asList(new Integer[] {});
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
