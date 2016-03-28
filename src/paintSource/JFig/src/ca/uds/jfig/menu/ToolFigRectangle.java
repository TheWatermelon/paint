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
public class ToolFigRectangle extends ToolFig implements Command {

	private ToolFig theToolFig;
	ApplicationController acontroller;

	public ToolFigRectangle(ToolFig ToolFig, ApplicationController acontroller) {
		super(acontroller);
		theToolFig = ToolFig;
	}

	public void execute() {
		theToolFig.Rectangle();
	}
}
