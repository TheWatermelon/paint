package ca.uds.jfig.toolBar;

import java.awt.*;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import ca.uds.jfig.application.ApplicationController;

@SuppressWarnings("serial")
public class SpinnerRotation extends JPanel implements Observer{
	JSpinner rotationSpinner;
	private ApplicationController acontroller;
	SpinnerModel modelSpinner;
	public SpinnerRotation(ApplicationController acontroller) {
		this.acontroller=acontroller;
		this.acontroller.addObserver(this);
		modelSpinner = new SpinnerNumberModel(0, -360, 360, 1);
		rotationSpinner = new JSpinner(modelSpinner);
		rotationSpinner.setValue(acontroller.getAngle());
		rotationSpinner.setPreferredSize(new Dimension(50,25));
		rotationSpinner.setMinimumSize(new Dimension(50, 25));
		rotationSpinner.setMaximumSize(new Dimension(50, 25));
		rotationSpinner.addChangeListener(new SlideListener());
		this.add(rotationSpinner);

	}
	
	class SlideListener implements ChangeListener{
		public void stateChanged(ChangeEvent e) {
			Integer i = (Integer) rotationSpinner.getValue();
			acontroller.setAngle(i.intValue());
		}
	}

	@Override
	public void update(Observable o, Object arg) {
		Integer i = (Integer) rotationSpinner.getValue();
		if(i.intValue()!=acontroller.getAngle()){
			rotationSpinner.setValue(acontroller.getAngle());
		}
	}
}