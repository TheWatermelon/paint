/**
 * @author Nolwenn ROGER
 * 
 **/

package ca.uds.jfig.figures;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

public class FigRectangle extends FigureRectangle {

	private  Rectangle2D.Double shape2d;
	
	public FigRectangle(Point2D point1, Point2D point2, Color borderColor, Color fillColor, int stroke, int angle){
		super(point1, point2, borderColor, fillColor, stroke, angle);
		this.shape2d = new Rectangle2D.Double(x1, y1, x2 - x1, y2 - y1);
	}

	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		if (x1 != x2 | y1 != y2){
			g2.rotate(Math.toRadians(this.angle), this.getX1()+((this.getX2()-this.getX1())/2), this.getY1()+((this.getY2()-this.getY1())/2));
			g2.setPaint(this.fillColor);
			g2.fill(this.shape2d);
			g2.setStroke(new BasicStroke(stroke, BasicStroke.CAP_ROUND,BasicStroke.JOIN_MITER));
			g2.setPaint(this.borderColor);
			g2.draw(this.shape2d);
			g2.rotate(-Math.toRadians(this.angle), this.getX1()+((this.getX2()-this.getX1())/2), this.getY1()+((this.getY2()-this.getY1())/2));
		}
	}

	public String toString() {
		return RECTANGLE + " " + (int) this.x1 + " " + (int) this.y1 + " "+ (int) this.x2 + " " + (int) this.y2 + " "+ this.getBorderColor().getRed() + " "+ this.getBorderColor().getGreen() + " "+ this.getBorderColor().getBlue() + " "+ this.getBorderColor().getAlpha() + " "+ this.getFillColor().getRed() + " "+ this.getFillColor().getGreen() + " "+ this.getFillColor().getBlue() + " "+ this.getFillColor().getAlpha() + " " + this.getStroke() + " "+ this.getAngle();
	}

	public Rectangle2D.Double getShape() {
		return shape2d;
	}

	public void move(double x, double y) {
		this.switchOriginEnd();
		this.shape2d.setRect(this.getOrigin().getX() + x, this.getOrigin()
				.getY() + y, this.getX2() - this.getX1(), this.getY2()
				- this.getY1());
	}

	public int getType() {
		return RECTANGLE;
	}

	public boolean contains(Point2D p) {
		return this.shape2d.contains(p);
	}
}
