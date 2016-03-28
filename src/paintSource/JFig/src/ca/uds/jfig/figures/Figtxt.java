package ca.uds.jfig.figures;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.font.TextAttribute;
import java.awt.geom.Point2D;
import java.util.Hashtable;
import java.util.Map;

import ca.uds.jfig.jfigInterface.FigureInterface;

public class Figtxt extends Figure implements FigureInterface{

	private String txt;
	private int x1, y1;
	private String style="Verdana";
	private int size;
	private int type;

	public Figtxt(Point2D point1, String txt, int type, int size, String style) {
		x1 = (int) point1.getX();
		y1 = (int) point1.getY();
		this.txt = txt;
		if (style != null) this.style = style;
		this.size = size;
		this.type = type;
	}

	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		Map<TextAttribute, Object> map = new Hashtable<TextAttribute, Object>();
		map.put(TextAttribute.FAMILY, style);
		if ((type == 2) || (type == 3) || (type == 6) || (type == 7))
			map.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
		if ((type == 1) || (type == 3) || (type == 5) || (type == 7))
			map.put(TextAttribute.POSTURE, TextAttribute.POSTURE_OBLIQUE);
		if (type<=4)
			map.put(TextAttribute.WEIGHT, TextAttribute.WEIGHT_BOLD);
		map.put(TextAttribute.SIZE, size);
		g2.setFont(new Font(map));
		g2.drawString(txt, x1, y1);
	}

	public String toString() {
		return TEXTFIG + " " + (int) this.x1 + " " + (int) this.y1 + " "
				+ this.txt + " " + this.size;
	}

	public boolean contains(Point2D p) {
		return false;
	}
}
