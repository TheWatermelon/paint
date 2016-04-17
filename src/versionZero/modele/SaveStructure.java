package versionZero.modele;

import java.awt.Color;

public class SaveStructure {
	private boolean[][] bitmap;
	private Color[][] couleurs;
	
	public SaveStructure(int x,int y)
	{
		bitmap=new boolean[x][y];
		couleurs=new Color[x][y];
		initialiserStructure();
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
	
	
	
	
