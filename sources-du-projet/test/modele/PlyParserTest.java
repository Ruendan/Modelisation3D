package modele;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import modele.parser.PlyParser;

class PlyParserTest {

	private Ply tested;
	
	@BeforeEach
	public void initialise() {
		tested = PlyParser.loadPly("cube");
	}
	
	@Test
	void test() {
		assertSame(tested.getFaces().get(0).getPoints().get(0), tested.getPoints().get(0));
		tested.getFaces().get(0).getPoints().get(0).rotate(45, 54, 30);
		assertEquals(tested.getFaces().get(0).getPoints().get(0), tested.getPoints().get(0));
	}

}
