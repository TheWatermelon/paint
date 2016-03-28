/**
 * 
 */

/**
 * @author Coatanea Brendan
 * @date 30/04/2013
 *
 */
package ca.uds.jfig.menu;

import ca.uds.jfig.application.ApplicationController;

@SuppressWarnings("serial")
public class ToolEditUndo extends ToolEdit implements Command {

	private ToolEdit theToolEdit;

	public ToolEditUndo(ToolEdit ToolEdit, ApplicationController acontroller) {
		super(acontroller);
		theToolEdit = ToolEdit;
	}

	public void execute() {
		theToolEdit.Undo();
	}
}