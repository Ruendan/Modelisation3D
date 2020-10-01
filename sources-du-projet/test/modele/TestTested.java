package modele;

import static org.junit.Assert.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestTested {
	
	Tested t;
	
	@BeforeEach
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
	
	@AfterEach
	public void finish() {
		t=null;
	}

}
