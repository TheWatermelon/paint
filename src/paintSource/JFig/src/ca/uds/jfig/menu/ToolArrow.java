/**
 * @author Coatanea Brendan
 * @worker Nolwenn ROGER
 * @date 30/04/2013
 *
 */
package ca.uds.jfig.menu;
import javax.swing.JMenuItem;
import ca.uds.jfig.application.ApplicationController;
import ca.uds.jfig.jfigInterface.ArrowInterface;

@SuppressWarnings("serial")
public class ToolArrow extends JMenuItem implements ArrowInterface{
	ApplicationController acontroller;

	public ToolArrow(ApplicationController acontroller) {
		this.acontroller = acontroller;
	}

	public void Simple() {
		acontroller.setType(ARROW);
	}

	public void Double() {
		acontroller.setType(ARROWDOUBLE);
	}

	public void SimpleF() {
		acontroller.setType(ARROWFILL);
	}

	public void DoubleF() {
		acontroller.setType(ARROWFILLDOUBLE);
	}

}
