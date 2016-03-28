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
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.KeyStroke;

import ca.uds.jfig.application.ApplicationController;

public class MenuEdit implements ActionListener {

	private ApplicationController acontroller;

	public MenuEdit(ApplicationController acontroller) {
		this.acontroller = acontroller;
	}

	public JMenu createMenuEdit(JMenuBar menuBar) {

		ToolEdit ToolEdit = new ToolEdit(acontroller);
		ToolEditUndo toolUndo = new ToolEditUndo(ToolEdit, acontroller);
		ToolEditRedo toolRedo = new ToolEditRedo(ToolEdit, acontroller);

		JMenu EditMenu = new JMenu("Edit");
		toolUndo.setText("Undo");
		toolRedo.setText("Redo");

		toolUndo.addActionListener(this);
		toolRedo.addActionListener(this);

		EditMenu.add(toolUndo);
		EditMenu.add(toolRedo);

		menuBar.add(EditMenu);

		toolUndo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z,
				InputEvent.CTRL_DOWN_MASK));
		toolRedo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Y,
				InputEvent.CTRL_DOWN_MASK));

		return EditMenu;
	}

	public void actionPerformed(ActionEvent e) {
		Command command = (Command) e.getSource();
		command.execute();
	}

}
