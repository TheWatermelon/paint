package versionZero.test;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import versionZero.modele.SaveStructure;
import  versionZero.vue.Dessin;

public class TestSauvegarde {
	private Dessin a;
	private SaveStructure sauvegarde1;
	private SaveStructure sauvegarde2;
	
	@Before
	public void setup()
	{
		/*
		a =new Dessin();
		sauvegarde1=new SaveStructure();
		sauvegarde2=new SaveStructure();
		
		System.out.println("la largeur "+a.getSize().width+"  la longueur "+a.getSize().height);
		*/
	}

	@Test
	public void test() {
		/*
		a.dessiner(10,10,11,10);
		a.dessiner(9,30,8,31);
		a.dessiner(42,42,43,43);
		a.dessiner(50,10,50,9);

		
		sauvegarde1.doSauvegarde(a.getImage());
		sauvegarde2.doSauvegarde(a.getImage());
		
		
		
		assertEquals(sauvegarde1,sauvegarde2);
		*/
	}

	@After
	public void tearDown() {
		this.a = null;
		this.sauvegarde1 = null;
		this.sauvegarde2 = null;
	}

}
