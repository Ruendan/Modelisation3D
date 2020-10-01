package modele;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PointTest {

	private Point classique3d;
	private Point videDim3;
	
	private Point classique2d;
	private Point videDim2;
	
	
	@BeforeEach
	public void initialise() {
		classique3d = new Point(0.0, 1.0, 2.0);
		videDim3 = new Point(0.0, 0.0, 0.0);
		
		classique2d = new Point(4.0, 7.0);
		videDim2 = new Point(0.0, 0.0);
	}
	
	@Test
	public void testGetter() {
		assertEquals(0.0, classique3d.getX());
		assertEquals(1.0, classique3d.getY());
		assertEquals(2.0, classique3d.getZ());
		assertFalse(classique3d.isDim2());
		
		assertEquals(0.0, videDim3.getX());
		assertEquals(0.0, videDim3.getY());
		assertEquals(0.0, videDim3.getZ());
		assertFalse(videDim3.isDim2());
		
		assertEquals(4.0, classique2d.getX());
		assertEquals(7.0, classique2d.getY());
		assertEquals(0.0, classique2d.getZ());
		assertTrue(classique2d.isDim2());
		
		assertEquals(0.0, videDim2.getX());
		assertEquals(0.0, videDim2.getY());
		assertEquals(0.0, videDim2.getZ());
		assertTrue(videDim2.isDim2());
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
		
		
		videDim3.deplacer(1.0, 1.0, 1.0);
		assertEquals(1.0, videDim3.getX());
		assertEquals(1.0, videDim3.getY());
		assertEquals(1.0, videDim3.getZ());
		videDim3.deplacerX(-1.0);
		assertEquals(0.0, videDim3.getX());
		videDim3.deplacerY(-1.0);
		assertEquals(0.0, videDim3.getY());
		videDim3.deplacerZ(-1.0);
		assertEquals(0.0, videDim3.getZ());
		
		
		//Tests sur un point en 2 dimensions Classique
		classique2d.deplacer(1.0, 1.0, 1.0);
		assertEquals(5.0, classique2d.getX(), "Modifie juste le X");
		assertEquals(8.0, classique2d.getY(), "Modifie juste le Y");
		assertEquals(0.0, classique2d.getZ(), "On est en 2D, le Z doit pas bouger");
		classique2d.deplacerX(-2.0);
		assertEquals(3.0, classique2d.getX(), "Modifie juste le X");
		classique2d.deplacerY(2.0);
		assertEquals(10.0, classique2d.getY(), "Modifie juste le Y");
		classique2d.deplacerZ(-1.0);
		assertEquals(0.0, classique2d.getZ(), "On est en 2D, le Z doit pas bouger");
		
		//Tests sur un vide a la base en 2 dimensions Classique
		videDim2.deplacer(1.0, 1.0, 1.0);
		assertEquals(1.0, videDim3.getX(), "Modifie juste le X");
		assertEquals(1.0, videDim3.getY(), "Modifie juste le Y");
		assertEquals(0.0, videDim3.getZ(), "On est en 2D, le Z doit pas bouger");
		videDim2.deplacerX(-1.0);
		assertEquals(0.0, videDim2.getX(), "Modifie juste le X");
		videDim2.deplacerY(+2.0);
		assertEquals(3.0, videDim2.getY(), "Modifie juste le Y");
		videDim2.deplacerZ(-1.0);
		assertEquals(0.0, videDim2.getZ(), "On est en 2D, le Z doit pas bouger");
	}
	
	@Test
	public void testRotate() {
		System.out.println(classique3d);
		classique3d.rotate(1, 1, 1);
		System.out.println(classique3d);
		Assertions.("TestUndefined. Explique moi ce qu'est censé faire Rotate Please");
	}

}
