package modele;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PointTest {

	private Point classique3d;
	private Point vide;
	
	
	@BeforeEach
	public void initialise() {
		classique3d = new Point(0.0, 1.0, 2.0);
		vide = new Point(0.0, 0.0, 0.0);

	}
	
	@Test
	public void testGetter() {
		assertEquals(0.0, classique3d.getX());
		assertEquals(1.0, classique3d.getY());
		assertEquals(2.0, classique3d.getZ());
		
		assertEquals(0.0, vide.getX());
		assertEquals(0.0, vide.getY());
		assertEquals(0.0, vide.getZ());
	}
	
	@Test
	public void testDeplacer() {
		classique3d.deplacer(1.0, 1.0, 1.0);
		assertEquals(1.0, classique3d.getX());
		assertEquals(2.0, classique3d.getY());
		assertEquals(3.0, classique3d.getZ());
		classique3d.deplacerX(-1.0);
		assertEquals(0.0, classique3d.getX());
		classique3d.deplacerY(-1.0);
		assertEquals(1.0, classique3d.getY());
		classique3d.deplacerZ(-1.0);
		assertEquals(2.0, classique3d.getZ());
		
		
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
	public void testRotate() {
		System.out.println(classique3d);
		classique3d.rotate(1, 1, 1);
		System.out.println(classique3d);
	}

}
