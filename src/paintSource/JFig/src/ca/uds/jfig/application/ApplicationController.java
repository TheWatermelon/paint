/**
 * 
 * @autor 
 * @worker Florian Bonniec
 * 
 **/
package ca.uds.jfig.application;

import java.awt.Color;
import java.awt.geom.Point2D;
import java.io.File;
import java.io.IOException;
import java.util.Observer;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import ca.uds.jfig.figures.Figure;
import ca.uds.jfig.figures.FigureComposite;
import ca.uds.jfig.jfigInterface.FigureInterface;
import ca.uds.jfig.jfigInterface.ModeInterface;

public class ApplicationController implements ModeInterface, FigureInterface{
	ApplicationModel amodel;
	MouseModel mmodel;
	FigureController fcontroller;
	public static final String SAVE_WINDOW = "saveWindow";

	public ApplicationController(ApplicationModel amodel, MouseModel mmodel) {
		this.amodel = amodel;
		this.mmodel = mmodel;
	}

	public ApplicationModel getModel() {
		return this.amodel;
	}
	
	public MouseModel getMouseModel(){
		return this.mmodel;
	}
	
	public Boolean getSave() {
		return amodel.getSave();
	}

	public void setFigureController(FigureController fcontroller) {
		this.fcontroller = fcontroller;
	}

	public void setType(int type) {
		amodel.setType(type);
	}

	public int getType() {
		return amodel.getType();
	}

	public void setBorderColor(Color color) {
		amodel.setBorderColor(color);
	}

	public void setFillColor(Color color) {
		amodel.setFillColor(color);
	}

	public void setStroke(int i) {
		amodel.setStroke(i);
	}

	public int getStroke() {
		return amodel.getStroke();
	}

	public void setText(String txt) {
		amodel.setText(txt);
	}

	public String getText(String txt) {
		return amodel.getText();
	}

	public void setSizeText(int size) {
		amodel.setSizeText(size);
	}

	public int getText(int size) {
		return amodel.getSizeText();
	}

	public int getOptionTxt(int optxt) {
		return amodel.getOptionTxt();
	}

	public void setOptionTxt(int optxt) {
		amodel.setOptionTxt(optxt);
	}
	
	public String getPoliceText(String pol) {
		return amodel.getPoliceText();
	}

	public void setPoliceText(String Pol) {
		amodel.setPoliceText(Pol);
	}
	
