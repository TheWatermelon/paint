package application;

import vue.applicationFrame;

public class application {

	
	public static void main(String[] args) {
		
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new applicationFrame("Paint");
            }
        });
	}
	
}
