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

public class MenuFile implements ActionListener {

	private ApplicationController acontroller;

	public MenuFile(ApplicationController acontroller) {
		this.acontroller = acontroller;
	}

	public JMenu createMenuFile(JMenuBar menuBar) {

		ToolFile ToolFile = new ToolFile(acontroller);
		ToolFileNew toolNew = new ToolFileNew(ToolFile, acontroller);
		ToolFileOpen toolOpen = new ToolFileOpen(ToolFile, acontroller);
		ToolFileSave toolSave = new ToolFileSave(ToolFile, acontroller);
		ToolFileSaveAs toolSaveAs = new ToolFileSaveAs(ToolFile, acontroller);
		ToolFileExit toolExit = new ToolFileExit(ToolFile, acontroller);

		JMenu fileMenu = new JMenu("File");
		toolNew.setText("New");
		toolOpen.setText("Open");
		toolSave.setText("Save");
		toolSaveAs.setText("Save As");
		toolExit.setText("Exit");
		toolNew.addActionListener(this);
		toolOpen.addActionListener(this);
		toolSave.addActionListener(this);
		toolSaveAs.addActionListener(this);
		toolExit.addActionListener(this);
		fileMenu.add(toolNew);
		fileMenu.add(toolOpen);
		fileMenu.add(toolSave);
		fileMenu.add(toolSaveAs);
		fileMenu.add(toolExit);
		menuBar.add(fileMenu);

		toolNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,
				InputEvent.CTRL_DOWN_MASK));
		toolOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,
				InputEvent.CTRL_DOWN_MASK));
		toolSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,
				InputEvent.CTRL_DOWN_MASK));
		toolSaveAs.setAccelerator(KeyStroke.getKeyStroke("control alt S"));
		toolExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q,
				InputEvent.CTRL_DOWN_MASK));

		return fileMenu;
	}

	public void actionPerformed(ActionEvent e) {
		Command command = (Command) e.getSource();
		command.execute();
	}

}
