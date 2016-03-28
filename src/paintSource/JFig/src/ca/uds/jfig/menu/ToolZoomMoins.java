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
public class ToolZoomMoins extends ToolZoom implements Command {

	private ToolZoom theToolZoom;

	public ToolZoomMoins(ToolZoom ToolZoom, ApplicationController acontroller) {
		super(acontroller);
		theToolZoom = ToolZoom;
	}

	public void execute() {
		theToolZoom.Moins();
	}
}