/**
 * 
 */

/**
 * @author Coatanea Brendan
 * @worker Nolwenn ROGER
 * @date 30/04/2013
 *
 */
package ca.uds.jfig.menu;

import javax.swing.JMenuItem;

import ca.uds.jfig.application.ApplicationController;
import ca.uds.jfig.jfigInterface.FigureInterface;

@SuppressWarnings("serial")
public class ToolFig extends JMenuItem implements FigureInterface{
	ApplicationController acontroller;

	public ToolFig(ApplicationController acontroller) {
		this.acontroller = acontroller;
	}

	public void Rectangle() {
		acontroller.setType(RECTANGLE);
	}

	public void Oval() {
		acontroller.setType(OVAL);
	}

	public void Line() {
		acontroller.setType(LINE);;
	}

	public void Circle() {
		acontroller.setType(CIRCLE);
	}
	
	public void CurvedRectangle() {
		acontroller.setType(ROUNDRECTANGLE);
	}

}


