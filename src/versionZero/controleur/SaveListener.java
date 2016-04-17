package versionZero.controleur;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import versionZero.modele.SaveStructure;
import versionZero.vue.Dessin;

public class SaveListener implements ActionListener {
private SaveStructure sauvegarde;
private Image image;

	public  SaveListener(Dessin a){
		image = a.getImage();
		sauvegarde=new SaveStructure(image); 
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		sauvegarde.doSauvegarde(image);
		
	}

}
