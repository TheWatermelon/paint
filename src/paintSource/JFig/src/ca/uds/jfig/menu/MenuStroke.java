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
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.KeyStroke;

import ca.uds.jfig.application.ApplicationController;

public class MenuStroke implements ActionListener {
	ApplicationController acontroller;

	public JMenu createMenuStroke(JMenuBar menuBar,
			ApplicationController acontroller) {

		this.acontroller = acontroller;
		ClassLoader classLoader = getClass().getClassLoader();

		ToolStroke ToolStroke = new ToolStroke(acontroller);
		ToolStroke01 tool01 = new ToolStroke01(ToolStroke, acontroller);
		ToolStroke03 tool03 = new ToolStroke03(ToolStroke, acontroller);
		ToolStroke05 tool05 = new ToolStroke05(ToolStroke, acontroller);
		ToolStroke08 tool08 = new ToolStroke08(ToolStroke, acontroller);

		JMenu StrokeMenu = new JMenu("Stroke");
		URL two = classLoader.getResource("ca/uds/jfig/application/images/02.jpg");
		tool01.setIcon(new ImageIcon(two));
		tool01.addActionListener(this);
		URL three = classLoader.getResource("ca/uds/jfig/application/images/03.jpg");
		tool03.setIcon(new ImageIcon(three));
		tool03.addActionListener(this);
		URL five = classLoader.getResource("ca/uds/jfig/application/images/05.jpg");
		tool05.setIcon(new ImageIcon(five));
		tool05.addActionListener(this);
		URL eight = classLoader.getResource("ca/uds/jfig/application/images/08.jpg");
		tool08.setIcon(new ImageIcon(eight));
		tool08.addActionListener(this);
		StrokeMenu.add(tool01);
		StrokeMenu.add(tool03);
		StrokeMenu.add(tool05);
		StrokeMenu.add(tool08);

		tool01.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1,
				InputEvent.SHIFT_DOWN_MASK));
		tool03.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F2,
				InputEvent.SHIFT_DOWN_MASK));
		tool05.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F3,
				InputEvent.SHIFT_DOWN_MASK));
		tool08.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4,
				InputEvent.SHIFT_DOWN_MASK));

		return StrokeMenu;

	}

	public void actionPerformed(ActionEvent e) {
		Command command = (Command) e.getSource();
		command.execute();
	}
}