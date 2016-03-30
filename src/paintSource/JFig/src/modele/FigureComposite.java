
package modele;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Shape;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Iterator;


public class FigureComposite extends Figure{
	
	public FigureComposite(){
	}
	
	public FigureComposite(Point2D point1, Point2D point2, Color borderColor, Color fillColor, int stroke, int angle){
		super(point1, point2, borderColor, borderColor, stroke, angle);
	}

	private ArrayList<Figure> mChildFigure = new ArrayList<Figure>();
	   
	public void paint(Graphics g) {
	     Iterator<Figure> iter = mChildFigure.iterator();
	     while(iter.hasNext()){
	    	 iter.next().paint(g);
	     }
	} 
	    
	public void add(Figure figure) {
		mChildFigure.add(figure);
	}
	    
	public void set(int index, Figure figure){
	    mChildFigure.set(index,figure);
	}  
	
	public void remove(int index){
		mChildFigure.remove(index);
	}
	 
    public void remove(Figure figure) {
	    mChildFigure.remove(figure);
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
		
	public boolean contains(Point2D p) {
		Iterator<Figure> iter = mChildFigure.iterator();
	     while(iter.hasNext()){
	    	 Shape s = iter.next().getShape();
	    	 return s.contains(p);
	     }
	     return false;
	}

	public int getType() {
		Iterator<Figure> iter = mChildFigure.iterator();
	     while(iter.hasNext()){
	    	return iter.next().getType();
	     }
	     return -1;
	}
	
	public void setStroke(int i){
		Iterator<Figure> iter = mChildFigure.iterator();
	     while(iter.hasNext()){
	    	iter.next().setStroke(i);
	     }
	}
	
	public void setBorderColor(Color c){
		Iterator<Figure> iter = mChildFigure.iterator();
	     while(iter.hasNext()){
	    	iter.next().setBorderColor(c);
	     }
	}
	
	public void setFillColor(Color c){
		Iterator<Figure> iter = mChildFigure.iterator();
	     while(iter.hasNext()){
	    	iter.next().setFillColor(c);
	     }
	}
	
	public Point2D getMinOrigin(Figure figure){
		Point2D minOrigin;
		Point2D origin;
		Iterator<Figure> iter = mChildFigure.iterator();
		minOrigin = iter.next().getOrigin();
	     while(iter.hasNext()){
	    	 origin=iter.next().getOrigin();
	    	 if(origin.getX() < minOrigin.getX()){
	    	 minOrigin = origin;
	    	 }
	     }
	     return minOrigin;	
	}
}