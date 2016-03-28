/**
 * 
 */

/**
 * @author Coatanea Brendan
 * @date 09/05/2013
 *
 */
package ca.uds.jfig.menu;

import ca.uds.jfig.application.ApplicationController;

@SuppressWarnings("serial")
public class ToolStroke08 extends ToolFig implements Command {

	private ToolStroke theToolStroke;
	ApplicationController acontroller;

	public ToolStroke08(ToolStroke ToolStroke, ApplicationController acontroller) {
		super(acontroller);
		theToolStroke = ToolStroke;
	}

	@Override
	public void execute() {
		theToolStroke.Stroke08();

	}

}
