package versionZero.vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;
import java.awt.font.TextLayout;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JComponent;

class Dessin extends JComponent implements Observer {
	private static final long serialVersionUID = 1L;
	Image image;
	static // static //notre image
	Graphics2D toile;// l'outil

	int courantX, courantY, ancienX, ancienY;// cordonees de la souris

	private Fenetre fenetre;
	private RTextLayout focused = null;
	// constructeur
	public Dessin(Fenetre f) {
		fenetre = f;
		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				ancienX = e.getX();
				ancienY = e.getY();
			}
			public void mouseReleased(MouseEvent e){
				focused = null;
			}
		});

		addMouseMotionListener(new MouseMotionAdapter() {
			

			public void mouseDragged(MouseEvent e) {
				courantX = e.getX();
				courantY = e.getY();
				if (fenetre.getModel().getMode() == DessinModel.PAINT_MODE) {

					if (toile != null)
						toile.drawLine(ancienX, ancienY, courantX, courantY);

				} else {
					if (focused == null) {
						for (int i = fenetre.getModel().getList().size() - 1; i >= 0; i--) {
							RTextLayout t = fenetre.getModel().getList().get(i);
							if (t.isHit(ancienX, ancienY)) {
								focused = t;
							}
						}
					}
					else
						focused.move(courantX - focused.getWidth() / 2, courantY + focused.getHeight() / 2);
				}
				repaint();
				ancienX = courantX;
				ancienY = courantY;
			}
			
		});
		// quand la souris a bougÃ© une ligne se dessigne en utilisant les
		// cordonees x ,y
		// est la ligne se fait peindre et les anciens x,y deviennent les
		// nouveau

	}

	// Déssin
	public void paintComponent(Graphics g) {
		if (image == null) {
			image = createImage(getSize().width, getSize().height);
			toile = (Graphics2D) image.getGraphics();
			clear();
		}
		g.drawImage(image, 0, 0, null);
		for (RTextLayout rt : fenetre.getModel().getList()) {
			rt.draw(g);
		}
	}

	// Efface tout ce qui a dans le canvas
	public void clear() {
		toile.setPaint(Color.white);
		toile.fillRect(0, 0, getSize().width, getSize().height);
		toile.setPaint(Color.black);
		fenetre.getModel().clear();
		repaint();
	}

	// Change la couleur du pinceau
	public void changePencilColor(Color couleur) {
		toile.setPaint(couleur);
		// repaint();
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		repaint();
	}

}
