package ca.uds.jfig.JFigTest;

import static ca.uds.jfig.toolBar.ToolBar.CIRCLE_BUTTON;
import static ca.uds.jfig.toolBar.ToolBar.LINE_BUTTON;
import static ca.uds.jfig.toolBar.ToolBar.OVAL_BUTTON;
import static ca.uds.jfig.toolBar.ToolBar.RECTANGLE_BUTTON;
import static ca.uds.jfig.toolBar.ToolBar.ROUND_RECTANGLE_BUTTON;
import static ca.uds.jfig.toolBar.ToolBar.SAVE_BUTTON;

import java.awt.geom.Point2D;

import javax.swing.JButton;

import ca.uds.jfig.application.Application;
import ca.uds.jfig.application.ApplicationController;
import ca.uds.jfig.application.FigureController;
import ca.uds.jfig.figures.Figure;
import ca.uds.jfig.figures.FigureFactory;

import com.objogate.wl.swing.AWTEventQueueProber;
import com.objogate.wl.swing.driver.ComponentDriver;
import com.objogate.wl.swing.driver.JButtonDriver;
import com.objogate.wl.swing.driver.JFrameDriver;
import com.objogate.wl.swing.gesture.GesturePerformer;

public class JFigDriver extends JFrameDriver {


	@SuppressWarnings("unchecked")
	public JFigDriver() {
		super(new GesturePerformer(), new AWTEventQueueProber(),
				named("mainWindow"), showingOnScreen());
	}

	public void clickOnRectangle() {
		button(RECTANGLE_BUTTON).click();
	}

	public void clickOnOval() {
		button(OVAL_BUTTON).click();
		// buttonO.doClick();
	}

	public void clickOnCircle() {
		button(CIRCLE_BUTTON).click();
	}

	public void clickOnRoundRectangle() {
		button(ROUND_RECTANGLE_BUTTON).click();
	}

	public void clickOnLine() {
		button(LINE_BUTTON).click();
	}

	public void clickOnSave() {
		button(SAVE_BUTTON).click();
	}

	public void createFigure(ApplicationController acontroller,
			FigureController fcontroller) {
		FigureFactory figureFactory = new FigureFactory(acontroller,
				fcontroller);
		Figure fig = figureFactory.createFigure(new Point2D.Double(10, 10),
				new Point2D.Double(100, 90));
		Application.fcontroller.add(fig);
	}

	@SuppressWarnings("unchecked")
	private JButtonDriver button(String name) {
		return new JButtonDriver(this, JButton.class,
				ComponentDriver.named(name));
	}
}
