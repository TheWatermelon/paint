package ca.uds.jfig.figureView;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

@SuppressWarnings("serial")
public class ApplicationFrame extends Frame {

	public ApplicationFrame() {
	}

	public ApplicationFrame(String title) {
		super(title);
		createUI();
	}

	private void createUI() {
		this.setSize(500, 400);
		this.center();
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose();
				System.exit(0);
			}
		});
	}

	private void center() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameSize = getSize();
		int x = (screenSize.width - frameSize.width) / 2;
		int y = (screenSize.height - frameSize.height) / 2;
		this.setLocation(x, y);
	}

}
