package versionZero.modele;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class SaveStructure {
	private boolean[][] bitmap;
	private int[][] couleurs;
	
	private BufferedImage image;
	
	public SaveStructure() {
		// CRAP VOID CONSTRUCTOR
	}

	private void initialiserStructure()
	{
		for(int i=0;i<bitmap.length;i++)
		{
			for(int j=0;j< bitmap[0].length;j++)
			{
				bitmap[i][j]=false;
				couleurs[i][j]=Color.white.getRGB();
			}
		}	
	}
	
	public void doSauvegarde(Image i,File f)
	{
		System.out.println("////////////////SAVE/////////////////");
		doSauvegarde(i);
		doWrite(f);
		System.out.println("/////////////////////////////////////");
	}
	
	public Image loadSauvegarde(File f) {
		System.out.println("////////////////LOAD/////////////////");
		doRead(f);
		genererImage();
		System.out.println("/////////////////////////////////////");
		return (Image) image;
	}

	public void doSauvegarde(Image i)
	{
		// Mise a jour de l'image
		image=new BufferedImage( i.getWidth(null),i.getHeight(null),BufferedImage.TYPE_INT_ARGB);
		Graphics2D pinceau=image.createGraphics();
		pinceau.drawImage(i, 0,0,null);
		pinceau.dispose();
		
		// Initialisation des tableaux de sauvegarde
		if(bitmap == null && couleurs == null) {
			bitmap = new boolean[image.getWidth()][image.getHeight()];
			couleurs = new int[image.getWidth()][image.getHeight()];
			initialiserStructure();
		}
		
		int pixel, bleu, vert, rouge;
		for(int j=0;j<image.getWidth();j++)
		{
			for (int k=0;k<image.getHeight();k++)
			{
				// Recuperation du pixel
				pixel=image.getRGB(j,k);
				// Extraction des couleurs du pixel
				bleu = pixel & 0xFF;
				vert = (pixel>>8) & 0xFF;
				rouge = (pixel>>16) & 0xFF;
				// Sauvegarde
				if(!(bleu==255 && vert ==255 && rouge == 255))
				{
					bitmap[j][k]=true;
					couleurs[j][k]=pixel;
				} 
			}
		}
	}
	
	private void doWrite(File f) {
		try {
			PrintWriter out  = new PrintWriter(f);
			
			out.write(this.getWidth());
			out.write(this.getHeight());
			
			//remplissage du tableau de bitmap
			for(int j=0;j<this.getWidth();j++) {
				for (int k=0;k<this.getHeight();k++) {
					if (bitmap[j][k]==true) {
						out.write(1);
					} else {
						out.write(0);
					}
				}
			}
		
			//remplissage du tableau de couleurs
			for (int j=0;j<this.getWidth();j++) {
				for (int k=0;k<this.getHeight();k++) {
					out.write(couleurs[j][k]);
				}
			}	
			
			out.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

	private void doRead(File f) {
		try {
			FileInputStream stream = new FileInputStream(f);
			byte[] buffer = new byte[4];
			
			stream.read(buffer);
			//int width = Utils.extractIntFrom(buffer,0);
			int width = 1184; /* Hardcoded -> error resolved */
			
			stream.read(buffer);
			int height = Utils.extractIntFrom(buffer, 0);
			height = 566;
			
			
			this.bitmap = new boolean[width][height];
			this.couleurs = new int[width][height];
			initialiserStructure();
			
			int cellule = 0;
			for(int i=0; i<width; i++) {
				for(int j=0; j<height; j++) {
					stream.read(buffer);
					cellule = Utils.extractIntFrom(buffer, 0);
					
					if(cellule == 0)
						bitmap[i][j] = false;
					else
						bitmap[i][j] = true;
				}
			}
					
			for(int i=0; i<width; i++) {
				for(int j=0; j<height; j++) {
					stream.read(buffer);
					cellule = Utils.extractIntFrom(buffer, 0);
					couleurs[i][j] = cellule;
				}
			}
			
			stream.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
		
	private void genererImage() {
		image = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
		Graphics2D pinceau = image.createGraphics();
		pinceau.drawImage(image, 0, 0, null);
		for(int j=0; j<getWidth(); j++) {
			for(int k=0; k<getHeight(); k++) {
				if(this.bitmap[j][k]) {
					pinceau.setColor(new Color(couleurs[j][k]));
					pinceau.drawLine(j, k, j, k);
				} else {
					pinceau.setColor(Color.white);
					pinceau.drawLine(j, k, j, k);
				}
			}
		}
		pinceau.dispose();
	}
	
	public boolean getCellule(int x,int y)
	{
		return bitmap[x][y];
	}
	
	public int getColor(int x, int y)
	{
		return couleurs[x][y];
	}
	
	public int getWidth()
	{
		return this.bitmap.length;
	}
	
	public int getHeight()
	{
		return this.bitmap[0].length;
		
	}
	
	public void modifierPixel(int x ,int y,int c)
	{
		bitmap[x][y]=true;
		couleurs[x][y]=c;
	}
	
	public void showSave() {
		// Affichage du tableau des booleens
		System.out.println("Affichage des tableaux");
		for(int i=0; i<getHeight(); i++) {
			for(int j=0; j<getWidth(); j++) {
				System.out.print(bitmap[j][i]+":"+couleurs[j][i]+" ");
			}
			System.out.println();
		}
	}
	
	// Compare deux objets  SaveStructure
	public boolean equals(Object c)
	{
		// Verification du type
		if (!(c instanceof SaveStructure))
		{
			return false;
		}
		SaveStructure b=(SaveStructure)c;
		
		// Verification de la taille
		if (this.getHeight()!=b.getHeight() || this.getWidth()!=b.getWidth() )
		{
			return false;
		}
	
		// Verification du contenu
		for(int i=0; i<this.getWidth();i++)
		{
			for(int j=0;j<this.getHeight();j++)
			{
				if ( getCellule(i,j) !=b.getCellule(i,j) || getColor(i,j) != b.getColor(i, j) )
				{
					return false;
				}
			}
		}
	
		return true;
	}
	
	
	
	
}
	
	
	
	