	public void openFile() throws IOException {
		// File open = amodel.getCurrentFile();
		String file;
		JFileChooser chooser = getChooser();
		if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			file = chooser.getSelectedFile().getAbsolutePath();
			try {
			fcontroller.open(file);
			amodel.setCurrentFile(new File(file));
			amodel.setSave(true);
			} catch (Exception error) {
				JOptionPane.showMessageDialog(null, "File doesn't exist");
				return;
			}
		}
	}

	private JFileChooser getChooser() {
		JFileChooser chooser = new JFileChooser();
		FileFilter imagesFilter = new FileNameExtensionFilter(
				"Images (png, jpg, jpeg, bmp)", "png", "jpg", "jpeg", "bmp");
		FileFilter jFigFilter = new FileNameExtensionFilter("JFig (jfig)",
				"jfig");
		chooser.addChoosableFileFilter(imagesFilter);
		chooser.addChoosableFileFilter(jFigFilter);
		chooser.setCurrentDirectory(amodel.getDefaultDir());
		return chooser;
	}

	public void saveFile() {
		try {
			if (amodel.getCurrentFile().toString() != amodel.getDefaultName()) {
				fcontroller.save(amodel.getCurrentFile());
				amodel.setSave(true);
				return;
			}
			JFileChooser chooser = new JFileChooser();
			chooser.setCurrentDirectory(amodel.getDefaultDir());
			//chooser.setName(SAVE_WINDOW);
			if (chooser.showSaveDialog(null) != JFileChooser.APPROVE_OPTION)
				return;
			File savedfile = new File(chooser.getSelectedFile()
					.getAbsolutePath());
			if (savedfile.exists())
				if (JOptionPane.showConfirmDialog(new JFrame(),
						"The file already exist.\n"
								+ "Do you really want to save", " jFig",
						JOptionPane.YES_NO_OPTION) != JOptionPane.OK_OPTION)
					return;
			fcontroller.save(savedfile);
			amodel.setSave(true);
			amodel.setCurrentFile(savedfile);
			amodel.setSave(true);
		} catch (Exception error) {
			System.out.println(error);
			error.printStackTrace();
			JOptionPane.showMessageDialog(null, "File can't be created");
		}
	}

	public void saveAsFile(){
		try {
			JFileChooser chooser = new JFileChooser();
			chooser.setCurrentDirectory(amodel.getDefaultDir());
			if (chooser.showSaveDialog(null) != JFileChooser.APPROVE_OPTION)
				return;
			File savedfile = new File(chooser.getSelectedFile()
					.getAbsolutePath());
			if (savedfile.exists())
				if (JOptionPane.showConfirmDialog(new JFrame(),
						"The file already exist.\n"
								+ "Do you really want to save", " jFig",
						JOptionPane.YES_NO_OPTION) != JOptionPane.OK_OPTION)
					return;
			fcontroller.save(savedfile);
			amodel.setSave(true);
			amodel.setCurrentFile(savedfile);
			amodel.setSave(true);
		} catch (Exception error) {
			System.out.println(error);
			error.printStackTrace();
			JOptionPane.showMessageDialog(null, "File can't be created");
		}		
	}
	
	public Figure getFigureList() {
		return this.fcontroller.getFigureList();
	}

	public void setMouse(int x, int y) {	
		x = gridMagnet(scaleCoord(x));
		y = gridMagnet(scaleCoord(y));
		mmodel.setMouseX(x);
		if(mmodel.getMousePressedX()!=-1){
			mmodel.setMouseDragX(Math.abs(mmodel.getMousePressedX()-x));
		}else{
			mmodel.setMouseDragX(0);
		}
		mmodel.setMouseY(y);
		if(mmodel.getMousePressedY()!=-1){
			mmodel.setMouseDragY(Math.abs(mmodel.getMousePressedY()-y));
		}else{
			mmodel.setMouseDragY(0);
		}
		mmodel.validate();
	}
	
	public void setMousePressed(int x, int y) {
		mmodel.setMousePressedX(gridMagnet(scaleCoord(x)));
		mmodel.setMousePressedY(gridMagnet(scaleCoord(y)));
	}
	
	private int gridMagnet(int val){
		if(amodel.getGridStatus()){
			return Math.round(val/amodel.getGridStep())*amodel.getGridStep();
		}
		return val;
	}
	
	private int scaleCoord(int val){
		return (int) (val / (amodel.getScale() / 100));
	}

	public Color getFillColor() {
		return amodel.getFillColor();
	}

	public Color getBorderColor() {
		return amodel.getBorderColor();
	}

	public void addObserver(Observer o) {
		amodel.addObserver(o);
	}

	public int getMode() {
		return amodel.getMode();
	}

	public void setMode(int mode) {
		amodel.setMode(mode);
	}

	public int getDrawZoneWidth() {
		return (int) amodel.getDrawZoneWidth();
	}

	public int getDrawZoneHeigth() {
		return (int) amodel.getDrawZoneHeight();
	}

	public void setSave(boolean save) {
		amodel.setSave(save);
	}
	
	public void setFigureChange() {
		amodel.setSave(false);
	}

	public void setMax(Point2D p1, Point2D p2) {
		Point2D.Double max = new Point2D.Double();
		if (p1.getX() > p2.getX()) {
			max.x = p1.getX();
		} else {
			max.x = p2.getX();
		}
		if (p1.getY() > p2.getY()) {
			max.y = p1.getY();
		} else {
			max.y = p2.getY();
		}
		setMax(max);
	}

	public void setMax(Point2D.Double max) {
		if (max.getX() > amodel.getMaxX()) {
			amodel.setMaxX(max.x);
			this.updateMargin();
		}
		if (max.getY() > amodel.getMaxY()) {
			amodel.setMaxY(max.y);
			this.updateMargin();
		}
	}

	public void newFile() {
		fcontroller.deselectAll();
		fcontroller.setModel(new FigureComposite());
		this.amodel.init();
		this.setMax(new Point2D.Double(1920,1080));
		this.setMode(DRAW);
		this.updateMargin();
	}

	private void updateMargin() {
		amodel.setDrawZoneHeight(amodel.getMaxY() + amodel.getMargin());
		amodel.setDrawZoneWidth(amodel.getMaxX() + amodel.getMargin());
	}

	public void setScale(double scale) {
		if(scale!=0.0){
		amodel.setScale(scale);
		}
	}

	public double getScale() {
		return amodel.getScale();
	}

	public void setAngle(int angle) {
		amodel.setAngle(angle);
	}

	public int getAngle() {
		return amodel.getAngle();
	}

	public void undo() {
		fcontroller.undo();
	}

	public void setFront() {
		fcontroller.setFront();	
	}

	public void deleteFigure() {
		fcontroller.deleteFigure();
	}

	public void setMaxMouse() {
		this.setMax(new Point2D.Double(mmodel.getMouseX(),mmodel.getMouseY()));
	}

	public void resetDrag() {
		mmodel.setMousePressedX(-1);
		mmodel.setMousePressedY(-1);
	}

//	public void setLast(Figure create) {
//		amodel.setLast(create);
//	}

	public void redo() {
		// TODO Auto-generated method stub
		
	}

	public void incrementZoom() {
		if(amodel.getScale()<200){
		amodel.setScale(amodel.getScale()+5.0);
		}
	}
	
	public void decrementZoom() {
		if(amodel.getScale()>0){
		amodel.setScale(amodel.getScale()-5.0);
		}
	}

	public void toggleGrid() {
		amodel.setGridStatus(amodel.getGridStatus()==false);
	}

	public int getPanelWidth() {
		return (int) (amodel.getDrawZoneWidth() * amodel.getScale() / 100) ;
	}

	public int getPanelHeight() {
		return (int) (amodel.getDrawZoneHeight() * amodel.getScale() / 100) ;
	}
}
