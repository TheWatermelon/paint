package versionZero.model;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;



public class FigureLine extends Figure{
	
	private  Line2D.Double shape2d;
	
	public FigureLine (Point2D point1, Point2D point2, Color borderColor,Color fillColor, int stroke, int angle){  
		super(point1, point2, borderColor, fillColor, stroke, angle);
		shape2d=new Line2D.Double (x1,y1,x2,y2);
	}
	
	public FigureLine (Point2D point1, Point2D point2,Color fillColor){  
		super(point1, point2, null, fillColor, 0, 0);
		shape2d=new Line2D.Double (x1,y1,x2,y2);
	}
	
	public void draw(Graphics g){
		g.setColor(fillColor);
		g.drawLine((int)x1,(int) y1,(int) x2, (int)y2);
	}
	
	public String toString(){
		
		return "x1 : "+x1+" y1 : "+y1+" x2 : "+x2+" y2 : "+y2;
		
	}

}
