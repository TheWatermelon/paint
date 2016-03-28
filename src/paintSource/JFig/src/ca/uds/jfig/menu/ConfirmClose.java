package ca.uds.jfig.menu;

import ca.uds.jfig.application.ApplicationController;
import ca.uds.jfig.application.ApplicationModel;

/**
 * @author Aymeric Birotheau
 * @worker Nolwenn ROGER
 * 
 */
public class ConfirmClose {

	private ApplicationController acontroller;
	private ApplicationModel amodel;

	public ConfirmClose(ApplicationController acontroller) {
		this.acontroller = acontroller;
		this.amodel = acontroller.getModel();
	}

	public void close() {
		if (!acontroller.getFigureList().isEmpty() && amodel.getSave() != true) {
			ExitBox exit = new ExitBox(acontroller);
			exit.confirmBox();
		} else {
			System.exit(0);
		}
	}
	public void newFile(){
		if (!acontroller.getFigureList().isEmpty() && amodel.getSave() != true){
			SaveBox save = new SaveBox(acontroller);
			save.confirmBox();
		} else if (!acontroller.getFigureList().isEmpty()&& amodel.getSave() == true){
			acontroller.newFile();
		}
	}
}
