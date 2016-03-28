/**
 * 
 * @autor Nolwenn Roger
 * 
 **/

package ca.uds.jfig.figures;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

public class FigArrowDouble extends FigureLine{

	public FigArrowDouble (Point2D point1, Point2D point2, Color borderColor,Color fillColor, int stroke, int angle){  
		super(point1, point2, borderColor, fillColor, stroke, angle);
	}

	public void paint (Graphics g){ 
		Graphics2D g2 = (Graphics2D) g;
		if (x1 != x2 | y1 != y2){
			g2.rotate(Math.toRadians(this.angle), this.getX1()+((this.getX2()-this.getX1())/2), this.getY1()+((this.getY2()-this.getY1())/2));
			g2.setColor (borderColor);
			g2.setStroke (new BasicStroke(stroke, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
			g2.draw (shape2d);
			headArrow(x1,y1,x2,y2);
			g2.draw (new Line2D.Double (pointx[2],pointy[2],pointx[1],pointy[1]));
			g2.draw (new Line2D.Double (pointx[2],pointy[2],pointx[0],pointy[0]));
			headArrow(x2,y2,x1,y1);
			g2.draw (new Line2D.Double (pointx[2],pointy[2],pointx[1],pointy[1]));
			g2.draw (new Line2D.Double (pointx[2],pointy[2],pointx[0],pointy[0]));
			g2.rotate(-Math.toRadians(this.angle), this.getX1()+((this.getX2()-this.getX1())/2), this.getY1()+((this.getY2()-this.getY1())/2));
		}
	}
		
	public String toString(){
		return ARROWDOUBLE+" "+(int)this.x1+" "+(int)this.y1+" "+(int)this.x2+" "+(int)this.y2+" "+this.getBorderColor().getRed()+" "+this.getBorderColor().getGreen()+" "+this.getBorderColor().getBlue()+" "+this.getBorderColor().getAlpha()+" "+this.getFillColor().getRed()+" "+this.getFillColor().getGreen()+" "+this.getFillColor().getBlue()+" "+this.getFillColor().getAlpha()+" "+this.getStroke()+" "+this.getAngle();
	}
	
	public int getType() {
		return ARROWDOUBLE;
	}
}
