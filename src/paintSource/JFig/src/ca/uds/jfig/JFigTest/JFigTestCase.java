package ca.uds.jfig.JFigTest;


import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import ca.uds.jfig.application.Application;

public class JFigTestCase {
	 public JFigDriver JFigIU;

	    @Before
	    public void runTheApplication() {;
	       Application.main(null);
	       JFigIU = new JFigDriver();
	    }

	    @After
	    public void stopTheApplication() {
	    	JFigIU.dispose(); 
	    }
	    
	    @Test
		// This is just to know that tests can run
		public void simpleTest() {
			assertEquals("simpleTest", 1, 1);
		}
	    
}
