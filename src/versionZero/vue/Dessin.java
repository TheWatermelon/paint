package versionZero.vue;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JComponent;
import versionZero.modele.*;
public class Dessin extends JComponent{

	private static final long serialVersionUID = 1L;
			Image image;
			static //static //notre image
			Graphics2D toile;
			//l'outil
			int courantX, courantY, ancienX, ancienY;
			//cordonees de la souris
			 SaveStructure  sauvegarde;
			 

			//constructeur
			public Dessin(){
			     sauvegarde=new SaveStructure(getWidth(),getHeight()); 
				addMouseListener(new MouseAdapter(){
					public void mousePressed(MouseEvent e){
						ancienX = e.getX();
						ancienY = e.getY();
						sauvegarde.modifierPixel(ancienX, ancienY,toile.getColor() );
					}
				});
				

				addMouseMotionListener(new MouseMotionAdapter(){
					public void mouseDragged(MouseEvent e){
						courantX = e.getX();
						courantY = e.getY();
						if(toile != null)
							toile.drawLine(ancienX, ancienY, courantX, courantY);
						repaint();
						ancienX = courantX;
						ancienY = courantY;
						sauvegarde.modifierPixel(ancienX, ancienY,toile.getColor() );
					}

				});
				//quand la souris a bougÃ© une ligne se dessigne en utilisant les cordonees x ,y
				//est la ligne se fait peindre et les anciens x,y deviennent les nouveau
			}

			//Déssin
			public void paintComponent(Graphics g){
				if(image == null){
					image = createImage(getSize().width, getSize().height);
					toile = (Graphics2D)image.getGraphics();
					clear();
				}
				g.drawImage(image, 0, 0, null);
			}

			//Efface tout ce qui a dans le canvas
			public void clear(){
				toile.setPaint(Color.white);
				toile.fillRect(0, 0, getSize().width, getSize().height);
				toile.setPaint(Color.black);
				repaint();
			}
			
			//Change la couleur du pinceau
			public void changePencilColor(Color couleur){
				toile.setPaint(couleur);
				//repaint();
			}
			public void dessiner(int AncienX,int AncienY,int NouveauX,int NouveauY)
			{
				if (toile!=null)
				{
			  toile.drawLine(AncienX,AncienY, NouveauX,NouveauY);
				 sauvegarde.modifierPixel(AncienX, AncienY, toile.getColor());
				 sauvegarde.modifierPixel(NouveauX, NouveauY, toile.getColor());
				 
				}
				repaint();
		
			  
			
			}
			
			public SaveStructure getSauvegarde()
			{
				return this.sauvegarde;
			}
		
			
			
			
		}

	



