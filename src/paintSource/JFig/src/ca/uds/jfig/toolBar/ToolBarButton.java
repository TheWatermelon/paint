/**
 * 
 */

/**
 * @author Coatanea Brendan
 * @date 10/05/2013
 *
 */
package ca.uds.jfig.toolBar;

import java.awt.*;
import java.net.URL;

import javax.swing.*;


@SuppressWarnings("serial")
public class ToolBarButton extends JButton {
	private static final Insets margins = new Insets(0, 0, 0, 0);

	public ToolBarButton(Icon image) {
		super(image);
		setMargin(margins);
		setVerticalTextPosition(BOTTOM);
		setHorizontalTextPosition(CENTER);
	}

	public ToolBarButton(URL imageFile) {
		this(new ImageIcon (imageFile));
	}

	public ToolBarButton(URL imageFile, String text) {
		this(new ImageIcon(imageFile));
		setText(text);
	}
}