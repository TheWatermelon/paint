package versionZero.modele;

import java.io.File;

import javax.swing.JFileChooser;

import versionZero.vue.Dessin;


public class SaveCommand extends Command {	
	private SaveStructure sauvegarde;
	private Dessin dessin;
	
	public SaveCommand(Dessin d) {
		this.sauvegarde = new SaveStructure();
		this.dessin = d;
	}
	
	@Override
	public void execute() {
		JFileChooser boitesauvegarde=new JFileChooser ("");
		boitesauvegarde.setApproveButtonText("Sauver");
		File fichier=null; 
		
		if(boitesauvegarde.showOpenDialog(null)==JFileChooser.APPROVE_OPTION)
		{
			fichier=boitesauvegarde.getSelectedFile();
			sauvegarde.doSauvegarde(dessin.getImage(),fichier);
			//sauvegarde.showSave();
		}
	}
}
