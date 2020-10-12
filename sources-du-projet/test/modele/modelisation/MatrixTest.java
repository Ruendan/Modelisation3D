package modele.modelisation;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MatrixTest {

	private Point centre;
	private Point classique;
	
	@BeforeEach
	public void initialize() {
		centre = new Point(0, 0, 0);
		classique = new Point(4, 5, 6);
	}
	
	
	
	/*
	 * BATTERIE DE TESTS DE CALCULMATRICE
	 */
	@Test
	public void test_point_centre_calculMatrice() {
		fail("Pas encore implementé FAUT VRAIMENT QU'ON EN PARLE LUCAS");
	}
	
	@Test
	public void test_point_classique_calculMatrice() {
		fail("Pas encore implementé FAUT VRAIMENT QU'ON EN PARLE LUCAS");
	}
	
	
	
	/*
	 * BATTERIE DE TESTS DE TRANSFORMATION
	 */
	
	@Test
	public void test_point_centre_transformation() {
		fail("Pas encore implementé FAUT VRAIMENT QU'ON EN PARLE LUCAS");
	}
	
	@Test
	public void test_point_classique_transformation() {
		fail("Pas encore implementé FAUT VRAIMENT QU'ON EN PARLE LUCAS");
	}
	
	
	
	/*
	 * BATTERIE DE TESTS DE ROTATEX/Y/Z
	 */
	
	@Test
	public void test_point_centre_rotateX() {
		//System.out.println(Matrix.rotateX(centre, 2));
		//System.out.println(Matrix.rotateX(Matrix.rotateX(centre, 2), -1));
		//C'est censé etre un void
		Matrix.rotateY(centre, 2);
		assertEquals(0, centre.getX(), 0.01);
		assertEquals(0, centre.getY(), 0.01);
		assertEquals(0, centre.getZ(), 0.01);

		Matrix.rotateY(centre, -1);
		assertEquals(0, centre.getX(), 0.01);
		assertEquals(0, centre.getY(), 0.01);
		assertEquals(0, centre.getZ(), 0.01);
	}
	
	@Test
	public void test_point_classique_rotateX() {
		//System.out.println(Matrix.rotateX(classique, 2));
		//System.out.println(Matrix.rotateX(Matrix.rotateX(classique, 2), -1));
		//C'est censé etre un void
		Matrix.rotateX(classique, 2);
		assertEquals(4.0, classique.getX(), 0.01);
		assertEquals(4.78, classique.getY(), 0.01);
		assertEquals(6.17, classique.getZ(), 0.01);

		Matrix.rotateX(classique, -1);
		assertEquals(4.00, classique.getX(), 0.01);
		assertEquals(4.89, classique.getY(), 0.01);
		assertEquals(6.08, classique.getZ(), 0.01);
	}
	
	@Test
	public void test_point_centre_rotateY() {
		//System.out.println(Matrix.rotateY(centre, 2));
		//System.out.println(Matrix.rotateY(Matrix.rotateY(centre, 2), -1));
		//C'est censé etre un void
		Matrix.rotateY(centre, 2);
		assertEquals(0.0, centre.getX(), 0.01);
		assertEquals(0.0, centre.getY(), 0.01);
		assertEquals(0.0, centre.getZ(), 0.01);

		Matrix.rotateY(centre, -1);
		assertEquals(0.0, centre.getX(), 0.01);
		assertEquals(0.0, centre.getY(), 0.01);
		assertEquals(0.0, centre.getZ(), 0.01);
	}
	
	@Test
	public void test_point_classique_rotateY() {
		//System.out.println(Matrix.rotateY(classique, 2));
		//System.out.println(Matrix.rotateY(Matrix.rotateY(classique, 2), -1));
		//C'est censé etre un void
		Matrix.rotateY(classique, 2);
		assertEquals(3.78, classique.getX(), 0.01);
		assertEquals(5.0, classique.getY(), 0.01);
		assertEquals(6.13, classique.getZ(), 0.01);

		Matrix.rotateY(classique, -1);
		assertEquals(3.89, classique.getX(), 0.01);
		assertEquals(5.0, classique.getY(), 0.01);
		assertEquals(6.06, classique.getZ(), 0.01);
	}
	
	@Test
	public void test_point_centre_rotateZ() {
		//System.out.println(Matrix.rotateY(centre, 2));
		//System.out.println(Matrix.rotateY(Matrix.rotateY(centre, 2), -1));
		//C'est censé etre un void
		Matrix.rotateY(centre, 2);
		assertEquals(0, centre.getX(), 0.01);
		assertEquals(0, centre.getY(), 0.01);
		assertEquals(0, centre.getZ(), 0.01);

		Matrix.rotateY(centre, -1);
		assertEquals(0, centre.getX(), 0.01);
		assertEquals(0, centre.getY(), 0.01);
		assertEquals(0, centre.getZ(), 0.01);
	}	
	
	@Test
	public void test_point_classique_rotateZ() {
		//System.out.println(Matrix.rotateZ(classique, 2));
		//System.out.println(Matrix.rotateZ(Matrix.rotateZ(classique, 2), -1));
		//C'est censé etre un void
		Matrix.rotateZ(classique, 2);
		assertEquals(3.82, classique.getX(), 0.01);
		assertEquals(5.13, classique.getY(), 0.01);
		assertEquals(6.0, classique.getZ(), 0.01);

		Matrix.rotateZ(classique, -1);
		assertEquals(3.91, classique.getX(), 0.01);
		assertEquals(5.06, classique.getY(), 0.01);
		assertEquals(6.0, classique.getZ(), 0.01);
	}	

}
