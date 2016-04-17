package versionZero.modele;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

public class SaveStructure {
	private boolean[][] bitmap;
	private Color[][] couleurs;
	
	private BufferedImage image;
	
	public SaveStructure(Image i)
	{
		// Conversion Image -> BufferedImage pour faciliter la sauvegarde
		image=new BufferedImage( i.getWidth(null),i.getHeight(null),BufferedImage.TYPE_INT_ARGB);
		Graphics2D pinceau=image.createGraphics();
		pinceau.drawImage(i, 0,0,null);
		pinceau.dispose();
		// Initialisation des tableaux de sauvegarde
		bitmap=new boolean[image.getWidth()][image.getHeight()];
		couleurs=new Color[image.getWidth()][image.getHeight()];
		this.initialiserStructure();
	}

	private void initialiserStructure()
	{
		for(int i=0;i<bitmap.length;i++)
		{
			for(int j=0;j< bitmap[0].length;j++)
			{
				bitmap[i][j]=false;
				couleurs[i][j]=Color.white;
			}
		}	
	}
	
	public void doSauvegarde(Image i)
	{
		// Mise a jour de l'image
		image=new BufferedImage( i.getWidth(null),i.getHeight(null),BufferedImage.TYPE_INT_ARGB);
		Graphics2D pinceau=image.createGraphics();
		pinceau.drawImage(i, 0,0,null);
		pinceau.dispose();
		
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
					couleurs[j][k]=new Color(rouge,vert,bleu);
				} 
			}
		}
	}
	
	public boolean getCellule(int x,int y)
	{
		return bitmap[x][y];
	}
	
	public Color getColor(int x, int y)
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
	
	public void modifierPixel(int x ,int y,Color c)
	{
		bitmap[x][y]=true;
		couleurs[x][y]=c;
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
	
	
	
	
