package versionZero.vue;

import java.awt.Color;
import java.awt.Rectangle;

public class ColoredRectangle
{
	private Color foreground;
	private Rectangle rectangle;

	public ColoredRectangle(Color foreground, Rectangle rectangle)
	{
		this.foreground = foreground;
		this.rectangle = rectangle;
	}

	public Color getForeground()
	{
		return foreground;
	}

	public void setForeground(Color foreground)
	{
		this.foreground = foreground;
	}

	public Rectangle getRectangle()
	{
		return rectangle;
	}
}
