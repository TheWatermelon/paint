/**
 * @author Nolwenn ROGER
 * @date 8/05/2013
 *
 */

package ca.uds.jfig.menu;
import ca.uds.jfig.application.ApplicationController;

@SuppressWarnings("serial")
public class ToolFigLine extends ToolFig implements Command {


	private ToolFig theToolFig;
	ApplicationController acontroller;

	public ToolFigLine(ToolFig ToolFig,ApplicationController acontroller) {
		super(acontroller);
		theToolFig = ToolFig;
	}
	public void execute() {
		theToolFig.Line();
	}
}


