package modele.modelisation;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class VecteurTest {

	Point a;
	Point b;
	Point c;
	
	@BeforeEach
	public void startup() {
		a = new Point(0,1,1);
		b = new Point(1,1,1);
		c = new Point(0,1,0);
	}

	@Test
	void testGetNormal() {
		Vecteur norm = Vecteur.getNormal(a, b, c);
		assertTrue(0.0==norm.getDirX());
		assertTrue(1.0==norm.getDirY());
		assertTrue(0.0==norm.getDirZ());
	}

}
