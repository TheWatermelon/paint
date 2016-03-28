/**
 * 
 */

/**
 * @author Coatanea Brendan
 * @date 09/05/2013
 *
 */
package ca.uds.jfig.menu;

import javax.swing.JMenuItem;

import ca.uds.jfig.application.ApplicationController;

@SuppressWarnings("serial")
public class ToolStroke extends JMenuItem {

	ApplicationController acontroller;

	public ToolStroke(ApplicationController acontroller) {
		this.acontroller = acontroller;
	}

	public void Stroke01() {
		acontroller.setStroke(1);
	}

	public void Stroke03() {
		acontroller.setStroke(3);
	}

	public void Stroke05() {
		acontroller.setStroke(5);
	}

	public void Stroke08() {
		acontroller.setStroke(8);
	}

}
