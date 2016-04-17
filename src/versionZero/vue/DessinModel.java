package versionZero.vue;

import java.awt.Font;
import java.awt.font.TextLayout;
import java.util.ArrayList;
import java.util.Observable;

public class DessinModel extends Observable{
	public static final int PAINT_MODE = 0;
	public static final int MOVE_MODE = 1;
	private ArrayList<RTextLayout> textList;
	private int mode = 0;
	
	public DessinModel(){
		textList = new ArrayList<RTextLayout>();
	}
	
	public void add (RTextLayout t){
		textList.add(t);
		this.setChanged();
		this.notifyObservers();
	}
	
	public ArrayList<RTextLayout> getList(){
		return textList;
	}

	public void clear(){
		textList.clear();
		this.setChanged();
		this.notifyObservers();
	}

	public void addText(String text, Font f,Dessin d) {
		TextLayout t = new TextLayout(text,f,Dessin.toile.getFontRenderContext());
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
