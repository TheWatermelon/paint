package versionZero.vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.event.MouseInputListener;

public class DrawArea extends JPanel implements MouseInputListener {
	private Point lastDrawPoint = new Point();
	private ArrayList<ColoredRectangle> coloredRectangles = new ArrayList<ColoredRectangle>();
	public DrawArea(){
		addMouseListener(this);
		addMouseMotionListener(this);
	}
	
	public Dimension getPreferredSize(){
		return new Dimension(1280, 600);
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		for(ColoredRectangle cr : coloredRectangles){
			g.setColor(cr.getForeground());
			g.drawRect(cr.getRectangle().x, cr.getRectangle().y, cr.getRectangle().width, cr.getRectangle().height);
		}
	}
	
	private void addColoredRectangle(Point p){
		ColoredRectangle cr = new ColoredRectangle(Color.BLACK, new Rectangle(p.x, p.y, 1, 1));
		coloredRectangles.add(cr);
		repaint();
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		System.out.println("Mouse Entered");
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		Point p = e.getPoint();
		addColoredRectangle(p);
		lastDrawPoint = p;
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		lastDrawPoint = new Point(-1, -1);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		Point p = e.getPoint();
		if(!lastDrawPoint.equals(p)){
			addColoredRectangle(p);
			lastDrawPoint = p;
		}
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
	}

}
