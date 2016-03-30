package modele;

import java.util.ArrayList;
import java.util.List;

import vue.observer;

public abstract class observable {
	
	   private List<observer> observers = new ArrayList<observer>();

	   public void attach(observer observer){
	      observers.add(observer);		
	   }
	   
	   public void detach(observer observer){
		   observers.remove(observer);
	   }

	   public void notifyAllObservers(){
	      for (observer observer : observers) {
	         observer.update();
	      }
	   } 	

}
