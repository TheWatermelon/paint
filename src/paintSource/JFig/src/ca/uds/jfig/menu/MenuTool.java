/**
 * 
 */

/**
 * @author Coatanea Brendan
 * @date 30/04/2013
 *@worker gael rochard, Nolwenn ROGER
 */
package ca.uds.jfig.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.KeyStroke;

import ca.uds.jfig.application.ApplicationController;

public class MenuTool implements ActionListener {
	ApplicationController acontroller;

	public JMenu createMenuTool(JMenuBar menuBar,
			ApplicationController acontroller) {

		this.acontroller = acontroller;
		ClassLoader classLoader = getClass().getClassLoader();

		ToolFig ToolFig = new ToolFig(acontroller);
		ToolFigRectangle toolRectangle = new ToolFigRectangle(ToolFig,
				acontroller);
		ToolFigCurvedRectangle toolCurvedRectangle = new ToolFigCurvedRectangle(ToolFig,
				acontroller);
		ToolFigOval toolOval = new ToolFigOval(ToolFig, acontroller);
		ToolFigCircle toolCircle = new ToolFigCircle(ToolFig, acontroller);
		ToolFigLine toolLine = new ToolFigLine(ToolFig, acontroller);

		JMenu toolMenu = new JMenu("Tool");
		toolRectangle.setText("Rectangle");
		URL rect = classLoader.getResource("ca/uds/jfig/application/images/rect.png");
		toolRectangle.setIcon(new ImageIcon(rect));
		toolCurvedRectangle.setText("Curved rectangle");
		URL curved = classLoader.getResource("ca/uds/jfig/application/images/curved.png");
		toolCurvedRectangle.setIcon(new ImageIcon(curved));
		toolOval.setText("Oval");
		URL oval = classLoader.getResource("ca/uds/jfig/application/images/oval.png");
		toolOval.setIcon(new ImageIcon(oval));
		toolCircle.setText("Circle");
		URL circle = classLoader.getResource("ca/uds/jfig/application/images/circle.png");
		toolCircle.setIcon(new ImageIcon(circle));
		toolLine.setText("Line");
		URL line = classLoader.getResource("ca/uds/jfig/application/images/line.png");
		toolLine.setIcon(new ImageIcon(line));
		toolRectangle.addActionListener(this);
		toolCurvedRectangle.addActionListener(this);
		toolOval.addActionListener(this);
		toolCircle.addActionListener(this);
		toolLine.addActionListener(this);
		toolMenu.add(toolRectangle);
		toolMenu.add(toolCurvedRectangle);
		toolMenu.add(toolOval);
		toolMenu.add(toolCircle);
		toolMenu.add(toolLine);
		menuBar.add(toolMenu);

		toolRectangle.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R,
				InputEvent.ALT_DOWN_MASK));
		toolCurvedRectangle.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,
				InputEvent.ALT_DOWN_MASK));
		toolOval.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,
				InputEvent.ALT_DOWN_MASK));
		toolCircle.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,
				InputEvent.ALT_DOWN_MASK));
		toolLine.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L,
				InputEvent.ALT_DOWN_MASK));

		return toolMenu;

	}

	public void actionPerformed(ActionEvent e) {
		Command command = (Command) e.getSource();
		command.execute();
	}
}
