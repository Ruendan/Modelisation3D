package modele;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.params.ParameterizedTest;

import modele.parser.PlyParser;

class PlyParserTest {

	private Ply tested;
	private Ply expected;
	private List<Point> expectedListPoints;
	private List<Face> expectedListFaces;
	
	@BeforeEach
	public void initialise() {
		tested = PlyParser.loadPly("cube");
		
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
		expectedListFaces = new ArrayList<Face>(Arrays.asList(new Face[] {
				new Face(4, Arrays.asList(new Point[] {expectedListPoints.get(0), expectedListPoints.get(1), expectedListPoints.get(2), expectedListPoints.get(3)})),
				new Face(4, Arrays.asList(new Point[] {expectedListPoints.get(5), expectedListPoints.get(4), expectedListPoints.get(7), expectedListPoints.get(6)})),
				new Face(4, Arrays.asList(new Point[] {expectedListPoints.get(6), expectedListPoints.get(2), expectedListPoints.get(1), expectedListPoints.get(5)})),
				new Face(4, Arrays.asList(new Point[] {expectedListPoints.get(3), expectedListPoints.get(7), expectedListPoints.get(4), expectedListPoints.get(0)})),
				new Face(4, Arrays.asList(new Point[] {expectedListPoints.get(7), expectedListPoints.get(3), expectedListPoints.get(2), expectedListPoints.get(6)})),
				new Face(4, Arrays.asList(new Point[] {expectedListPoints.get(5), expectedListPoints.get(1), expectedListPoints.get(0), expectedListPoints.get(4)}))
		}));
		expected = new Ply(8, 6, expectedListPoints, expectedListFaces);
		
	}
	
	@Test
	public void test_Initialisation() {
		assertEquals(8, tested.getVertex());
		assertEquals(6, tested.getNbFace());
		assertEquals(expectedListPoints, tested.getPoints());
		assertEquals(expectedListFaces, tested.getFaces());
	}
	
	@Test
	public void test_Same_Points_on_Face_and_Figure() {
		assertSame(tested.getFaces().get(0).getPoints().get(0), tested.getPoints().get(0));
		assertSame(tested.getFaces().get(1).getPoints().get(0), tested.getPoints().get(5));
		assertSame(tested.getFaces().get(2).getPoints().get(1), tested.getPoints().get(2));
		assertSame(tested.getFaces().get(3).getPoints().get(2), tested.getPoints().get(4));
		assertSame(tested.getFaces().get(4).getPoints().get(3), tested.getPoints().get(6));
		assertSame(tested.getFaces().get(5).getPoints().get(3), tested.getPoints().get(4));
	}
	
	@Test
	public void test_Comments() {
		assertEquals(Arrays.asList(new String[] {"created by platoply"}), tested.getComment());
	}

}
