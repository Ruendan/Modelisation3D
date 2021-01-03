package modele.modelisation;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import modele.parser.exception.PlyParserException;

class FigureTest {

	private Figure cube;
	
	@BeforeEach
	void initialise() {
		try {
			cube = new Figure("cube");
		} catch (PlyParserException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	void test_getCenter() {
		assertEquals(new Point(0,0,0),cube.getCenter());
	}
	
	@Test
	void test_getNbFaces() {
		assertEquals(6, cube.getNbFaces());
	}
	
	@Test
	void test_getName() {
		assertEquals("cube", cube.getName());
	}
	
	@Test
	void test_zoom() {
		int value = 1;
		checkZoom(value);
		value++;
		cube.zoom(value);
		checkZoom(value);
	}
	
	void checkZoom(int i) {
		for(Point p : cube.getPoints()){
			double x = p.getX();
			double y = p.getY();
			double z = p.getZ();
			
			if(x>0) assertEquals(i, x, 0.1);
			else assertEquals(-i, x, 0.1);
			if(y>0) assertEquals(i, y, 0.1);
			else assertEquals(-i, y, 0.1);
			if(z>0) assertEquals(i, z, 0.1);
			else assertEquals(-i, z, 0.1);
		}
	}
	
	@Test
	void test_HDeplacer() {
		cube.HDeplace(10);
		
		double moyenneAfter = 0;
		for(Point p : cube.getPoints()) {
			moyenneAfter+=p.getX();
		}
		System.out.println(cube.getNbPoint());
		assertEquals(10, moyenneAfter/cube.getNbPoint());
	}
	
	@Test
	void test_VDeplacer() {
		cube.VDeplace(10);
		
		double moyenneAfter = 0;
		for(Point p : cube.getPoints())
			moyenneAfter+=p.getY();
		
		assertEquals(10, moyenneAfter/cube.getNbPoint());
	}
	
	@Test
	void test_rotateAll() {

		
	}
	
	@Test
	void test_rotateX() {
	}
	
	@Test
	void test_rotateY() {
		
	}
	
	@Test
	void test_rotateZ() {
		
	}
	
	@Test
	void test_deplaceAll() {
		cube.deplace(10, 10, 10);

		double moyenneX=0;
		double moyenneY=0;
		double moyenneZ=0;
		
		for(Point p : cube.getPoints()) {
			moyenneX+=p.getX();
			moyenneY+=p.getY();
			moyenneZ+=p.getZ();
		}
		
		assertEquals(10, moyenneX/cube.getNbPoint());
		assertEquals(10, moyenneY/cube.getNbPoint());
		assertEquals(10, moyenneZ/cube.getNbPoint());
	}

}
