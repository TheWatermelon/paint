/**
 * 
 */

/**
 * @author Coatan�a Brendan
 * @worker florian bonniec
 * @date 30/04/2013
 *
 */
package ca.uds.jfig.menu;

import javax.swing.JMenuItem;

import ca.uds.jfig.application.ApplicationController;

@SuppressWarnings("serial")
public class ToolZoom extends JMenuItem {
	
	private ApplicationController acontroller;

	public ToolZoom(ApplicationController acontroller) {
		this.acontroller = acontroller;
	}

	public void Plus() {
		acontroller.setScale(acontroller.getScale() + 1);
	}

	public void Moins() {
		acontroller.setScale(acontroller.getScale() - 1);
	}
	
	public void Normal() {
		acontroller.setScale(100.0);
	}


}
