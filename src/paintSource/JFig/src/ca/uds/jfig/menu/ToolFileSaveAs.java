
/**
 * @author Roger Nolwenn
 *
 */
package ca.uds.jfig.menu;

import ca.uds.jfig.application.ApplicationController;

@SuppressWarnings("serial")
public class ToolFileSaveAs extends ToolFile implements Command {

	private ToolFile theToolFile;

	public ToolFileSaveAs(ToolFile ToolFile, ApplicationController acontroller) {
		super(acontroller);
		theToolFile = ToolFile;
	}

	public void execute() {
		theToolFile.SaveAs();
	}
}