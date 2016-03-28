/**
 * @author Coatanea Brendan
 * @date 8/05/2013
 *
 */

package ca.uds.jfig.menu;

import ca.uds.jfig.application.ApplicationController;

@SuppressWarnings("serial")
public class ToolArrowSimple extends ToolArrow implements Command {

	private ToolArrow theToolArrow;
	ApplicationController acontroller;

	public ToolArrowSimple(ToolArrow ToolArrow,
			ApplicationController acontroller) {
		super(acontroller);
		theToolArrow = ToolArrow;
	}

	public void execute() {
		theToolArrow.Simple();
	}
}
