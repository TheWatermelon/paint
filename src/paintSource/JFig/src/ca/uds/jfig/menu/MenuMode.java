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
import java.util.Observable;
import java.util.Observer;

import javax.swing.ButtonGroup;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

import ca.uds.jfig.application.ApplicationController;
import ca.uds.jfig.application.ApplicationModel;
import ca.uds.jfig.jfigInterface.ModeInterface;

public class MenuMode implements ActionListener, ModeInterface, Observer {

	private ApplicationController acontroller;
	private ApplicationModel amodel;
	private ButtonGroup group;
	private ToolMode ToolMode;
	private ToolModeDraw toolDraw;
	private ToolModeSelection toolSelect;
	private ToolModeMove toolMove;
	private ToolModeTranslation toolTranslate;
	private ToolModeRotation toolRotate;
	private ToolModeText toolText;

	public MenuMode(ApplicationController acontroller) {
		this.acontroller = acontroller;
		amodel=acontroller.getModel();
		amodel.addObserver(this);
	}

	public JMenu createMenuMode(JMenuBar menuBar) {

		group = new ButtonGroup();
		ToolMode = new ToolMode(acontroller);
		toolDraw = new ToolModeDraw(ToolMode, acontroller);
		toolSelect = new ToolModeSelection(ToolMode,
				acontroller);
		toolMove = new ToolModeMove(ToolMode, acontroller);
		toolTranslate = new ToolModeTranslation(ToolMode,
				acontroller);
		toolRotate = new ToolModeRotation(ToolMode,
				acontroller);
		toolText = new ToolModeText(ToolMode, acontroller);
		
		JMenu fileMenu = new JMenu("Mode");
		ToolMode.setSelected(true);
		toolDraw.setText(DRAW_STR);
		toolSelect.setText(SELECT_STR);
		toolMove.setText(MOVE_STR);
		toolTranslate.setText(TRANSLATE_STR);
		toolRotate.setText(ROTATE_STR);
		toolText.setText(TEXT_STR);
		toolDraw.addActionListener(this);
		toolSelect.addActionListener(this);
		toolMove.addActionListener(this);
		toolTranslate.addActionListener(this);
		toolRotate.addActionListener(this);
		toolText.addActionListener(this);
		group.add(toolDraw);
		group.add(toolSelect);
		group.add(toolMove);
		group.add(toolTranslate);
		group.add(toolRotate);
		group.add(toolText);
		fileMenu.add(toolDraw);
		fileMenu.add(toolSelect);
		fileMenu.add(toolMove);
		fileMenu.add(toolTranslate);
		fileMenu.add(toolRotate);
		fileMenu.add(toolText);
		menuBar.add(fileMenu);

		return fileMenu;
	}

	public void actionPerformed(ActionEvent e) {
		Command command = (Command) e.getSource();
		command.execute();
	}

	@Override
	public void update(Observable o, Object arg) {
		switch (amodel.getMode()) {
		case DRAW:
			group.clearSelection();
			group.setSelected(toolDraw, true);
			break;
		case MOVE: 
			group.clearSelection();
			group.setSelected(toolMove, true);
			break;
		case SELECT: 
			group.clearSelection();
			group.setSelected(toolSelect, true);
			break;
		case ROTATE: 
			group.clearSelection();
			group.setSelected(toolRotate, true);
			break;
		case TRANSLATE: 
			group.clearSelection();
			group.setSelected(toolTranslate, true);
			break;
		case TEXT: 
			group.clearSelection();
			group.setSelected(toolText, true);
			break;
		}
	}
}
