/**
 * 
 */

/**
 * @author Coatanea Brendan
 * @worker Nolwenn ROGER, Aymeric Birotheau, Florian Bonniec
 * @date 30/04/2013
 *
 */
package ca.uds.jfig.menu;

import javax.swing.JMenuBar;

import ca.uds.jfig.application.ApplicationController;
import ca.uds.jfig.application.ApplicationModel;

@SuppressWarnings("serial")
public class Menu extends JMenuBar {
	ApplicationController acontroller;
	ApplicationModel amodel;

	public Menu(ApplicationController acontroller) {

		MenuFile menuFile = new MenuFile(acontroller);
		//MenuEdit menuEdit = new MenuEdit(acontroller);
		MenuMode menuMode = new MenuMode(acontroller);
		MenuTool menuTool = new MenuTool();
		MenuArrow menuArrow = new MenuArrow();
		MenuColor menuColor = new MenuColor(acontroller,amodel);
		MenuStroke menuStroke = new MenuStroke();
		MenuZoom menuZoom = new MenuZoom(acontroller);


		this.add(menuFile.createMenuFile(this));
	//	this.add(menuEdit.createMenuEdit(this));
		this.add(menuMode.createMenuMode(this));
		this.add(menuTool.createMenuTool(this, acontroller));
		this.add(menuArrow.createMenuArrow(this, acontroller));
		this.add(menuColor.createMenuColor(this));
		this.add(menuStroke.createMenuStroke(this, acontroller));
		this.add(menuZoom.createMenuZoom(this));


	}
}
