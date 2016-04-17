package versionZero.test;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import versionZero.modele.SaveStructure;
import versionZero.modele.*;
import  versionZero.vue.Dessin;

public class TestSauvegarde {
	private Dessin a;
	private SaveStructure sauvegarde;

	
	@Before
	public void setup()
	{
		a =new Dessin();
		sauvegarde=new SaveStructure(a.getWidth(),a.getHeight());
		System.out.println("la largeur "+a.getWidth()+"  la longueur "+a.getHeight());
	}

	@Test
	public void test() {
		
		a.dessiner(10,10,11,10);
		sauvegarde.modifierPixel(10, 10, Color.black);
		sauvegarde.modifierPixel(11, 10, Color.black);
		
		a.dessiner(9,30,8,31);
		sauvegarde.modifierPixel(9, 30, Color.black);
		sauvegarde.modifierPixel(8, 31, Color.black);	
		
		a.dessiner(42,42,43,43);
		sauvegarde.modifierPixel(42,42, Color.black);
		sauvegarde.modifierPixel(43,43, Color.black);		
		
		a.dessiner(50,10,50,9);
		sauvegarde.modifierPixel(50,10, Color.black);
		sauvegarde.modifierPixel(50,9, Color.black);
		
		assertEquals(a.getSauvegarde(),sauvegarde);
		
	}

	@After
	public void tearDown() {
		this.a = null;
		this.sauvegarde = null;
	}

}
