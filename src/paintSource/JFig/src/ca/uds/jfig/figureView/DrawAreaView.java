
package ca.uds.jfig.figureView;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JPanel;

import ca.uds.jfig.application.ApplicationController;
import ca.uds.jfig.application.ApplicationModel;
import ca.uds.jfig.application.FigureController;
import ca.uds.jfig.application.MouseModel;
import ca.uds.jfig.figures.Figure;
import ca.uds.jfig.figures.FigureFactory;
import ca.uds.jfig.jfigInterface.ModeInterface;


@SuppressWarnings("serial")
public class DrawAreaView extends JPanel implements MouseListener,
		MouseMotionListener, ModeInterface, MouseWheelListener {
	private ApplicationController acontroller;
	private ApplicationModel amodel;
	private MouseModel mmodel;
	private FigureController fcontroller;
	private FigureFactory figureFactory;
	private boolean activeDrawing;
	private boolean activeSelect;

	public DrawAreaView(FigureController fcontroller,
			ApplicationController acontroller) {
		this.fcontroller = fcontroller;
		this.acontroller = acontroller;
		this.amodel = acontroller.getModel();
		this.mmodel = acontroller.getMouseModel();
		this.figureFactory = new FigureFactory(acontroller,fcontroller);
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		this.addMouseWheelListener(this);
		this.activeDrawing = false;
		this.activeSelect = false;
	}

	public void paint(Graphics g) {
		Figure tmp;
		Graphics2D g2D = (Graphics2D) g;
		g2D.scale(amodel.getScale() / 100, amodel.getScale() / 100);
		g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
		g2D.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BICUBIC);
		switch (acontroller.getMode()) {
		case DRAW:
			if (activeDrawing) {
				tmp = createTmpFigure();
				if (tmp != null)
					tmp.paint(g);
				previewRectangle(g2D);
			}
			break;
		case SELECT:
			if (activeSelect){
				previewRectangleSelecting(g2D);
			}
			tmp = fcontroller.getFigureCourante();
			if (tmp != null)
				tmp.previewSelect(g2D);
			break;
		case MOVE:
			tmp = fcontroller.getFigureCourante();
			if (tmp != null)
				tmp.previewSelect(g2D);
			break;
		case TRANSLATE:
			tmp = fcontroller.getFigureCourante();
			if (tmp != null)
				tmp.previewSelect(g2D);
			break;
		}
	}

	private Figure createTmpFigure() {
		int x = mmodel.getMouseX();
		int y = mmodel.getMouseY();
		int pressX = mmodel.getMousePressedX();
		int pressY = mmodel.getMousePressedY();
		return figureFactory.createFigure(new Point2D.Double(pressX, pressY),new Point2D.Double(x, y));
	}

	private void previewRectangle(Graphics2D g2D) {
		double x2 = mmodel.getMouseX();
		double y2 = mmodel.getMouseY();
		double x1 = mmodel.getMousePressedX();
		double y1 = mmodel.getMousePressedY();
		double tmp;
		g2D.setPaint(Color.BLUE);
		float[] stroke = { 5, 2, 5, 2 };
		if (x1>x2) { tmp=x1; x1=x2; x2=tmp; }
		if (y1>y2) { tmp=y1; y1=y2; y2=tmp; }
		g2D.rotate(Math.toRadians(acontroller.getAngle()),x1+((x2-x1)/2),y1+((y2-y1)/2));
		g2D.setStroke(new BasicStroke(1, BasicStroke.CAP_SQUARE,BasicStroke.JOIN_BEVEL, 10, stroke, 0));
		if (amodel.getType()==14){
			if (x2-x1>y2-y1) g2D.draw(new Rectangle2D.Double(x1, y1, x2-x1, x2-x1));
			if (x2-x1<y2-y1) g2D.draw(new Rectangle2D.Double(x1, y1, y2-y1,y2-y1));
		}else{
			g2D.draw(new Rectangle2D.Double(x1, y1, x2-x1, y2-y1));
		}
		g2D.rotate(-Math.toRadians(acontroller.getAngle()), x1+((x2-x1)/2),y1+((y2-y1)/2));
	}
	
	private void previewRectangleSelecting(Graphics2D g2D) {
		double x2 = mmodel.getMouseX();
		double y2 = mmodel.getMouseY();
		double x1 = mmodel.getMousePressedX();
		double y1 = mmodel.getMousePressedY();
		double tmp;
		if (x1>x2) { tmp=x1; x1=x2; x2=tmp; }
		if (y1>y2) { tmp=y1; y1=y2; y2=tmp; }
		Rectangle2D.Double select = new Rectangle2D.Double(x1, y1, x2-x1, y2-y1);
		g2D.setPaint(Color.BLUE);
		g2D.draw(select);
		g2D.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.1f));
		g2D.fill(select);
	}


	public void mouseDragged(MouseEvent e) {
		acontroller.setMouse(e.getX(), e.getY());
		switch (acontroller.getMode()) {
		case DRAW:
			repaint();
			break;
		case MOVE:
			if (fcontroller.getFigureCourante() != null) {
				fcontroller.move();
				acontroller.setMaxMouse();
				repaint();
			}
			break;
//		case SELECT:
//			repaint();
		}
	}

	public void mouseMoved(MouseEvent e) {
		acontroller.setMouse(e.getX(), e.getY());
	}

	public void mouseClicked(MouseEvent e) {
		switch (acontroller.getMode()) {
		case SELECT:
			fcontroller.checkFigure();
			fcontroller.changeFigureProperties();
			repaint();
			break;
		case TRANSLATE:
			if (fcontroller.getFigureCourante() != null) {
				fcontroller.translate();
				fcontroller.replace();
				acontroller.setMaxMouse();
				repaint();
			}
			fcontroller.checkFigure();
		case MOVE:
			fcontroller.deselectAll(); // It's for deselect the figure I've select in an other mode
			fcontroller.checkFigure();
			repaint();
			break;
		case ROTATE:
			fcontroller.checkFigure();
			fcontroller.changeRotate();
			repaint();
			break;
		}
	}

	public void mouseEntered(MouseEvent arg0) {
	}

	public void mouseExited(MouseEvent arg0) {
	}

	public void mousePressed(MouseEvent e) {
		acontroller.setMousePressed(e.getX(), e.getY());
		switch (acontroller.getMode()) {
		case DRAW:
			acontroller.setAngle(0);
			this.activeDrawing = true;
			break;
		case MOVE:
			fcontroller.deselectAll(); // It's for deselect the figure I've select in an other mode
			fcontroller.checkFigure();
			repaint();
			break;
		case SELECT:
			this.activeSelect = true;
			break;
		}
	}

	public void mouseWheelMoved(MouseWheelEvent e) {
		if (e.getWheelRotation() < 0 && e.isControlDown()) {
			acontroller.incrementZoom();
		}
		if (e.getWheelRotation() > 0 && e.isControlDown()) {
			acontroller.decrementZoom();
		}
	}

	public void mouseReleased(MouseEvent e) {
		switch (acontroller.getMode()) {
		case SELECT:
			this.activeSelect = false;
//			fcontroller.checkFigureOnDrag(e.getX(), e.getY());
//			fcontroller.changeFigureProperties();
//			repaint();
			break;
		case MOVE:
			fcontroller.replace();
			fcontroller.deselectAll();
			break;
		case DRAW:
			acontroller.setAngle(0);
			this.activeDrawing = false;
			fcontroller.createFigure();
			break;
		}
		acontroller.resetDrag();
		repaint();
	}
}
