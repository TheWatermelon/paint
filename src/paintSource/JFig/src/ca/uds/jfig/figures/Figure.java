/**
 * @author Nolwenn ROGER
 * **/

package ca.uds.jfig.figures;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import ca.uds.jfig.jfigInterface.ArrowInterface;
import ca.uds.jfig.jfigInterface.FigureInterface;

public abstract class Figure implements FigureInterface, ArrowInterface{
	
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

	public void paint(Graphics g){
	}
	
	public void switchOriginEnd(){
		Point2D tmp = new Point2D.Double();
		tmp = this.getOrigin();
		if (this.getOrigin().getX() < this.getEnd().getX()
				&& this.getOrigin().getY() < this.getEnd().getY()) {
		}else if (this.getOrigin().getX() > this.getEnd().getX()
				&& this.getOrigin().getY() > this.getEnd().getY()) {
			this.setOrigin(this.getEnd());
			this.setEnd(tmp);
		} else if (this.getOrigin().getX() > this.getEnd().getX()
				&& this.getOrigin().getY() < this.getEnd().getY()) {
			this.setOrigin(new Point2D.Double(this.getEnd().getX(), this
					.getOrigin().getY()));
			this.setEnd(new Point2D.Double(tmp.getX(), this.getEnd().getY()));
		} else {
			this.setOrigin(new Point2D.Double(this.getOrigin().getX(), this
					.getEnd().getY()));
			this.setEnd(new Point2D.Double(this.getEnd().getX(), tmp.getY()));
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
			g2D.draw(new Rectangle2D.Double(x1, y1, x2-x1, y2-y1));
			g2D.rotate(-Math.toRadians(this.getAngle()),this.getX1()+((this.getX2()-this.getX1())/2), this.getY1()+((this.getY2()-this.getY1())/2));
		}
	}
	
	public String toString(){
		throw new UnsupportedOperationException();
	}
	
	public void add(Figure figure) {
    	throw new UnsupportedOperationException();
    }
	
	public void remove(Figure figure) {
    	throw new UnsupportedOperationException();
    }
	
    public void set(int index, Figure figure){
    	throw new UnsupportedOperationException();
    }
	
	public ArrayList<Figure> getList(){
		throw new UnsupportedOperationException();
	}
    
    public void remove(int index){
    	throw new UnsupportedOperationException();
    }
	
	public Figure getChild(int i){
		throw new UnsupportedOperationException();	
	}
	
	public void setBorderColor(Color color){
	   borderColor = color;
	}
	public Color getBorderColor(){
	   return borderColor;
	}
		
	public void setFillColor(Color color){
		fillColor = color;
	}
	public Color getFillColor(){
		return fillColor;
	}
	
	public int getStroke(){
		return stroke;
	}
	public void setStroke(int s){
		stroke = s;
	}
	
	public int getAngle(){
		return angle;
	}
	public void setAngle(int a){
		angle = a;
	}
		
	public int getAlpha() {
		return alpha;
	}
	public void setAlpha(int alpha) {
		this.alpha = alpha;
	}

	public int countElement(){
		throw new UnsupportedOperationException();
	}
	
	public boolean isEmpty() {
		throw new UnsupportedOperationException();	
	}
	
	public Shape getShape(){
		throw new UnsupportedOperationException();
	}
	
	public boolean contains(Point2D p) {
		return this.contains(p);
	}
	
	public void move(double x,double y){
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

	public Point2D getEnd() {
		return end;
	}
	public void setEnd(Point2D end) {
		this.end = end;
	}

	public Point2D getOrigin() {
		return origin;
	}
	public void setOrigin(Point2D origin) {
		this.origin = origin;
	}

	public void setType(int type) {
	}
	public int getType(){
		throw new UnsupportedOperationException();
	}
	
	public Point2D getMinOrigin(Figure figure){
		throw new UnsupportedOperationException();
	}
}
