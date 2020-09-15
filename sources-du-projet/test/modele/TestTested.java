package modele;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestTested {
	
	Tested t;
	
	@Before
	public void initialize() {
		t = new Tested();
	}

	@Test
	public void testTest() {
		assertFalse(t==null);
	}

	@Test
	public void testStart() {
		assertFalse(t.isRunning());
		t.start();
		assertTrue(t.isRunning());
	}

	@Test
	public void testStop() {
		t.start();
		assertTrue(t.isRunning());
		t.stop();
		assertFalse(t.isRunning());
	}

	@Test
	public void testIsRunning() {
		t.start();
		assertTrue(t.isRunning());
		t.stop();
		assertFalse(t.isRunning());
	}
	
	@After
	public void finish() {
		t=null;
	}

}
