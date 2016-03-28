/**
 * 
 * @autor Nolwenn Roger
 **/

package ca.uds.jfig.figures;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.geom.Point2D;

public class FigArrowFill extends FigureLine{

	public FigArrowFill (Point2D point1, Point2D point2, Color borderColor,Color fillColor, int stroke, int angle){  
		super(point1, point2, borderColor, fillColor, stroke, angle);
	}

	public void paint (Graphics g){ 
		Graphics2D g2 = (Graphics2D) g;
		if (x1 != x2 | y1 != y2){
			g2.rotate(Math.toRadians(this.angle), this.getX1()+((this.getX2()-this.getX1())/2), this.getY1()+((this.getY2()-this.getY1())/2));
			g2.setColor (borderColor);
			g2.setStroke(new BasicStroke(stroke, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
			headArrow(x1,y1,x2,y2);
			Polygon p=new Polygon (pointx, pointy, 3);
			g2.setColor (borderColor);
			g2.draw (this.shape2d);
			g2.fillPolygon(p);
			g2.draw (p);
			g2.rotate(-Math.toRadians(this.angle), this.getX1()+((this.getX2()-this.getX1())/2), this.getY1()+((this.getY2()-this.getY1())/2));
		}
	}

	public String toString(){
		return ARROWFILL+" "+(int)this.x1+" "+(int)this.y1+" "+(int)this.x2+" "+(int)this.y2+" "+this.getBorderColor().getRed()+" "+this.getBorderColor().getGreen()+" "+this.getBorderColor().getBlue()+" "+this.getBorderColor().getAlpha()+" "+this.getFillColor().getRed()+" "+this.getFillColor().getGreen()+" "+this.getFillColor().getBlue()+" "+this.getFillColor().getAlpha()+" "+this.getStroke()+" "+this.getAngle();
	}
	
	public int getType() {
		return ARROWFILL;
	}
}
