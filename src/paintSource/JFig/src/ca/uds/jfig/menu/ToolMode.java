/**
 * 
 */

/**
 * @author Coatanea Brendan
 * @date 30/04/2013
 *
 */
package ca.uds.jfig.menu;

import javax.swing.JRadioButtonMenuItem;

import ca.uds.jfig.application.ApplicationController;
import ca.uds.jfig.jfigInterface.ModeInterface;

@SuppressWarnings("serial")
public class ToolMode extends JRadioButtonMenuItem implements ModeInterface {

	private ApplicationController acontroller;

	public ToolMode(ApplicationController acontroller) {
		this.acontroller = acontroller;
	}

	public void Draw() {
		acontroller.setMode(DRAW);//"draw");

	}

	public void Select() {
		acontroller.setMode(SELECT);//"select");
	}

	public void Move() {
		acontroller.setMode(MOVE); //"move");
	}

	public void Translate() {
		acontroller.setMode(TRANSLATE); //"translate");
	}

	public void Rotate() {
		acontroller.setMode(ROTATE);//"rotate");
	}
	
	public void Text() {
		acontroller.setMode(TEXT);//"Text");
	}

}
