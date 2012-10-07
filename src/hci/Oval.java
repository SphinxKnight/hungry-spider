package hci;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Oval extends Form{

	private Point center;
	private int height;
	private int width;

	public Oval(String name, int id, Color color) {
		super(name, id, color);
		
	}
	public Oval(String name, int id, Color color,
			Point center, int height, int width) {
		super(name, id, color);
		this.center = center;
		this.height = height;
		this.width = width;
	}
	public void drawForm(Graphics g1) {
		g1.drawOval(center.x, center.y, width, height);
		
	}

	public Point getCenter() {
		return center;
	}
	
	public int getHeight() {
		return height;
	}
	public int getWidth() {
		return width;
	}
	
	
}
