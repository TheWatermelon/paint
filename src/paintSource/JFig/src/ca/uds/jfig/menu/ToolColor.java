/**
 * 
 */

/**
 * @author Coatanea Brendan
 * @worker Nolwenn ROGER bonniec florian
 * @date 1/05/2013
 *
 */
package ca.uds.jfig.menu;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JColorChooser;
import javax.swing.JMenuItem;

import ca.uds.jfig.application.ApplicationController;
import ca.uds.jfig.application.ApplicationModel;

@SuppressWarnings("serial")
public class ToolColor extends JMenuItem {

	ApplicationController acontroller;
	ApplicationModel amodel;
	ImageIcon imageB;
	ImageIcon imageF;

	public ToolColor(ApplicationController acontroller, ApplicationModel amodel) {
		this.acontroller = acontroller;
		this.amodel = amodel;
	}

	public void Border() {
		Color colorBorder = JColorChooser.showDialog(null, "choose a color",
				Color.black);
		if (colorBorder != null)
			acontroller.setBorderColor(colorBorder);
	}

	public void Fill() {
		Color colorFill = JColorChooser.showDialog(null, "Choose a Color",
				Color.black);
		if (colorFill != null)
			acontroller.setFillColor(colorFill);
	}
}
