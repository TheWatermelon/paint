package versionZero.modele;

import java.io.File;

import javax.swing.JFileChooser;

import versionZero.vue.Dessin;

public class LoadCommand extends Command {
	private SaveStructure sauvegarde;
	private Dessin dessin;
	
	public LoadCommand(Dessin d) {
		this.sauvegarde = new SaveStructure();
		this.dessin = d;
	}
	
	@Override
	public void execute() {
		JFileChooser boitesauvegarde=new JFileChooser ("");
		boitesauvegarde.setApproveButtonText("Charger");
		File fichier=null; 
		
		if(boitesauvegarde.showOpenDialog(null)==JFileChooser.APPROVE_OPTION)
		{
			fichier=boitesauvegarde.getSelectedFile();
			dessin.setImage(sauvegarde.loadSauvegarde(fichier));
			dessin.repaint();
		}
	}
}
