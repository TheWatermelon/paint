
/**
 * @author Nolwenn ROGER
 * @date 09/05/2013
 *
 */
package ca.uds.jfig.menu;

import ca.uds.jfig.application.ApplicationController;

@SuppressWarnings("serial")
public class ToolFigCircle extends ToolFig implements Command {

	private ToolFig theToolFig;
	ApplicationController acontroller;

	public ToolFigCircle(ToolFig ToolFig,ApplicationController acontroller) {
		super(acontroller);
		theToolFig = ToolFig;
	}

	public void execute() {
		theToolFig.Circle();
	}
}