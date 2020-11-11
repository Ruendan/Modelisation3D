package modele.modelisation;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import modele.parser.PlyParser;
import modele.parser.exception.PlyParserException;


public class PlyTest {

	private Ply tested;
	private List<Point> expectedPoints;
	private List<Face> expectedFaces;
	
	@BeforeEach
	public void initialize() {
		tested = new Ply();
		try {
			tested = PlyParser.loadPly("cube");
		} catch (PlyParserException e) {
			e.printStackTrace();
		}
		
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
		expectedFaces.add(new Face(4, Arrays.asList(new Point[]{// 4 0 1 2 3 
				expectedPoints.get(0),
				expectedPoints.get(1),
				expectedPoints.get(2),
				expectedPoints.get(3)}))); 
		
		expectedFaces.add(new Face(4, Arrays.asList(new Point[]{ // 4 5 4 7 6 
				expectedPoints.get(5),
				expectedPoints.get(4),
				expectedPoints.get(7),
				expectedPoints.get(6)})));
		
		expectedFaces.add(new Face(4, Arrays.asList(new Point[]{ // 4 6 2 1 5
				expectedPoints.get(6),
				expectedPoints.get(2),
				expectedPoints.get(1),
				expectedPoints.get(5)})));
		
		expectedFaces.add(new Face(4, Arrays.asList(new Point[]{ // 4 3 7 4 0 
				expectedPoints.get(3),
				expectedPoints.get(7),
				expectedPoints.get(4),
				expectedPoints.get(0)})));
		
		expectedFaces.add(new Face(4, Arrays.asList(new Point[]{ // 4 7 3 2 6 
				expectedPoints.get(7),
				expectedPoints.get(3),
				expectedPoints.get(2),
				expectedPoints.get(6)})));
		
		expectedFaces.add(new Face(4, Arrays.asList(new Point[]{ // 4 5 1 0 4 
				expectedPoints.get(5),
				expectedPoints.get(1),
				expectedPoints.get(0),
				expectedPoints.get(4)})));
	}
	
	@Test
	public void test_list_points() {
		assertEquals(8, tested.getVertex());
		for(Point p : tested.getPoints()) assertTrue(expectedPoints.contains(p));
	}
	
	@Test
	public void test_get_faces() {
		assertEquals(6, tested.getNbFace());
		assertEquals(expectedFaces, tested.getFaces());
	}
	
	@Test
	public void test_getName() {
		assertEquals("cube", tested.getName());
	}

}
