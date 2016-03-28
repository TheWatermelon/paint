package ca.uds.jfig.application;

import java.util.Observable;

public class MouseModel extends Observable{
	private int mouseX;
	private int mouseY;
	private int mousePressedX;
	private int mousePressedY;
	private int mouseDragX;
	private int mouseDragY;
	private int mouseShiftX;
	private int mouseShiftY;
	
	public MouseModel(){
		mousePressedX = -1;
		mousePressedY = -1;
	}
	
	public int getMouseShiftX() {
		return mouseShiftX;
	}
	
	public void setMouseShiftX(int mouseShiftX) {
		this.mouseShiftX = mouseShiftX;
	}
	
	public int getMouseShiftY() {
		return mouseShiftY;
	}
	
	public void setMouseShiftY(int mouseShiftY) {
		this.mouseShiftY = mouseShiftY;
	}

	public int getMouseX() {
		return mouseX;
	}

	public void setMouseX(int mouseX) {
		this.mouseX = mouseX;
	}
	
	public void setMouseY(int mouseY){
		this.mouseY = mouseY;
	}

	public int getMouseY() {
		return mouseY;
	}


	public int getMousePressedX() {
		return mousePressedX;
	}

	public void setMousePressedX(int mousePressedX) {
		this.mousePressedX = mousePressedX;
	}

	public int getMousePressedY() {
		return mousePressedY;
	}

	public void setMousePressedY(int mousePressedY) {
		this.mousePressedY = mousePressedY;
	}

	public int getMouseDragX() {
		return mouseDragX;
	}

	public void setMouseDragX(int mouseDragX) {
		this.mouseDragX = mouseDragX;
	}

	public int getMouseDragY() {
		return mouseDragY;
	}

	public void setMouseDragY(int mouseDragY) {
		this.mouseDragY = mouseDragY;
	}
	
	public void validate() {
		setChanged();
		notifyObservers();
	}
}
