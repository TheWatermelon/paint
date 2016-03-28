/**
 * 
 */

/**
 * @author Coatanea Brendan
 * @worker florian bonniec
 * @date 30/04/2013
 *
 */
package ca.uds.jfig.menu;

import java.io.IOException;

import javax.swing.JMenuItem;

import ca.uds.jfig.application.ApplicationController;

@SuppressWarnings("serial")
public class ToolFile extends JMenuItem {

	private ApplicationController acontroller;

	public ToolFile(ApplicationController acontroller) {
		this.acontroller = acontroller;
	}

	public void Open() {
		try {
			acontroller.openFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void Save() {
		acontroller.saveFile();
	}
	
	public void SaveAs() {
		acontroller.saveAsFile();
	}

	public void Exit() {
		ConfirmClose closed = new ConfirmClose(acontroller);
		closed.close();
	}

	public void New() {
		ConfirmClose closed = new ConfirmClose(acontroller);
		closed.newFile();
	}

}
