package versionZero.model;

import java.awt.Font;
import java.awt.font.TextLayout;
import java.util.ArrayList;
import java.util.Observable;

import versionZero.vue.Dessin;
import versionZero.vue.RTextLayout;

public class DessinModel extends Observable{
	
	public static final int PAINT_MODE = 0;
	public static final int MOVE_MODE = 1;
	public static final int VECTOR_MODE = 2;
	
	private ArrayList<RTextLayout> textList;
	private ArrayList<Figure> figList;
	
	private int mode = 0;
	
	public DessinModel(){
		textList = new ArrayList<RTextLayout>();
		figList = new ArrayList<Figure>();
	}
	
	public void add(RTextLayout t){
		textList.add(t);
		this.setChanged();
		this.notifyObservers();
	}
	
	public void add(Figure fig){
		
		figList.add(fig);
		this.setChanged();
		this.notifyObservers();
		
	}
	
	public ArrayList<RTextLayout> getList(){
		return textList;
	}
	
	public ArrayList<Figure> getListFigure(){
		return figList;
	}
	
	public void setListFigure(ArrayList<Figure> figure){
		
		figList = figure;
		this.setChanged();
		this.notifyObservers();
		
		
	}
	
	public void setFigure(int index,Figure figure){
		
		figList.set(index, figure);
		this.setChanged();
		this.notifyObservers();
		
		
	}
	
	public Figure getFigure(int index){
		
		return figList.get(index);
		
	}

	public void clear(){
		textList.clear();
		figList.clear();
		this.setChanged();
		this.notifyObservers();
	}

	public void addText(String text, Font f,Dessin d) {
		TextLayout t = new TextLayout(text,f,Dessin.getPinceau().getFontRenderContext());
		RTextLayout rt = new RTextLayout(this,t,(float)(d.getWidth()/2 - t.getBounds().getWidth()/2),
				(float)(d.getHeight()/2 - t.getBounds().getHeight()/2));
		add(rt);
	}

	public void setMode(int moveMode) {
		this.mode = moveMode;
	}

	public int getMode() {
		return mode;
	}
	
	
}
