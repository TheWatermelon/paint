package versionZero.vue;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.font.TextLayout;

public class RTextLayout{
	private TextLayout text;

	private float posX,posY;
	
	public RTextLayout(DessinModel m,TextLayout t,float x, float y){
		text =t;
		posX = x;
		posY = y;		
	}
	
	public void draw(Graphics g){
		text.draw((Graphics2D) g, posX, posY);
	}

	public boolean isHit(int courantX, int courantY) {
		if(courantX < posX+text.getBounds().getWidth() && courantX > posX 
			&& courantY < posY && courantY > posY-text.getBounds().getHeight() )
			return true;
		else{
			return false;
		}
	}

	public void move(int x, int y) {
		posX=x;
		posY=y;
		
	}

	public int getWidth() {
		return (int) text.getBounds().getWidth();
	}
	public int getHeight() {
		return (int) text.getBounds().getHeight();
	}
	

}
