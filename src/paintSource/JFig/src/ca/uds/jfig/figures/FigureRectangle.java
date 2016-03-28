package ca.uds.jfig.figures;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.Point2D;

public abstract class FigureRectangle extends Figure{
	
	public FigureRectangle(Point2D point1, Point2D point2, Color borderColor, Color fillColor, int stroke, int angle){
		super(point1, point2, borderColor, fillColor, stroke, angle);
		if (x1>x2) { tmp=x2; x2=x1; x1=tmp;}
		if (y1>y2) { tmp=y2; y2=y1; y1=tmp;}
	}
	
	public void paint(Graphics g){
	}
}
