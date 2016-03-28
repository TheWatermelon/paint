/**
 * 
 * @autor florian bonniec
 * @worker florian bonniec
 * 
 **/
package ca.uds.jfig.application;

import java.awt.Color;
import java.awt.geom.Point2D;
import java.io.File;
import java.util.Observable;

import ca.uds.jfig.jfigInterface.*;

public class ApplicationModel extends Observable implements ModeInterface, FigureInterface, ArrowInterface {
	private File defaultDir, currentFile;
	private String defaultName;
	private int type, mode;
	private Color borderColor, fillColor;
	private int stroke;
	private double drawZoneWidth, drawZoneHeight;
	private Boolean save;
	private Point2D.Double max;
	private double margin,scale;
	private String txt,pol;
	private int size,optxt;
	private int angle;
//	private Figure last;
	private int gridStep;
	private boolean grid;

	
	
	public ApplicationModel(){
		this.init();
	}
	
	public void init() {
		defaultDir = new File("." + File.separator + "JfigFile");
		defaultName = new String("new.jfig");
		currentFile = new File(defaultName);
		type = RECTANGLE;
		borderColor = Color.black;
		fillColor = Color.white;
		stroke = 5;
		angle=0;
		mode = DRAW;
		save = true;
		max = new Point2D.Double(0, 0);
		margin = 1200;
		this.scale = 1.0;
		size = 12;
		gridStep = 10;
		grid = true;
	}

	public File getDefaultDir() {
		return defaultDir;
	}

	public String getDefaultName() {
		return defaultName;
	}

	public File getCurrentFile() {
		return currentFile;
	}

	public void setCurrentFile(File currentFile) {
		this.currentFile = currentFile;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
		setChanged();
		notifyObservers();
		//System.out.println("setType");
	}
	
	public String getStringType() {
		switch (this.type) {
		case RECTANGLE:
			return RECTANGLE_STR;
		case CIRCLE:
			return CIRCLE_STR;
		case OVAL:
			return OVAL_STR;
		case LINE:
			return LINE_STR;
		case ROUNDRECTANGLE:
			return ROUNDRECTANGLE_STR;
		case ARROW:
			return ARROW_STR;
		case ARROWDOUBLE:
			return ARROWDOUBLE_STR;
		case ARROWFILL:
			return ARROWFILL_STR;
		case ARROWFILLDOUBLE:
			return ARROWFILLDOUBLE_STR;
		}
		return "null";
	}

	public int getStroke() {
		return stroke;
	}

	public void setStroke(int stroke) {
		this.stroke = stroke;
		setChanged();
		notifyObservers();
		//System.out.println("setStroke");
	}

	public Color getFillColor() {
		return fillColor;
	}

	public void setFillColor(Color fillColor) {
		this.fillColor = fillColor;
		setChanged();
		notifyObservers();
		//System.out.println("setfillColor");
	}

	public Color getBorderColor() {
		return borderColor;
	}

	public void setBorderColor(Color borderColor) {
		this.borderColor = borderColor;
		setChanged();
		notifyObservers();
		//System.out.println("setBorderColor");
	}

	public Boolean getSave() {
		return save;
	}

	public void setSave(Boolean save) {
		this.save = save;
		setChanged();
		notifyObservers();
		//System.out.println("setSave");
	}

	public int getMode() {
		return this.mode;
	}

	public String getStringMode() {
		switch (this.mode) {
		case DRAW:
			return DRAW_STR;
		case SELECT:
			return SELECT_STR;
		case MOVE:
			return MOVE_STR;
		case TRANSLATE:
			return TRANSLATE_STR;
		case ROTATE:
			return ROTATE_STR;
		case TEXT:
			return TEXT_STR;
		}
		return "null";
	}

	public void setMode(int mode) {
		this.mode = mode;
		setChanged();
		notifyObservers();
		//System.out.println("setMode");
	}

	public double getDrawZoneWidth() {
		return this.drawZoneWidth;
	}

	public void setDrawZoneWidth(double drawZoneWidth) {
		this.drawZoneWidth = drawZoneWidth;
	}

	public double getDrawZoneHeight() {
		return this.drawZoneHeight;
	}

	public void setDrawZoneHeight(double drawZoneHeight) {
		this.drawZoneHeight = drawZoneHeight;
	}

	public double getMaxX() {
		return this.max.x;
	}

	public void setMaxX(double d) {
		this.max.x = d;
	}

	public double getMaxY() {
		return this.max.y;
	}

	public void setMaxY(double y) {
		this.max.y = y;
	}

	public double getMargin() {
		return this.margin;
	}

	public void setScale(double scale) {
		this.scale = scale/100.0;
		setChanged();
		notifyObservers();
		//System.out.println("setScale");
	}

	public double getScale() {
		return this.scale*100.0;
	}

	public String getText() {
		return this.txt;
	}

	public void setText(String text) {
		this.txt = text;
		setChanged();
		notifyObservers();
		//System.out.println("setText");
	}

	public int getSizeText() {
		return this.size;
	}

	public void setSizeText(int size) {
		this.size = size;
		setChanged();
		notifyObservers();
		//System.out.println("setSizeType");
	}

	public int getOptionTxt() {
		return this.optxt;
	}

	public void setOptionTxt(int optxt) {
		this.optxt = optxt;
		setChanged();
		notifyObservers();
		//System.out.println("setOptionTxt");
	}
	
	public String getPoliceText() {
		return this.pol;
	}

	public void setPoliceText(String pol) {
		this.pol = pol;
		setChanged();
		notifyObservers();
		//System.out.println("setPoliceText");
	}

	public int getAngle() {
		return this.angle;
	}

	public void setAngle(int angle) {
		this.angle = angle;
		setChanged();
		notifyObservers();
		//System.out.println("setAngle");
	}

//	public void setLast(Figure create) {
//		this.last = create;
//	}

	public int getGridStep() {
		return gridStep;
	}

	public void setGridStep(int gridStep) {
		this.gridStep = gridStep;
	}

	public boolean getGridStatus() {
		return grid;
	}

	public void setGridStatus(boolean b) {
		this.grid = b;
		setChanged();
		notifyObservers();
		//System.out.println("setGridStatus");
	}

}
