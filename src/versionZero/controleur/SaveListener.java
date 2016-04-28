package versionZero.controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;

import versionZero.modele.SaveStructure;
import versionZero.vue.Dessin;

public class SaveListener implements ActionListener {
private SaveStructure sauvegarde;
private Dessin dessin;

	public  SaveListener(Dessin a){
		dessin = a;
		sauvegarde=new SaveStructure(); 
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		JFileChooser boitesauvegarde=new JFileChooser ("save/");
		File fichier; 
		
		if(boitesauvegarde.showOpenDialog(null)==JFileChooser.APPROVE_OPTION)
		{
			fichier=boitesauvegarde.getSelectedFile();
			sauvegarde.doSauvegarde(dessin.getImage(),fichier);
		}
		
		
		
		
		
		
		sauvegarde.doSauvegarde(dessin.getImage());
	}

	
	
}
