package modele;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import modele.modelisation.Point;

class PointTest {

	private Point classique;
	private Point vide;
	
	
	@BeforeEach
	public void initialise() {
		classique = new Point(0.0, 1.0, 2.0);
		vide = new Point(0.0, 0.0, 0.0);

	}
	
	@Test
	public void testGetter() {
		assertEquals(0.0, classique.getX());
		assertEquals(1.0, classique.getY());
		assertEquals(2.0, classique.getZ());
		
		assertEquals(0.0, vide.getX());
		assertEquals(0.0, vide.getY());
		assertEquals(0.0, vide.getZ());
	}
	
	@Test
	public void testDeplacer() {
		classique.deplacer(1.0, 1.0, 1.0);
		assertEquals(1.0, classique.getX());
		assertEquals(2.0, classique.getY());
		assertEquals(3.0, classique.getZ());
		classique.deplacerX(-1.0);
		assertEquals(0.0, classique.getX());
		classique.deplacerY(-1.0);
		assertEquals(1.0, classique.getY());
		classique.deplacerZ(-1.0);
		assertEquals(2.0, classique.getZ());
		
		
		vide.deplacer(1.0, 1.0, 1.0);
		assertEquals(1.0, vide.getX());
		assertEquals(1.0, vide.getY());
		assertEquals(1.0, vide.getZ());
		vide.deplacerX(-1.0);
		assertEquals(0.0, vide.getX());
		vide.deplacerY(-1.0);
		assertEquals(0.0, vide.getY());
		vide.deplacerZ(-1.0);
		assertEquals(0.0, vide.getZ());
		
	}
	
	@Test
	public void test_rotate_classique_all() {
		classique.rotate(1, 1, 1);
		assertEquals(-0.05, classique.getX(), 0.01);
		assertEquals(0.96, classique.getY(), 0.01);
		assertEquals(2.01, classique.getZ(), 0.01);
	}
	
	@Test
	public void test_rotate_classique_X() {
		classique.rotateX(2);
		assertEquals(0.00, classique.getX(), 0.01);
		assertEquals(0.92, classique.getY(), 0.01);
		assertEquals(2.03, classique.getZ(), 0.01);
		
		classique.rotateX(-1);
		assertEquals(0.00, classique.getX(), 0.01);
		assertEquals(0.96, classique.getY(), 0.01);
		assertEquals(2.01, classique.getZ(), 0.01);
	}
	
	@Test
	public void test_rotate_classique_Y() {
		classique.rotateY(2);
		assertEquals(-0.06, classique.getX(), 0.01);
		assertEquals(1.0, classique.getY(), 0.01);
		assertEquals(1.99, classique.getZ(), 0.01);
		
		classique.rotateY(-1);
		assertEquals(-0.03, classique.getX(), 0.01);
		assertEquals(1.0, classique.getY(), 0.01);
		assertEquals(1.99, classique.getZ(), 0.01);
	}
	
	@Test
	public void test_rotate_classique_Z() {
		classique.rotateZ(2);
		assertEquals(-0.03, classique.getX(), 0.01);
		assertEquals(0.99, classique.getY(), 0.01);
		assertEquals(2, classique.getZ(), 0.01);
		
		classique.rotateZ(-1);
		assertEquals(-0.01, classique.getX(), 0.01);
		assertEquals(0.99, classique.getY(), 0.01);
		assertEquals(2, classique.getZ(), 0.01);
	}
	
	@Test
	public void test_rotate_vide_X() {
		classique.rotateX(4);
		assertEquals(0.0, vide.getX(), 0.01);
		assertEquals(0.0, vide.getY(), 0.01);
		assertEquals(0.0, vide.getZ(), 0.01);
		
		classique.rotateX(-1);
		assertEquals(0.0, vide.getX(), 0.01);
		assertEquals(0.0, vide.getY(), 0.01);
		assertEquals(0.0, vide.getZ(), 0.01);
	}
	
	@Test
	public void test_rotate_vide_Y() {
		classique.rotateY(1);
		assertEquals(0.0, vide.getX(), 0.01);
		assertEquals(0.0, vide.getY(), 0.01);
		assertEquals(0.0, vide.getZ(), 0.01);
		
		classique.rotateY(-3);
		assertEquals(0.0, vide.getX(), 0.01);
		assertEquals(0.0, vide.getY(), 0.01);
		assertEquals(0.0, vide.getZ(), 0.01);
	}
	
	@Test
	public void test_rotate_vide_Z() {
		classique.rotateZ(1);
		assertEquals(0.0, vide.getX(), 0.01);
		assertEquals(0.0, vide.getY(), 0.01);
		assertEquals(0.0, vide.getZ(), 0.01);
		
		classique.rotateZ(-2);
		assertEquals(0.0, vide.getX(), 0.01);
		assertEquals(0.0, vide.getY(), 0.01);
		assertEquals(0.0, vide.getZ(), 0.01);
	}

}
