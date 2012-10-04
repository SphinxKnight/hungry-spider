package hci;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

public class Polygon extends Form{
	
	public Polygon(String name, int id, Color color) {
		super(name, id, color);
		// TODO Auto-generated constructor stub
	}
	private String name;
	private ArrayList<Point> listCoord=new ArrayList<Point>();
	private Color color;

	@Override
	public void drawForm(Graphics g1) {
		int i;
		for(i=0;i<listCoord.size()-1;i++){
			g1.drawLine(listCoord.get(i).x,listCoord.get(i).y ,listCoord.get(i+1).x, listCoord.get(i+1).y);
		}
		//And the final one
		g1.drawLine(listCoord.get(i).x,listCoord.get(i).y ,listCoord.get(0).x, listCoord.get(0).y);
	}
	
	public void addPoint(Point pt){
		this.listCoord.add(pt);
	}
	public ArrayList<Point> getListCoord() {
		return listCoord;
	}
	

	
}
