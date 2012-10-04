package hci;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Oval extends Form{
	
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

	private Point center;
	private int height;
	private int width;

	
	
}
