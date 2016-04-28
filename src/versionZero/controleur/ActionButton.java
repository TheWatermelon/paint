package versionZero.controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import versionZero.modele.Command;

public class ActionButton extends JButton implements ActionListener, Invoker {
	private static final long serialVersionUID = 1L;
	private Command cmd;
	
	public ActionButton(){
		super();
		this.addActionListener(this);
	}

	public ActionButton(ImageIcon i) {
		super(i);
		this.addActionListener(this);
	}
	
	public ActionButton(String s) {
		super(s);
		this.addActionListener(this);
	}
	
	@Override
	public void storeCommand(Command c) {
		this.cmd = c;		
	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		this.cmd.execute();		
	}

	
}
