
/**
 * @author Nolwenn ROGER 
 * @worker florian bonniec
 * **/

package ca.uds.jfig.figures;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;

public class FigOval extends FigureRound{
	
	public FigOval(Point2D point1, Point2D point2, 
			Color borderColor,Color fillColor, int stroke, int angle){
		super(point1, point2, borderColor, fillColor, stroke, angle);
		shape2d=new Ellipse2D.Double(x1,y1,x2-x1,y2-y1);
	}

	public void paint(Graphics g){
		Graphics2D g2=(Graphics2D)g;
		if (x1 != x2 | y1 != y2){
			g2.rotate(Math.toRadians(this.angle), this.getX1()+((this.getX2()-this.getX1())/2), this.getY1()+((this.getY2()-this.getY1())/2));
			g2.setPaint(this.fillColor);
			g2.fill(this.shape2d);
			g2.setStroke(new BasicStroke(stroke, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
			g2.setPaint(this.borderColor);
			g2.draw(this.shape2d);
			g2.rotate(-Math.toRadians(this.angle), this.getX1()+((this.getX2()-this.getX1())/2), this.getY1()+((this.getY2()-this.getY1())/2));
		}	
	}
	
	public String toString(){
		return OVAL +" "+(int)this.x1+" "+(int)this.y1+" "+(int)this.x2+" "+(int)this.y2+" "+this.getBorderColor().getRed()+" "+this.getBorderColor().getGreen()+" "+this.getBorderColor().getBlue()+" "+this.getBorderColor().getAlpha()+" "+this.getFillColor().getRed()+" "+this.getFillColor().getGreen()+" "+this.getFillColor().getBlue()+" "+this.getFillColor().getAlpha()+" "+this.getStroke()+" "+this.getAngle();
	}
	
	public int getType() {
		return OVAL;
	}
	
	public void move(double x,double y){
		this.switchOriginEnd();
		this.shape2d.setFrame(this.getOrigin().getX()+x, this.getOrigin().getY()+y, this.getX2()-this.getX1(), this.getY2()-this.getY1());
	}
}
