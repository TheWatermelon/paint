/**
 * 
 * @autor Aymeric Birotheau
 *  
 **/
package ca.uds.jfig.figureView;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Point2D;

import javax.swing.JPanel;
import javax.swing.JTextArea;

import ca.uds.jfig.application.ApplicationController;
import ca.uds.jfig.application.FigureController;
import ca.uds.jfig.figures.Figure;
import ca.uds.jfig.figures.FigureFactory;
import ca.uds.jfig.jfigInterface.FigureInterface;

@SuppressWarnings("serial")
public class TextPanelView extends JPanel implements MouseListener, KeyListener, FigureInterface {
	private int x1 = 10, y1 = 10;
	private JTextArea textarea = new JTextArea("Write your text");
	int Sizemin = 1000;
	int Sizemax = 15;
	ApplicationController acontroller;
	FigureController fcontroller;

	public TextPanelView(ApplicationController acontroller,
			FigureController fcontroller) {
		this.setLayout(null);
		this.addMouseListener(this);
		textarea.addKeyListener(this);
		this.acontroller = acontroller;
		this.setFocusable(true);
		this.fcontroller = fcontroller;

	}

	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mousePressed(MouseEvent mouseEvent) {
		// TODO Auto-generated method stub
		textarea.setText("Write your text");
		x1 = mouseEvent.getX();
		y1 = mouseEvent.getY();
		textarea.setBounds(x1, y1, Sizemin, Sizemax);
		textarea.setForeground(Color.red);
		
		this.add(textarea);

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}

	public void keyPressed(KeyEvent e) {

	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

		Point2D.Double point = new Point2D.Double(x1, y1);
		if (arg0.getKeyChar() == KeyEvent.VK_ENTER) {
			FigureFactory fig = new FigureFactory(acontroller,fcontroller);
			acontroller.setText(textarea.getText());			
			acontroller.setType(TEXTFIG);
			Figure figu = fig.createFigure(point, point);
			if (figu != null) {
				fcontroller.add(figu);
				this.remove(textarea);

			}
		}
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
	}
}
