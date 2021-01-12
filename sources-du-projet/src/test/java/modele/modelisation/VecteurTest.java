package modele.modelisation;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class VecteurTest {

	Point a;
	Point b;
	Point c;
	
	@BeforeEach
	public void startup() {
		
	}

	@Test
	void testGetNormal_easy() {
		a = new Point(0,1,1);
		b = new Point(1,1,1);
		c = new Point(0,1,0);
		
		Vecteur norm = Vecteur.getNormal(a, b, c);
		assertEquals(-0.0,norm.getDirX()); // oui selon junit -0.0 != 0.0
		assertEquals(1.0,norm.getDirY());
		assertEquals(0.0,norm.getDirZ());
		assertEquals(1.0,norm.getNorm());
	}
	
	@Test
	void testGetNormal_medium() {
		a = new Point(1,2,3);
		b = new Point(2,3,3);
		c = new Point(2,2,5);
		
		Vecteur norm = Vecteur.getNormal(a, b, c);
		assertEquals(1.0,norm.getNorm());
	}

}
