/**
 * 
 */
package ca.uds.jfig.application;

import java.awt.BorderLayout;
import java.awt.Color;
import java.net.URL;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JWindow;

/**
 * @author gonr1001
 * 
 */
@SuppressWarnings("serial")
public class SplashScreen extends JWindow {
//	private final String _SPLASH_PATH = "." + File.separator + "images"
//			+ File.separator + "splash.png";

	int WIDTH = 480;
	int HEIGTH = 260;

	public SplashScreen(int duration) {
		ClassLoader classLoader = getClass().getClassLoader();
		JPanel p = new JPanel();
		p.setLayout(new BorderLayout());
		URL splash = classLoader.getResource("ca/uds/jfig/application/images/splash.png");
		p.add(new Picture(splash));
		p.setBorder(BorderFactory.createLineBorder(Color.black, 0));
		getContentPane().add(p);
		setSize(WIDTH, HEIGTH);
		setLocationRelativeTo(null);
		setVisible(true);
		try {
			Thread.sleep(duration);
			this.dispose();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean isAlive() {
		return true;
	}

}
