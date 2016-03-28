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
public class ToolFileSave extends ToolFile implements Command {

	private ToolFile theToolFile;

	public ToolFileSave(ToolFile ToolFile, ApplicationController acontroller) {
		super(acontroller);
		theToolFile = ToolFile;
	}

	public void execute() {
		theToolFile.Save();
	}
}