package versionZero.model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Observable;

public abstract class Figure{
	
	protected Color borderColor,fillColor;
	protected int stroke, alpha, angle;
	protected double x1,y1,x2,y2,tmp;
	protected Point2D origin,end;
	
	
	public Figure(){
	}
	
	public Figure(Point2D point1, Point2D point2, Color borderColor, Color fillColor, int stroke, int angle){
		x1=point1.getX();
		y1=point1.getY();
		x2=point2.getX();
		y2=point2.getY();
		this.origin=point1;
		this.end = point2;
		this.borderColor=borderColor;
		this.fillColor=fillColor;
		this.stroke=stroke;
		this.angle=angle;
	}


	
	
	
	public double getX1() {
		return x1;
	}
	public void setX1(double x1){
		this.x1 = x1;
		
	}
	
	public double getX2(){
		return x2;
	}
	public void setX2(double x2) {
		this.x2 = x2;
		
	}
	
	public double getY1() {
		return y1;
	}
	public void setY1(double y1) {
		this.y1 = y1;

	}
	
	public double getY2() {
		return y2;
	}
	public void setY2(double y2) {
		this.y2 = y2;
		
	}
	
	public abstract void draw(Graphics g);



}
