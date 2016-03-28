/**
 * 
 * @autor Gael Rochard
 * @worker Nolwenn Roger, Aymeric Birotheau, Florian Bonniec
 * 
 **/
package ca.uds.jfig.figures;

import java.awt.Color;
import java.awt.geom.Point2D;
import java.util.Observable;
import java.util.Observer;
import java.util.StringTokenizer;

import ca.uds.jfig.application.ApplicationController;
import ca.uds.jfig.application.ApplicationModel;
import ca.uds.jfig.application.FigureController;
import ca.uds.jfig.application.FigureModel;
import ca.uds.jfig.jfigInterface.ArrowInterface;
import ca.uds.jfig.jfigInterface.FigureInterface;
import ca.uds.jfig.jfigInterface.ModeInterface;

public class FigureFactory implements Observer, ModeInterface, FigureInterface, ArrowInterface{
	ApplicationController acontroller;
	ApplicationModel amodel;
	FigureController fcontroller;
	FigureModel fmodel;
	private String text ;
	private Color border, fill;
	private int stroke, size, angle,pol, type;
	private Point2D origin, end;
	private String style= "Verdana";

	public FigureFactory() {
	}

	public FigureFactory(ApplicationController acontroller,FigureController fcontroller) {
		this.acontroller = acontroller;
		this.amodel = acontroller.getModel();
		acontroller.addObserver(this);
		update(amodel, this);
		this.fcontroller = fcontroller;
		this.fmodel = fcontroller.getModel();
	}

	public Figure createFigure(Point2D.Double point1, Point2D.Double point2) {
		acontroller.setMax(point1, point2);
		Figure create = null;
		if (this.type==RECTANGLE) {
			create = new FigRectangle(point1, point2, this.border, this.fill,this.stroke,this.angle);
		}else if (this.type==ROUNDRECTANGLE) {
			create = new FigRoundRectangle(point1, point2, this.border, this.fill,this.stroke, this.angle);
		} else if (this.type==OVAL) {
			create = new FigOval(point1, point2, this.border, this.fill,this.stroke,this.angle);
		} else if (this.type==CIRCLE) {
			create = new FigCircle(point1, point2, this.border, this.fill,this.stroke,this.angle);
		} else if (this.type==LINE) {
			create = new FigLine(point1, point2, this.border, this.fill,this.stroke,this.angle);
		} else if (this.type==ARROW) {
			create = new FigArrow(point1, point2, this.border, this.fill,this.stroke,this.angle);
		} else if (this.type==ARROWDOUBLE) {
			create = new FigArrowDouble(point1, point2, this.border, this.fill,this.stroke,this.angle);
		} else if (this.type==ARROWFILL) {
			create = new FigArrowFill(point1, point2, this.border, this.fill,this.stroke,this.angle);
		} else if (this.type==ARROWFILLDOUBLE) {
			create = new FigArrowFillDouble(point1, point2, this.border,this.fill, this.stroke,this.angle);
		} else if (this.type==TEXTFIG) {
			create = new Figtxt(point1, this.text,this.pol,this.size,this.style);
		} 
		if (create != null) {
			fcontroller.setLast(create);
		}
		return create;
	}

	public Figure loadFigure(String line) {
		Figure newFigure = null;
		StringTokenizer st = new StringTokenizer(line);
		if (!line.isEmpty() && line.charAt(0) != '#'){
			this.tokenierDecode(st);
			if (this.type==RECTANGLE) {
				newFigure = new FigRectangle(origin, end, border, fill, stroke,angle);
			}else if (this.type==OVAL) {
				newFigure = new FigOval(origin, end, border, fill, stroke,angle);
			}else if (this.type==CIRCLE) {
				newFigure = new FigCircle(origin, end, border, fill, stroke,angle);
			}else if (this.type==LINE) {
				newFigure = new FigLine(origin, end, border, fill, stroke,angle);
			} else if (this.type==ARROWFILL) {
				newFigure = new FigArrowFill(origin, end, border, fill, stroke,angle);
			} else if (this.type==ARROWFILLDOUBLE) {
				newFigure = new FigArrowFillDouble(origin, end, border, fill, stroke,angle);
			} else if  (this.type==ARROW) {
				newFigure = new FigArrow(origin, end, border, fill, stroke,angle);
			} else if (this.type==ARROWDOUBLE) {
				newFigure = new FigArrowDouble(origin, end, border, fill, stroke,angle);
			//} else if (type.equals("txt")) {
			//	newFigure=new Figtxt(origin, this.text,this.pol,this.size);*/
			} else if (this.type==ROUNDRECTANGLE) {
				newFigure = new FigRoundRectangle(origin, end, border, fill, stroke, angle);
			}
		}
		return  newFigure;
	}

	public void tokenierDecode(StringTokenizer st) {
		this.type = Integer.valueOf(st.nextToken()).intValue();
		this.origin = new Point2D.Double(Integer.valueOf(st.nextToken())
				.intValue(), Integer.valueOf(st.nextToken()).intValue());
		this.end = new Point2D.Double(Integer.valueOf(st.nextToken())
				.intValue(), Integer.valueOf(st.nextToken()).intValue());
		this.border = new Color(Integer.valueOf(st.nextToken()).intValue(),
				Integer.valueOf(st.nextToken()).intValue(), Integer.valueOf(
						st.nextToken()).intValue(), Integer.valueOf(
						st.nextToken()).intValue());
		this.fill = new Color(Integer.valueOf(st.nextToken()).intValue(),
				Integer.valueOf(st.nextToken()).intValue(), Integer.valueOf(
						st.nextToken()).intValue(), Integer.valueOf(
						st.nextToken()).intValue());
		this.stroke = Integer.valueOf(st.nextToken()).intValue();
		this.angle = Integer.valueOf(st.nextToken()).intValue();
	}
	
//	@Test
//	public void simpleTest(){
//		assertEquals("firstTest", 1, 1);
//	}
	
	/*@Test
	public void testtokenierDecode(){
		String ligne = "rectangle 371 219 435 422 0 0 0 255 0 0 153 255 5";
		StringTokenizer st = new StringTokenizer(ligne);
		assertEquals("TestTokenType","rectangle", st.nextToken());
		assertEquals("TestTokenOrignX","371", st.nextToken());
		assertEquals("TestTokenOrignY","219", st.nextToken());
		assertEquals("TestTokenEndX","435", st.nextToken());
		assertEquals("TestTokenEndY","422", st.nextToken());
		assertEquals("TestTokenColorBorder",new Color(0,0,0,255),new Color(Integer.valueOf(st.nextToken()).intValue(),
				Integer.valueOf(st.nextToken()).intValue(), Integer.valueOf(
						st.nextToken()).intValue(), Integer.valueOf(
						st.nextToken()).intValue()));
		assertEquals("TestTokenColorFill",new Color(0,0,153,255),new Color(Integer.valueOf(st.nextToken()).intValue(),
				Integer.valueOf(st.nextToken()).intValue(), Integer.valueOf(
						st.nextToken()).intValue(), Integer.valueOf(
						st.nextToken()).intValue()));
		assertEquals("TestTokenStroke","5", st.nextToken());
	}*/

	@Override
	public void update(Observable o, Object arg) {
		type = amodel.getType();
		border = amodel.getBorderColor();
		fill = amodel.getFillColor();
		stroke = amodel.getStroke();
		angle = amodel.getAngle();
		text=amodel.getText();
		size=amodel.getSizeText(); 
		pol=amodel.getOptionTxt();	
		style=amodel.getPoliceText();
  	}
}
