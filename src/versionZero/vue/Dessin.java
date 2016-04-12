package versionZero.vue;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JComponent;

class Dessin extends JComponent{

	private static final long serialVersionUID = 1L;
			Image image;
			//static //notre image
			Graphics2D toile;
			//l'outil
			int courantX, courantY, ancienX, ancienY;
			//cordonees de la souris

			//constructeur
			public Dessin(){
			
				addMouseListener(new MouseAdapter(){
					public void mousePressed(MouseEvent e){
						ancienX = e.getX();
						ancienY = e.getY();
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
					}

				});
				//quand la souris a bougé une ligne se dessigne en utilisant les cordonees x ,y
				//est la ligne se fait peindre et les anciens x,y deviennent les nouveau
			}

			public void paintComponent(Graphics g){
				if(image == null){
					image = createImage(getSize().width, getSize().height);
					toile = (Graphics2D)image.getGraphics();
					clear();

				}
				g.drawImage(image, 0, 0, null);
			}
			//c'est le cadre
			//si il est vide il cree une page vide
			//de la taille de la fenetre
			//netoyer
			//il dessine le carde


			public void clear(){
				toile.setPaint(Color.white);
				toile.fillRect(0, 0, getSize().width, getSize().height);
				toile.setPaint(Color.black);
				repaint();
			}
			//fonction clear
			//met les couleur en blanc
			//rempli la fentetre en blanc
			//met la couleur actuelle en noir
			public void red(){
				toile.setPaint(Color.red);
				repaint();
			}
			//rouge
			
			public void white(){
				toile.setPaint(Color.white);
				repaint();
			}
			//blanc
			
			public void orange(){
				toile.setPaint(Color.orange);
				repaint();
			}
			//orange
			
			public void black(){
				toile.setPaint(Color.black);
				repaint();
			}
			//noir
			public void magenta(){
				toile.setPaint(Color.magenta);
				repaint();
			}
			//magenta 
			public void blue(){
				toile.setPaint(Color.blue);
				repaint();
			}
			//bleu
			public void green(){
				toile.setPaint(Color.green);
				repaint();
			}
			//vert
			
			public void yellow(){
				toile.setPaint(Color.yellow);
				repaint();
			}
			//jaune
			public void gray(){
				toile.setPaint(Color.gray);
				repaint();
			}
			//gris
			public void cyan(){
				toile.setPaint(Color.cyan);
				repaint();
			}
			//bleu ciel

		}

	




