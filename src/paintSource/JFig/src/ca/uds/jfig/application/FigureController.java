/**
 * 
 * @autor Florian bonniec
 * 
 * 
 **/
package ca.uds.jfig.application;


import java.awt.Graphics;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ListIterator;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;


import ca.uds.jfig.figures.Figure;
import ca.uds.jfig.figures.FigureComposite;
import ca.uds.jfig.figures.FigureFactory;
import ca.uds.jfig.jfigInterface.FileTypeInterface;

public class FigureController implements FileTypeInterface {
	private FigureModel fmodel;
	private ApplicationModel amodel;
	private ApplicationController acontroller;
	private FigureFactory figurefactory;
	private MouseModel mmodel;

	public FigureController(FigureModel fmodel, MouseModel mmodel) {
		this.fmodel = fmodel;
		this.mmodel = mmodel;
	}

	public void setApplicationController(ApplicationController acontroller,FigureController fcontroller) {
		this.acontroller = acontroller;
		this.amodel = acontroller.getModel();
		figurefactory = new FigureFactory(acontroller,fcontroller);
	}
	
	public void add(Figure fig) {
		Figure figure = fmodel.getFigureList();
		figure.add(fig);
		fmodel.setFigureList(figure);
		acontroller.setFigureChange();
	}

	public void remove(Figure fig) {
		Figure figure = fmodel.getFigureList();
		figure.remove(fig);
		fmodel.setFigureList(figure);
	}
	
	public void set(int index, Figure fig) {
		Figure figure = fmodel.getFigureList();
		figure.set(index, fig);
		fmodel.setFigureList(figure);
	}

	public void remove(int index) {
		Figure figure = fmodel.getFigureList();
		figure.remove(index);
		fmodel.setFigureList(figure);
	}

	public boolean isEmpty() {
		Figure figure = fmodel.getFigureList();
		return figure.isEmpty();
	}

	public Figure getFigureList() {
		Figure figure = fmodel.getFigureList();
		return figure;
	}

	public void setModel(Figure fig) {
		fmodel.setFigureList(fig);
	}

	public void open(String file) throws IOException {
		Figure figures = new FigureComposite();
		FigureFactory figureFactory = new FigureFactory();
		this.setModel(figures);
		String line;
		BufferedReader readwithBuffer = new BufferedReader(new FileReader(file));
		while ((line = readwithBuffer.readLine()) != null) {
			figures = fmodel.getFigureList();
			try {
				Figure fig = figureFactory.loadFigure(line);
				figures.add(fig);
			} catch (Exception error) { //end try
				JOptionPane.showMessageDialog(null, "Is not the right format");
				readwithBuffer.close();
				return;
			}
		}
		readwithBuffer.close();
	}
	
	public void save(File file){
		if (file.getName().lastIndexOf(".") > 0) {
			String ext = file.getName().substring(file.getName().lastIndexOf("."));
			switch (makeChoice(ext)) {
			case PNG:
				 this.saveInPNG(file);break;
			case JPEG: 
				 this.saveInJPEG(file);break;
			case EPS:
				this.saveInEPS(file);break;
			default:
				this.SaveInJFIG(file);break;
			}
		}else{
			this.SaveInJFIG(file);
		}
	}
	
	private int makeChoice(String ext) {
		if (png_STR.equalsIgnoreCase(ext)){
			return PNG;
		}
		if (jpeg_STR.equalsIgnoreCase(ext)){
			return JPEG;
		}
		if (eps_STR.equalsIgnoreCase(ext)){
			return EPS;
		}
		return JFIG;
	}

