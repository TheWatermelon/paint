
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
import java.awt.geom.Rectangle2D;

public class FigCircle extends FigureRound{
	
	private double x21,y21;
	
	public FigCircle(Point2D point1, Point2D point2, Color borderColor,Color fillColor, int stroke, int angle){
		super(point1, point2, borderColor, fillColor, stroke, angle);
		x21=x2-x1;
		y21=y2-y1;
		if (x21>y21) { y21=x21; y2=y1+y21; x2=x1+y21; }
		if (x21<y21) { x21=y21; x2=x1+x21; y2=y1+x21; }
		shape2d=new Ellipse2D.Double(x1,y1,x21,y21);
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
		return CIRCLE+" "+(int)this.x1+" "+(int)this.y1+" "+(int)this.x2+" "+(int)this.y2+" "+this.getBorderColor().getRed()+" "+this.getBorderColor().getGreen()+" "+this.getBorderColor().getBlue()+" "+this.getBorderColor().getAlpha()+" "+this.getFillColor().getRed()+" "+this.getFillColor().getGreen()+" "+this.getFillColor().getBlue()+" "+this.getFillColor().getAlpha()+" "+this.getStroke()+" "+this.getAngle();
	}
	
	public int getType() {
		return CIRCLE;
	}
	
	public void move(double x,double y){
		this.switchOriginEnd();
		if ((this.getX2()-this.getX1()) > (this.getY2()-this.getY1())){
			this.shape2d.setFrame(this.getOrigin().getX()+x, this.getOrigin().getY()+y, this.getX2()-this.getX1(), this.getX2()-this.getX1());
		}else{
			this.shape2d.setFrame(this.getOrigin().getX()+x, this.getOrigin().getY()+y, this.getY2()-this.getY1(), this.getY2()-this.getY1());
		}
	}
	public void previewSelect(Graphics2D g2D) {
		double x1,x2,y1,y2,tmp;
		if (this != null) {
			g2D.rotate(Math.toRadians(this.getAngle()),this.getX1()+((this.getX2()-this.getX1())/2), this.getY1()+((this.getY2()-this.getY1())/2));
			g2D.setPaint(Color.RED);
			float[] stroke = { 5, 2, 5, 2 };
			g2D.setStroke(new BasicStroke(1, BasicStroke.CAP_SQUARE,BasicStroke.JOIN_BEVEL, 10, stroke, 0));
			x1=this.getX1();
			x2=this.getX2();
			y1=this.getY1();
			y2=this.getY2();
			if (x1>x2) { tmp=x1; x1=x2; x2=tmp; }
			if (y1>y2) { tmp=y1; y1=y2; y2=tmp; }
			if (x2-x1<y2-y1){
				g2D.draw(new Rectangle2D.Double(x1, y1, y2-y1, y2-y1));
			} else {
				g2D.draw(new Rectangle2D.Double(x1, y1, x2-x1, x2-x1));
			}
			g2D.rotate(-Math.toRadians(this.getAngle()),this.getX1()+((this.getX2()-this.getX1())/2), this.getY1()+((this.getY2()-this.getY1())/2));
		}
	}
}
