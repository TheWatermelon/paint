/**
 * 
 */

/**
 * @author Coatanea Brendan
 * @worker bonniec florian
 * @date 1/05/2013
 *
 */
package ca.uds.jfig.menu;

import javax.swing.ImageIcon;

import ca.uds.jfig.application.ApplicationController;
import ca.uds.jfig.application.ApplicationModel;

@SuppressWarnings("serial")
public class ToolColorBorder extends ToolColor implements Command {

	private ToolColor theToolColor;
	private ImageIcon image;

	public ToolColorBorder(ToolColor ToolColor,
			ApplicationController acontroller, ApplicationModel amodel,
			ImageIcon imgB) {
		super(acontroller, amodel);
		theToolColor = ToolColor;
		this.setIcon(imgB);
	}

	public void execute() {
		theToolColor.Border();
	}

	public ImageIcon getImage() {
		return image;
	}

	public void setImage(ImageIcon image) {
		this.image = image;
	}
}
