/**
 * 
 * @autor Florian Bonniec
 * @worker
 * 
 **/
package ca.uds.jfig.application;
import java.awt.Color;
import java.awt.geom.Point2D;
import java.util.Observable;

import ca.uds.jfig.figures.FigRoundRectangle;
import ca.uds.jfig.figures.Figure;
import ca.uds.jfig.figures.FigureComposite;

public class FigureModel extends Observable {
	private Figure jFigure = new FigureComposite();
	private Color fillColor = Color.white;
	private Figure figureCourante;
	private int indexCourant = -1;
	private Point2D i = new Point2D.Double(1,2);
	private Point2D j = new Point2D.Double(1,2);
	private Figure last = new FigRoundRectangle(i, j, Color.BLACK, Color.WHITE,2,0);
	
	
	public Figure getFigureList() {
		return jFigure;
	}
	
	public void setFigureList(Figure jFigure){
		this.jFigure = jFigure;
		setChanged();notifyObservers();
	}

	public Color getFillColor() {
		return fillColor;
	}

	public void setFillColor(Color fillColor) {
		this.fillColor = fillColor;
	}

	public Figure getFigureCourante() {
		return figureCourante;
	}

	public void setFigureCourante(Figure figureCourante) {
		this.figureCourante = figureCourante;
	}

	public int getIndexCourant() {
		return indexCourant;
	}

	public void setIndexCourant(int indexCourant) {
		this.indexCourant = indexCourant;
	}
	
	public Figure getLast() {
		return last;
	}

	public void setLast(Figure last) {
		this.last = last ;
	}
}
