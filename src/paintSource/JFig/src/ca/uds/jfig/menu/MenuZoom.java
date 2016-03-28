/**
 * 
 */

/**
 * @author Coatanea Brendan
 * @date 30/04/2013
 *
 */
package ca.uds.jfig.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

import ca.uds.jfig.application.ApplicationController;

public class MenuZoom implements ActionListener {

	private ApplicationController acontroller;

	public MenuZoom(ApplicationController acontroller) {
		this.acontroller = acontroller;
	}

	public JMenu createMenuZoom(JMenuBar menuBar) {

		ToolZoom ToolZoom = new ToolZoom(acontroller);
		ToolZoomPlus toolPlus = new ToolZoomPlus(ToolZoom, acontroller);
		ToolZoomMoins toolMoins = new ToolZoomMoins(ToolZoom, acontroller);
		ToolZoomNormal toolNormal = new ToolZoomNormal(ToolZoom, acontroller);

		JMenu ZoomMenu = new JMenu("Zoom");
		toolPlus.setText("Zoom +");
		toolMoins.setText("Zoom -");
		toolNormal.setText("Normal size");

		toolPlus.addActionListener(this);
		toolMoins.addActionListener(this);
		toolNormal.addActionListener(this);

		ZoomMenu.add(toolPlus);
		ZoomMenu.add(toolMoins);
		ZoomMenu.add(toolNormal);

		menuBar.add(ZoomMenu);
		return ZoomMenu;
	}

	public void actionPerformed(ActionEvent e) {
		Command command = (Command) e.getSource();
		command.execute();
	}

}
