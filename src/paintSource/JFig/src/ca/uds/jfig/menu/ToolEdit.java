/**
 * 
 */

/**
 * @author Coatanea Brendan
 * @worker florian bonniec
 * @date 30/04/2013
 *
 */
package ca.uds.jfig.menu;

import javax.swing.JMenuItem;

import ca.uds.jfig.application.ApplicationController;

@SuppressWarnings("serial")
public class ToolEdit extends JMenuItem {

	private ApplicationController acontroller;
	
	public ToolEdit(ApplicationController acontroller) {
		this.acontroller = acontroller;
	}

	public void Undo() {
		acontroller.undo();
	}

	public void Redo() {
		acontroller.redo();
	}

}
