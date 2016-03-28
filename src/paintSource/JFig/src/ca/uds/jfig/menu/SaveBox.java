package ca.uds.jfig.menu;
/**
 * 
 */

/**
 * @author Aymeric Birotheau
 * @worker ROGER Nolwenn
 *
 */
import javax.swing.JOptionPane;
import javax.swing.JFrame;

import ca.uds.jfig.application.ApplicationController;

@SuppressWarnings("serial")
public class SaveBox extends JFrame {
	
	ApplicationController acontroller; 
	JFrame parentFrame;
	public SaveBox(ApplicationController acontroller){
		this.acontroller=acontroller;			
	}

	public void confirmBox() {
		int option = JOptionPane.showConfirmDialog(this,
				"The document has been modified.\n"
						+ "Do you want to save your changes?", " jFig",
				JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);

		switch (option) {
		case JOptionPane.YES_OPTION:
			acontroller.saveFile();
			acontroller.newFile();
			break;
		case JOptionPane.NO_OPTION:
			acontroller.newFile();
			break;
		case JOptionPane.CANCEL_OPTION:
			break;
		}

	}

}