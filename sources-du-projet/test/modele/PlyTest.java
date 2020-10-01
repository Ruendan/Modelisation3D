package modele;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class PlyTest {

	private Ply tested;
	private List<Point> expectedPoints;
	private List<Face> expectedFaces;
	
	@BeforeEach
	public void initialize() {
		tested = new Ply();
		tested = PlyParser.loadPly("cube");
		
		expectedPoints = new ArrayList<Point>(); 
		expectedPoints.add(new Point(-1.0,-1.0,-1.0)); // -1 -1 -1
		expectedPoints.add(new Point( 1.0,-1.0,-1.0)); //  1 -1 -1
		expectedPoints.add(new Point( 1.0, 1.0,-1.0)); //  1  1 -1
		expectedPoints.add(new Point(-1.0, 1.0,-1.0)); // -1  1 -1
		expectedPoints.add(new Point(-1.0,-1.0, 1.0)); // -1 -1  1
		expectedPoints.add(new Point( 1.0,-1.0, 1.0)); //  1 -1  1
		expectedPoints.add(new Point( 1.0, 1.0, 1.0)); //  1  1  1
		expectedPoints.add(new Point(-1.0, 1.0, 1.0)); // -1  1  1
		
		expectedFaces = new ArrayList<Face>();
		expectedFaces.add(new Face(4, Arrays.asList(new Integer[]{0,1,2,3}))); // 4 0 1 2 3 
		expectedFaces.add(new Face(4, Arrays.asList(new Integer[]{5,4,7,6}))); // 4 5 4 7 6 
		expectedFaces.add(new Face(4, Arrays.asList(new Integer[]{6,2,1,5}))); // 4 6 2 1 5 
		expectedFaces.add(new Face(4, Arrays.asList(new Integer[]{3,7,4,0}))); // 4 3 7 4 0 
		expectedFaces.add(new Face(4, Arrays.asList(new Integer[]{7,3,2,6}))); // 4 7 3 2 6 
		expectedFaces.add(new Face(4, Arrays.asList(new Integer[]{5,1,0,4}))); // 4 5 1 0 4 
	}
	
	@Test
	public void test_list_points() {
		assertEquals(expectedPoints, tested.getPoints());
	}
	
	@Test
	public void test_list_faces() {
		assertEquals(expectedFaces, tested.getFaces());
	}

}
