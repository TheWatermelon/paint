/**
 * 
 */

/**
 * @author Coatanea Brendan
 * @date 1/05/2013
 *
 */
package ca.uds.jfig.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import ca.uds.jfig.application.ApplicationController;
import ca.uds.jfig.application.ApplicationModel;

public class MenuColor implements ActionListener, Observer {
	JMenu colorMenu;
	JMenuBar menuBar;
	JMenuItem border;
	ToolColor ToolColor;
	JMenuItem fill;
	ToolColorFill toolFill;
	ToolColorBorder toolBorder;
	private ApplicationController acontroller;
	private ApplicationModel amodel;

	public MenuColor(ApplicationController acontroller, ApplicationModel amodel) {
		this.acontroller = acontroller;
		this.amodel = amodel;
	}

	public JMenu createMenuColor(JMenuBar menuBar) {

		this.menuBar = menuBar;
		ToolColor = new ToolColor(acontroller, amodel);
		toolBorder = new ToolColorBorder(ToolColor, acontroller, amodel,
				new ImageIcon(createImageIconBorder()));
		toolFill = new ToolColorFill(ToolColor, acontroller, amodel,
				new ImageIcon(createImageIconFill()));
		acontroller.addObserver(this);
		colorMenu = new JMenu("Color");

		toolBorder.setText("Border");
		toolFill.setText("Fill");
		toolBorder.addActionListener(this);
		toolFill.addActionListener(this);

		colorMenu.add(toolBorder);
		colorMenu.add(toolFill);
		menuBar.add(colorMenu);
		return colorMenu;
	}

	public void actionPerformed(ActionEvent e) {
		Command command = (Command) e.getSource();
		command.execute();
	}

	public BufferedImage createImageIconFill() {
		final int SIZE = 25;
		BufferedImage image = new BufferedImage(SIZE, SIZE,
				BufferedImage.TYPE_INT_RGB);
		for (int col = 0; col < SIZE; col++) {
			for (int row = 0; row < SIZE; row++) {
				image.setRGB(col, row, acontroller.getFillColor().getRGB());
			}
		}
		return image;
	}

	public BufferedImage createImageIconBorder() {
		final int SIZE = 25;
		BufferedImage image = new BufferedImage(SIZE, SIZE,
				BufferedImage.TYPE_INT_RGB);
		for (int col = 0; col < SIZE; col++) {
			for (int row = 0; row < SIZE; row++) {
				image.setRGB(col, row, acontroller.getBorderColor().getRGB());
			}
		}
		return image;
	}

	@Override
	public void update(Observable o, Object arg) {
		colorMenu.removeAll();
		ToolColor = new ToolColor(acontroller, amodel);
		toolBorder = new ToolColorBorder(ToolColor, acontroller, amodel,
				new ImageIcon(createImageIconBorder()));
		toolBorder.setText("Border");
		colorMenu.add(toolBorder);

		toolFill = new ToolColorFill(ToolColor, acontroller, amodel,
				new ImageIcon(createImageIconFill()));
		toolFill.setText("Fill");
		toolBorder.addActionListener(this);
		toolFill.addActionListener(this);
		colorMenu.add(toolFill);

	}
}
