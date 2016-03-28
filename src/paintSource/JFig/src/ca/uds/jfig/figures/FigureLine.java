package ca.uds.jfig.figures;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

public abstract class FigureLine extends Figure{
	
	protected  Line2D.Double shape2d;
	int[] pointx = new int[3], pointy = new int[3] ;
	private static final double angleArrow = Math.PI/8, l=25;
	
	public FigureLine (Point2D point1, Point2D point2, Color borderColor,Color fillColor, int stroke, int angle){  
		super(point1, point2, borderColor, fillColor, stroke, angle);
		shape2d=new Line2D.Double (x1,y1,x2,y2);
	}

	public void paint (Graphics g){ 
	}

	protected void headArrow(double x1, double y1, double x2, double y2){  
		double r,a,beta,theta;
		if (x1!=x2 | y1!=y2){
			pointx[2]=(int)x2;
			pointy[2]=(int)y2;
			r = Math.sqrt ((x2-x1)*(x2-x1) + (y2-y1)*(y2-y1));	
			a = Math.sqrt (l*l + r*r - 2*l*r*Math.cos(angleArrow));
			beta = Math.asin (l*Math.sin(angleArrow)/a);
			if (x2>x1){
				theta = Math.atan((y1-y2)/(x2-x1));
				pointx[1] = (int) (x1 + a * Math.cos(theta - beta));
				pointx[0] = (int) (x1 + a * Math.cos(theta + beta));
			} else {
				theta = Math.atan((y1-y2)/(x1-x2));
				pointx[1] = (int) (x1 - a * Math.cos(theta - beta));
				pointx[0] = (int) (x1 - a * Math.cos(theta + beta));
			}
			pointy[1] = (int) (y1 - a * Math.sin(theta - beta));
			pointy[0] = (int) (y1 - a * Math.sin(theta + beta));
			}
	}
	
	public Line2D.Double getShape() {
		return shape2d;
	}

	public boolean contains(Point2D p) {
		double dist = this.shape2d.ptSegDist(p.getX(), p.getY());
		if(dist<30&&dist>-30){
			return true;
		}else{
			return false;
		}
	}
		
	public void move(double x,double y){
		this.shape2d.setLine(this.getOrigin().getX()+x, this.getOrigin().getY()+y, this.getEnd().getX()+x, this.getEnd().getY()+y);
	}
}
