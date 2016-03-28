package ca.uds.jfig.application;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import ca.uds.jfig.figureView.FigureView;
import ca.uds.jfig.jfigInterface.ModeInterface;
import ca.uds.jfig.menu.ConfirmClose;
import ca.uds.jfig.menu.Menu;
import ca.uds.jfig.toolBar.SliderZoom;
import ca.uds.jfig.toolBar.TextBar;
import ca.uds.jfig.toolBar.ToolBar;

@SuppressWarnings("serial")
public class Application extends JFrame implements 
		Observer, Runnable, ModeInterface {
	public static final String MAIN_WINDOW = "mainWindow";
	
	private BorderLayout layout;
	
	private ToolBar toolBar ;
	private TextBar textBar;

	private JLabel infoMode;
	private JLabel infoType;
	private JLabel infoZone;
	private JLabel infoDrag;
	private JLabel infoZoom;
	private SliderZoom zoomSlider;
	private int x=0,y=0;

	public static FigureModel fmodel;
	public static FigureController fcontroller;
	public static ApplicationModel amodel;
	public static MouseModel mmodel;
	public static ApplicationController acontroller;

	SavePreferences save = new SavePreferences();
	JPanel infoBar = new JPanel();
	JScrollPane sp;

	public Application() {
		mmodel = new MouseModel();
		fmodel = new FigureModel();
		fcontroller = new FigureController(fmodel,mmodel);
		amodel = new ApplicationModel();
		acontroller = new ApplicationController(amodel,mmodel);

		acontroller.setFigureController(fcontroller);
		fcontroller.setApplicationController(acontroller,fcontroller);
		
		toolBar = new ToolBar(acontroller);
		textBar = new TextBar(acontroller);
		
		layout = new BorderLayout();

		new Thread(this).start();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		amodel.addObserver(this);
		mmodel.addObserver(this);
		this.setTitle(this.setTittle());
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		int[] stateSave;
		try {
			stateSave = save.setInitalState();
			this.setLocation(stateSave[0], stateSave[1]);
			this.setSize(stateSave[2], stateSave[3]);
		} catch (Exception e) {
			// TODO: Cath exception!!!!!!!!!!!!!!!!!!!
			e.printStackTrace();
		}
		Menu menu = new Menu(acontroller);
		this.setJMenuBar(menu);
		addListeners();

		JPanel jp = new FigureView(fcontroller, acontroller);
		sp = new JScrollPane(jp);
		sp.createVerticalScrollBar();
		this.getContentPane().setLayout(layout);
		this.getContentPane().add(toolBar, BorderLayout.NORTH);
		this.getContentPane().add(sp, BorderLayout.CENTER);
		this.getContentPane().add(createInfoBar(), BorderLayout.SOUTH);
		this.setName(MAIN_WINDOW);
		this.setVisible(true);

	}

	public static void main(String[] args) {
		new Application();
	}

	public void addListeners() {
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				Rectangle bounds = getBounds();
				save.saveFramePositions((int) bounds.getX(),
						(int) bounds.getY(), (int) bounds.getWidth(),
						(int) bounds.getHeight());
				ConfirmClose closed = new ConfirmClose(acontroller);
				closed.close();

			}
		});
	}

	private String setTittle() {
		String title;
		if (acontroller.getSave() == false) {
			title = "jFig" + " " + "-" + " "
					+ amodel.getCurrentFile().getName() + "" + "*";
		} else {
			title = "jFig" + " " + "-" + " "
					+ amodel.getCurrentFile().getName();
		}
		return title;
	}

	public void update(Observable o, Object arg) {
			changeBar();
			this.setTitle(this.setTittle());
			infoZoom.setText(" "+"Zoom: "+"("+Integer.toString((int)amodel.getScale())+"%)");
			infoType.setText(amodel.getStringType());
			infoMode.setText(amodel.getStringMode());	
			infoZone.setText("(" + mmodel.getMouseX() + "," + mmodel.getMouseY()
					+ ")");
			infoDrag.setText("(" + mmodel.getMouseDragX() + ","
					+ mmodel.getMouseDragY() + ")");
	}

	private void changeBar() {
		this.getContentPane().remove(layout.getLayoutComponent(BorderLayout.NORTH));
		this.getContentPane().repaint();
		switch (amodel.getMode()) {
		case TEXT:
			this.getContentPane().add(textBar, BorderLayout.NORTH);
			break;
		default:
			this.getContentPane().add(toolBar, BorderLayout.NORTH);
			break;
		}
	}
	
	public JPanel createInfoBar() {
		infoMode = new JLabel(amodel.getStringMode());
		infoType = new JLabel(amodel.getStringType());
		infoZone = new JLabel("("+this.x+","+this.y+")");
		infoDrag = new JLabel("("+this.x+","+this.y+")");
		infoZoom = new JLabel(" "+"Zoom: "+"("+Integer.toString((int)amodel.getScale())+"%)");
		zoomSlider = new SliderZoom(acontroller);
		infoBar = new JPanel(new GridLayout(1, 6));
		infoBar.add(infoMode);
		infoBar.add(infoType);
		infoBar.add(infoDrag);
		infoBar.add(infoZone);
		infoBar.add(infoZoom);
		infoBar.add(zoomSlider);
		return infoBar;
	}

	@Override
	public void run() {
		new SplashScreen(3000);
	}

	public SliderZoom getZoomSlider() {
		return zoomSlider;
	}

	public void setZoomSlider(SliderZoom zoomSlider) {
		this.zoomSlider = zoomSlider;
	}

	public JLabel getInfoZoom() {
		return infoZoom;
	}

	public void setInfoZoom(JLabel infoZoom) {
		this.infoZoom = infoZoom;
	}
}
