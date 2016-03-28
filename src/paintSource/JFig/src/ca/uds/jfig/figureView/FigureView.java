package ca.uds.jfig.figureView;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.geom.Point2D;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import ca.uds.jfig.application.ApplicationController;
import ca.uds.jfig.application.ApplicationModel;
import ca.uds.jfig.application.FigureController;
import ca.uds.jfig.jfigInterface.ModeInterface;

@SuppressWarnings("serial")
public class FigureView extends JPanel implements ModeInterface, Observer{
	final int SIZE = Integer.MAX_VALUE-1;
	JLayeredPane view;
	
	DrawAreaView vdraw;
	TextPanelView vtext;
	DisplayAreaView vdisp;
	DisplayGridView vgrid;
	DisplayBackgroundView vbg;
	
	ApplicationController acontroller;
	ApplicationModel amodel;
	FigureController fcontroller;
	
	public FigureView(FigureController fcontroller, ApplicationController acontroller){
		super();

		this.acontroller = acontroller;
		this.amodel = acontroller.getModel();
		this.fcontroller = fcontroller;
		this.view = new JLayeredPane();
		
		amodel.addObserver(this);
        
		vdisp = new DisplayAreaView(amodel,fcontroller.getModel(), fcontroller);//.getModel());
		vdraw = new DrawAreaView(fcontroller,acontroller);
		vtext = new TextPanelView(acontroller,fcontroller);
		vgrid = new DisplayGridView(amodel);
		vbg = new DisplayBackgroundView();
		
		vdisp.setOpaque(false);
		vdraw.setOpaque(false);
		vtext.setOpaque(false);
		vgrid.setOpaque(false);
		vbg.setOpaque(true);
		
		view.add(vbg, new Integer(10));
		view.add(vdisp, new Integer(30));
		view.add(vdraw, new Integer(40));
//		view.add(vtext, new Integer(50));
		view.add(vgrid, new Integer(60));

        this.add(view);
		this.setVisible(true);
		
		//acontroller.setMax(new Point2D.Double(this.getWidth() ,this.getHeight()));
		acontroller.setMax(new Point2D.Double(1920,1080));
	}
	
	public void paint(Graphics g){
		super.paint(g);
		int width = acontroller.getPanelWidth();
		int height = acontroller.getPanelHeight();
		view.setPreferredSize(new Dimension(width,height));
		view.revalidate();
		vdisp.setBounds(0,0,width,height);
		vdraw.setBounds(0,0,width,height);
		vgrid.setBounds(0,0,width,height);
		vtext.setBounds(0,0,width,height);
		vbg.setBounds(0,0,width,height);
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		switch (amodel.getMode()) {
		case TEXT:
			view.remove(vdraw);
			view.add(vtext, new Integer(50));
			break;
		default:
			view.remove(vtext);
			view.add(vdraw, new Integer(70));
			break;
		}
	}
}