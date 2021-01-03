package modele.parser;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import modele.modelisation.Face;
import modele.modelisation.Ply;
import modele.modelisation.Point;
import modele.parser.exception.PlyParserException;

class PlyParserTest {

	private Ply tested;
	private List<Point> expectedListPoints;
	private Set<Point> expectedSetPoints;
	
	private List<Face> expectedListFaces;
	
	@BeforeEach
	public void initialise() {
		try {
			tested = PlyParser.loadPly("cube");
		} catch (PlyParserException e) {
			e.printStackTrace();
		}
		
		expectedListPoints = Arrays.asList(new Point[] {
			new Point(-1.0,-1.0,-1.0),
			new Point( 1.0,-1.0,-1.0),
			new Point( 1.0, 1.0,-1.0),
			new Point(-1.0, 1.0,-1.0),
			new Point(-1.0,-1.0, 1.0),
			new Point( 1.0,-1.0, 1.0),
			new Point( 1.0, 1.0, 1.0),
			new Point(-1.0, 1.0, 1.0),
		});
		
		expectedSetPoints = new HashSet<Point>();
		expectedSetPoints.addAll(expectedListPoints);
		
		expectedListFaces = new ArrayList<Face>(Arrays.asList(new Face[] {
				new Face(4, Arrays.asList(new Point[] {expectedListPoints.get(0), expectedListPoints.get(1), expectedListPoints.get(2), expectedListPoints.get(3)})),
				new Face(4, Arrays.asList(new Point[] {expectedListPoints.get(5), expectedListPoints.get(4), expectedListPoints.get(7), expectedListPoints.get(6)})),
				new Face(4, Arrays.asList(new Point[] {expectedListPoints.get(6), expectedListPoints.get(2), expectedListPoints.get(1), expectedListPoints.get(5)})),
				new Face(4, Arrays.asList(new Point[] {expectedListPoints.get(3), expectedListPoints.get(7), expectedListPoints.get(4), expectedListPoints.get(0)})),
				new Face(4, Arrays.asList(new Point[] {expectedListPoints.get(7), expectedListPoints.get(3), expectedListPoints.get(2), expectedListPoints.get(6)})),
				new Face(4, Arrays.asList(new Point[] {expectedListPoints.get(5), expectedListPoints.get(1), expectedListPoints.get(0), expectedListPoints.get(4)}))
		}));
		//expected = new Ply(8, 6, expectedSetPoints, expectedListFaces);
		
	}
	
	@Test
	public void test_Initialisation() {
		assertEquals(8, tested.getVertex());
		assertEquals(6, tested.getNbFace());
		assertEquals(expectedSetPoints, tested.getPoints());
		assertEquals(expectedListFaces, tested.getFaces());
	}
	
	@Test
	public void test_Same_Points_on_Face_and_Figure() {
		
		assertTrue(tested.getPoints().contains(tested.getFaces().get(0).getPoints().get(0)));
		
		assertTrue(tested.getPoints().contains(tested.getFaces().get(1).getPoints().get(0)));
		
		assertTrue(tested.getPoints().contains(tested.getFaces().get(2).getPoints().get(1)));
		
		assertTrue(tested.getPoints().contains(tested.getFaces().get(3).getPoints().get(2)));
		
		assertTrue(tested.getPoints().contains(tested.getFaces().get(4).getPoints().get(3)));
		
		assertTrue(tested.getPoints().contains(tested.getFaces().get(5).getPoints().get(3)));
	}
	
	@Test
	public void test_Comments() {
		assertEquals(Arrays.asList(new String[] {"created by platoply"}), tested.getComment());
	}

}
