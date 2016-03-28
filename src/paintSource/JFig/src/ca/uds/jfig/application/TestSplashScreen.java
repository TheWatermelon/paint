package ca.uds.jfig.application;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestSplashScreen {

	
	
	
	@Test
	// This is just to know that tests can run
	public void simpleTest() {
		assertEquals("simpleTest", 1, 1);
	}
	
	/**
	 * @param args
	 */
	@Test
	public void splashTest() {
		SplashScreen splash = new SplashScreen(3000);
		assertEquals("splashTest", true, splash.isAlive());
		splash.dispose();
	}
	
	



}
