package vue;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class applicationFrame extends JFrame implements observer{

	public applicationFrame() {
	}

	public applicationFrame(String title) {
		super(title);
		createUI();
	}

	private void createUI() {
		this.setSize(500, 400);
		this.center();
		this.setVisible(true);
	}

	private void center() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameSize = getSize();
		int x = (screenSize.width - frameSize.width) / 2;
		int y = (screenSize.height - frameSize.height) / 2;
		this.setLocation(x, y);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

}
