/**
 * 
 */

/**
 * @author Coatanea Brendan
 * @date 30/04/2013
 */
package ca.uds.jfig.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import ca.uds.jfig.application.ApplicationController;


public class MenuArrow implements ActionListener {
	ApplicationController acontroller;
	public static ToolArrowSimple toolArrS;
	public static ToolArrowDouble toolArrD;
	public static ToolArrowSimpleF toolArrSF;
	public static ToolArrowDoubleF toolArrDF;

	public JMenu createMenuArrow(JMenuBar menuBar,
			ApplicationController acontroller) {

		this.acontroller = acontroller;
		ClassLoader classLoader = getClass().getClassLoader();

		ToolArrow ToolArrow = new ToolArrow(acontroller);
		toolArrS = new ToolArrowSimple(ToolArrow, acontroller);
		toolArrD = new ToolArrowDouble(ToolArrow, acontroller);
		toolArrSF = new ToolArrowSimpleF(ToolArrow,
				acontroller);
		toolArrDF = new ToolArrowDoubleF(ToolArrow,
				acontroller);

		JMenu toolMenu = new JMenu("Arrow");

		toolArrS.setText("Simple");
		URL simple = classLoader.getResource("ca/uds/jfig/application/images/Simple.png");
		toolArrS.setIcon(new ImageIcon(simple));

		toolArrD.setText("Double");
		URL doubles = classLoader.getResource("ca/uds/jfig/application/images/Double.png");
		toolArrD.setIcon(new ImageIcon(doubles));

		toolArrSF.setText("Simple filled");
		URL simpleF = classLoader.getResource("ca/uds/jfig/application/images/SimpleF.png");
		toolArrSF.setIcon(new ImageIcon(simpleF));

		toolArrDF.setText("Double filled");
		URL doubleF = classLoader.getResource("ca/uds/jfig/application/images/DoubleF.png");
		toolArrDF.setIcon(new ImageIcon(doubleF));

		toolArrS.addActionListener(this);
		toolArrD.addActionListener(this);
		toolArrSF.addActionListener(this);
		toolArrDF.addActionListener(this);

		toolMenu.add(toolArrS);
		toolMenu.add(toolArrD);
		toolMenu.add(toolArrSF);
		toolMenu.add(toolArrDF);

		menuBar.add(toolMenu);

		return toolMenu;

	}

	public void actionPerformed(ActionEvent e) {
		Command command = (Command) e.getSource();
		command.execute();
	}
}
