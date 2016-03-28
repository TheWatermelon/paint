/**
 * 
 * @autor Florian bonniec
 * @worker Gael Rochard
 * 
 **/
package ca.uds.jfig.figureView;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JPanel;

import ca.uds.jfig.application.ApplicationModel;
import ca.uds.jfig.application.FigureController;
import ca.uds.jfig.application.FigureModel;
import ca.uds.jfig.figures.Figure;
import ca.uds.jfig.jfigInterface.ModeInterface;

@SuppressWarnings("serial")
public class DisplayAreaView extends JPanel implements Observer, ModeInterface{

	private FigureModel fmodel;
	private ApplicationModel amodel;
	private FigureController fcontroller;

	public DisplayAreaView(ApplicationModel amodel, FigureModel fmodel, FigureController fcontroller) {
		this.fmodel = fmodel;
		this.amodel=amodel;
		this.fcontroller =fcontroller;
		fmodel.addObserver(this);
		amodel.addObserver(this);
	}

	public void paint(Graphics g) {
		this.setBackground(Color.blue);
		this.setVisible(true);
		Graphics2D g2 = (Graphics2D) g;

		g2.scale(amodel.getScale()/100, amodel.getScale()/100);
		AffineTransform at = g2.getTransform();
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		Figure figureList = fmodel.getFigureList();
		figureList.paint(g);
		g2.setTransform(at);
	}

	@Override
	public void update(Observable o, Object arg) {
		switch (amodel.getMode()){
		case SELECT:
		fcontroller.changeFigureProperties();
		repaint();break;
		}
	}

}
