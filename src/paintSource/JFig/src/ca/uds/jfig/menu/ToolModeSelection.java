/**
 * 
 */

/**
 * @author Coatanea Brendan
 * @date 30/04/2013
 *
 */
package ca.uds.jfig.menu;

import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;

import ca.uds.jfig.application.ApplicationController;

@SuppressWarnings("serial")
public class ToolModeSelection extends ToolMode implements Command, ButtonModel {

	private ToolMode theToolMode;

	public ToolModeSelection(ToolMode Toolmode,
			ApplicationController acontroller) {
		super(acontroller);
		theToolMode = Toolmode;
	}

	public void execute() {
		theToolMode.Select();
	}

	@Override
	public boolean isPressed() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isRollover() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setGroup(ButtonGroup group) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setPressed(boolean b) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setRollover(boolean b) {
		// TODO Auto-generated method stub
		
	}
}