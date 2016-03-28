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
public class ToolEditRedo extends ToolEdit implements Command {

	private ToolEdit theToolEdit;

	public ToolEditRedo(ToolEdit ToolEdit, ApplicationController acontroller) {
		super(acontroller);
		theToolEdit = ToolEdit;
	}

	public void execute() {
		theToolEdit.Redo();
	}
}