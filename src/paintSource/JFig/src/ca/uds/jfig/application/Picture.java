/**
 * 
 */
package ca.uds.jfig.application;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * @author gonr1001
 *
 */
/**
 * This class loads and shows a picture, that can be either in the same jar file
 * than the program or not. If the picture is smaller than the available space,
 * it will be centered. If the picture is bigger than the available space, a
 * zoom will be applied in order to fit exactly the space.
 */
@SuppressWarnings("serial")
public class Picture extends JPanel implements Icon {
	Image img;

	public Picture(URL splash) {
		// System.out.println(getClass().getResource(file));
		ImageIcon splashIcon = new ImageIcon(splash);
		img = splashIcon.getImage();
		repaint();
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (img == null)
			return;
		int w = img.getWidth(this);
		int h = img.getHeight(this);
		boolean zoom = (w > getWidth() || h > getHeight());
		if (zoom)
			g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
		else
			g.drawImage(img, (getWidth() - w) / 2, (getHeight() - h) / 2, this);
	}

	@Override
	public int getIconHeight() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getIconWidth() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void paintIcon(Component c, Graphics g, int x, int y) {
		// TODO Auto-generated method stub
		
	}
}
