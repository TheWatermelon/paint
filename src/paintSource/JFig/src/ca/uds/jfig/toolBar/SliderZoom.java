package ca.uds.jfig.toolBar;

import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import ca.uds.jfig.application.ApplicationController;

@SuppressWarnings("serial")
public class SliderZoom extends JPanel implements Observer{
	private int ZOOM_MIN = 1;
	private int ZOOM_MAX = 200;
	private int ZOOM_INIT = 100;
	private ApplicationController acontroller;
	public JSlider zoomSlider;

	public SliderZoom(ApplicationController acontroller){
		zoomSlider = new JSlider(JSlider.HORIZONTAL,
	            ZOOM_MIN, ZOOM_MAX, ZOOM_INIT);
		this.acontroller=acontroller;
		this.acontroller.addObserver(this);
		zoomSlider.setMajorTickSpacing(100);
		zoomSlider.setMinorTickSpacing(5);
		zoomSlider.setPaintTicks(false);
		zoomSlider.setPaintLabels(false);
		zoomSlider.setPreferredSize(new Dimension(90,20));
		zoomSlider.setValue((int)acontroller.getScale());
		zoomSlider.addChangeListener(new SlideListener());
		this.add(zoomSlider);
	}
	
	public SliderZoom(ApplicationController acontroller,int min,int max, int init){
		zoomSlider = new JSlider(JSlider.HORIZONTAL,
	            min, max, init);
		this.acontroller=acontroller;
		this.acontroller.addObserver(this);
		zoomSlider.setMajorTickSpacing(100);
		zoomSlider.setMinorTickSpacing(5);
		zoomSlider.setPaintTicks(false);
		zoomSlider.setPaintLabels(false);
		zoomSlider.setPreferredSize(new Dimension(90,20));
		zoomSlider.setValue((int)acontroller.getScale());
		zoomSlider.addChangeListener(new SlideListener());
		this.add(zoomSlider);
	}

	class SlideListener implements ChangeListener{

		public void stateChanged(ChangeEvent e) {
			acontroller.setScale(zoomSlider.getValue());
			
		}
	}
	@Override
	public void update(Observable o, Object arg) {
		zoomSlider.setValue((int)acontroller.getScale());
	}
	
		
}
