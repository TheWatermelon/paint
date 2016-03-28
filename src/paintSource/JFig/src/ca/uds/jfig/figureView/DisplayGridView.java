package ca.uds.jfig.figureView;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
//import java.awt.RenderingHints;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import ca.uds.jfig.application.ApplicationModel;

@SuppressWarnings("serial")
public class DisplayGridView extends JPanel implements Observer{
	ApplicationModel amodel;
	
	public DisplayGridView(ApplicationModel amodel){
		this.amodel = amodel;
		amodel.addObserver(this);
	}
	
	public void paint(Graphics g){
		if(amodel.getGridStatus()==false) return;
		Graphics2D g2d = (Graphics2D) g;
		g2d.setPaint(new Color(0,100,200));
		g2d.scale(amodel.getScale()/100, amodel.getScale()/100);
//		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		int step = (int) (amodel.getGridStep());
		float[] stroke = { 0,step};
		g2d.setStroke(new BasicStroke(1, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_BEVEL, 10, stroke, 0));
		for(int i=step; i<amodel.getDrawZoneWidth(); i+=step){
			g2d.drawLine(i, 0, i, (int) amodel.getDrawZoneHeight());
		}
	}

	public void update(Observable arg0, Object arg1) {
		repaint();
	}
}