	public void saveInJPEG(File file){
		BufferedImage bi = new BufferedImage(acontroller.getDrawZoneHeigth(), acontroller.getDrawZoneWidth(), BufferedImage.TYPE_INT_ARGB); 
		Graphics g = bi.createGraphics();
		fmodel.getFigureList().paint(g);
		g.dispose();
		try{ImageIO.write(bi,"jpeg",file);
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null,
				    "Error: save in .jpeg "+e,
				    "Save in .jpeg warning",
				    JOptionPane.WARNING_MESSAGE);
		}
	}
	
	public void saveInPNG(File file){
		BufferedImage bi = new BufferedImage(500, 500, BufferedImage.TYPE_INT_ARGB); 
		Graphics g = bi.createGraphics();
		fmodel.getFigureList().paint(g);
		g.dispose();
		try{ImageIO.write(bi,"PNG",file);
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null,
				    "Error: save in .png "+e,
				    "Save in .png warning",
				    JOptionPane.WARNING_MESSAGE);
		}
	}
	
	public void SaveInJFIG(File file){
		FileWriter fw;
		try {
			fw = new FileWriter(file, false);
		BufferedWriter output = new BufferedWriter(fw);
		output.write(fmodel.getFigureList().toString());
		output.flush();
		output.close();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null,
				    "Error: save in .jfig "+e,
				    "Save in .jfig warning",
				    JOptionPane.WARNING_MESSAGE);
		}
	}
	
	public void saveInEPS(File file){
		FileWriter fw;
		try {
			fw = new FileWriter(file, false);
		BufferedWriter output = new BufferedWriter(fw);
		output.write(fmodel.getFigureList().toString());
		output.flush();
		output.close();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null,
				    "Error: save in .eps "+e,
				    "Save in .eps warning",
				    JOptionPane.WARNING_MESSAGE);
		}
	}
	
	public FigureModel getModel() {
		return fmodel;
	}

	public Figure getLast() {
		return fmodel.getLast();
	}

	public void setLast(Figure last) {
		fmodel.setLast(last);
	}
	
	public void setFigureCourante(Figure fig){
		fmodel.setFigureCourante(fig);
	}
	
	public void checkFigure() {
		int x = mmodel.getMouseX();
		int y = mmodel.getMouseY();
		Figure figure = fmodel.getFigureList();
		ListIterator<Figure> iter = figure.getList().listIterator(figure
				.countElement());
		while (iter.hasPrevious()) {
			int i = iter.previousIndex();
			Figure currentfig = iter.previous();
			if (currentfig.contains(new Point2D.Double(x,y))) {
				fmodel.setFigureCourante(currentfig);
				fmodel.setIndexCourant(i);
				setShift();
				break;
			}
		}
	}
	
	public void checkFigureOnDrag(int x, int y) {
		int x2 = mmodel.getMousePressedX();
		int y2 = mmodel.getMousePressedY();
		Figure figures = new FigureComposite();
		Figure figselection = figurefactory.createFigure(new Point2D.Double(x2, y2), new Point2D.Double(x, y));
		Figure figure = fmodel.getFigureList();
		ListIterator<Figure> iter = figure.getList().listIterator(figure
				.countElement());
		while (iter.hasPrevious()) {
			//int i = iter.previousIndex();
			Figure currentfig = iter.previous();
			if (figselection.contains(currentfig.getOrigin())&&figselection.contains(currentfig.getEnd())) {
				figures.add(currentfig);
			}
		}
		fmodel.setFigureCourante(figures);
	}
	
	private void setShift(){
		if (amodel.getGridStatus()){
			mmodel.setMouseShiftX((int) (fmodel.getFigureCourante().getX1()%amodel.getGridStep()));
			mmodel.setMouseShiftY((int) (fmodel.getFigureCourante().getY1()%amodel.getGridStep()));
		}else{
			mmodel.setMouseShiftX(0);
			mmodel.setMouseShiftY(0);
		}
	}
	
	public void deselectAll() {
		fmodel.setFigureCourante(null);
		fmodel.setIndexCourant(-1);
	}

	public void setFront() {
		if(fmodel.getIndexCourant()!=-1){
			Figure fig = fmodel.getFigureCourante();
			this.remove(fmodel.getIndexCourant());
			this.add(fig);
			this.deselectAll();
		}
		acontroller.setFigureChange();
	}

	public void deleteFigure() {
		if(fmodel.getIndexCourant()!=-1){
			this.remove(fmodel.getIndexCourant());
			this.deselectAll();
		}
		acontroller.setFigureChange();
	}

	public void translate() {
		int x = mmodel.getMouseX();
		int y = mmodel.getMouseY();
		int pressX = mmodel.getMousePressedX();
		int pressY = mmodel.getMousePressedY();
		Figure fig = fmodel.getFigureCourante();
		fig.setOrigin(new Point2D.Double(pressX, pressY));
		fig.setEnd(new Point2D.Double(pressX + fig.getX2()- fig.getX1(), pressY + fig.getY2() - fig.getY1()));
		if(fig!=null){
			fig.move(x - pressX, y - pressY);
			fig.setX1(fig.getOrigin().getX() + x - pressX);
			fig.setY1(fig.getOrigin().getY() + y - pressY);
			fig.setX2(fig.getEnd().getX() + x - pressX);
			fig.setY2(fig.getEnd().getY() + y - pressY);
		}
	}
	
	public void move() {
		int x = mmodel.getMouseX();
		int y = mmodel.getMouseY();
		int pressX = mmodel.getMousePressedX();
		int pressY = mmodel.getMousePressedY();
		Figure fig = fmodel.getFigureCourante();
		if(fig!=null){
			fig.move(x - pressX, y - pressY);
			fig.setX1(fig.getOrigin().getX() + x - pressX - mmodel.getMouseShiftX() );
			fig.setY1(fig.getOrigin().getY() + y - pressY - mmodel.getMouseShiftY());
			fig.setX2(fig.getEnd().getX() + x - pressX - mmodel.getMouseShiftX());
			fig.setY2(fig.getEnd().getY() + y - pressY - mmodel.getMouseShiftY());
		}
	}

	public void createFigure() {
		int x = mmodel.getMouseX();
		int y = mmodel.getMouseY();
		int pressX = mmodel.getMousePressedX();
		int pressY = mmodel.getMousePressedY();
		this.add(figurefactory.createFigure(new Point2D.Double(
				pressX, pressY), new Point2D.Double(x, y)));
	}

	public Figure getFigureCourante() {
		return fmodel.getFigureCourante();
	}
	
	public int getCourantIndex(){
		return fmodel.getIndexCourant();
	}

	public void undo() {
		this.remove(fmodel.getLast());
		
	}
	
	public void redo() {
		
	}

	public void changeFigureProperties() {
		Figure fig = fmodel.getFigureCourante();
		if(fig!=null){
			fig.setBorderColor(acontroller.getBorderColor());
			fig.setFillColor(acontroller.getFillColor());
			fig.setStroke(acontroller.getStroke());
			if(acontroller.getSave()==true){
			acontroller.setFigureChange();
			}
		}
	}
	
	public void changeRotate() {
		Figure fig = fmodel.getFigureCourante();
		if(fig!=null){
			fig.setAngle(acontroller.getAngle());
		}
	}
	
	public void replace() {
		Figure fig = fmodel.getFigureCourante();
		if(fig!=null){
			this.setproperties(fig);
			this.set(fmodel.getIndexCourant(), figurefactory.createFigure(new Point2D.Double(
				fig.getX1(), fig.getY1()), new Point2D.Double(fig.getX2(), fig.getY2())));
		}
		acontroller.setFigureChange();
	}
	
	public void setproperties(Figure fig){
		acontroller.setType(fig.getType());
		acontroller.setAngle(fig.getAngle());
		acontroller.setFillColor(fig.getFillColor());
		acontroller.setBorderColor(fig.getBorderColor());
		acontroller.setStroke(fig.getStroke());
	}
}
