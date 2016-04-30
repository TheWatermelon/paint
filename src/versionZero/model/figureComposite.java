package versionZero.model;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;



public class figureComposite extends Figure{

	
	private ArrayList<Figure> mChildFigure = new ArrayList<Figure>();
	
	
	
	public void add(Figure figure) {
		mChildFigure.add(figure);
	}
	    
	public void set(int index, Figure figure){
	    mChildFigure.set(index,figure);
	}  
	
	public void setListFigure(ArrayList<Figure> ChildFigure){
	    mChildFigure = ChildFigure;
	}  
	
	public void remove(int index){
		mChildFigure.remove(index);
	}
	 
    public void remove(Figure figure) {
	    mChildFigure.remove(figure);
	}
    
    public void removeAll() {
	    mChildFigure.removeAll(getList());
	}
	    
	public Figure getChild(int i){
	    return  mChildFigure.get(i);
	}
	    
	public String toString(){
		String line="";
		Iterator<Figure> iter = mChildFigure.iterator();
		while(iter.hasNext()){
		    line = line + iter.next().toString() + "\n";
		}
		return line;
	}
		
	public boolean isEmpty() {
		return mChildFigure.isEmpty();
	}
		
	public int countElement(){
		return mChildFigure.size();
	}
		
	public ArrayList<Figure> getList(){
		return mChildFigure;
	
	}
	
	public Figure getLast(){
		
		return mChildFigure.get(mChildFigure.size()-1);
		
	}
		
	
	@Override
	public void draw(Graphics g) {
		Iterator<Figure> iter = mChildFigure.iterator();
	     while(iter.hasNext()){
	    	 iter.next().draw(g);
	     }
		
	}

}
