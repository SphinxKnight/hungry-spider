package hci;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

public class Polygon extends Form{
	
	public Polygon(String name, int id, Color color) {
		super(name, id, color);
		this.name = name;
		this.color = color;
		// TODO Auto-generated constructor stub
	}
	
	public Polygon(int id){
		super(id);
		this.name = "";
		this.color = Color.GREEN;
		this.id = id;
	}
	
	private String name;
	private ArrayList<Point> listCoord=new ArrayList<Point>();
	private Color color;
	private int id;

	@Override
	public void drawForm(Graphics g1) {
		if (listCoord != null){
			int i;
			for(i=0;i<listCoord.size()-1;i++){
				g1.drawLine(listCoord.get(i).x,listCoord.get(i).y ,listCoord.get(i+1).x, listCoord.get(i+1).y);
				g1.fillOval(listCoord.get(i).x-5,listCoord.get(i).y-5,10,10);
			}
			//And the final one
			g1.drawLine(listCoord.get(i).x,listCoord.get(i).y ,listCoord.get(0).x, listCoord.get(0).y);	
		}
	}
	
	// tests if p is a vertex of the polygon, with a margin of 5 pixels
	public boolean isInPolygon(Point p){
		for(Point point : listCoord){
			System.out.println(point);
			if ( (p.getX()>point.getX()-10) && (p.getX()<point.getX()+10) && (p.getY()>point.getY()-10) && (p.getY()<point.getY()+10) )
				return true;
		}
		return false;
	}
	
	public int getSize(){
		System.out.println(listCoord.size());
		return listCoord.size();
	}
	
	public void addPoint(Point pt){
		this.listCoord.add(pt);
	}
	public ArrayList<Point> getListCoord() {
		return listCoord;
	}
	
	public void setListCoord(ArrayList<Point> pointList){
		this.listCoord = pointList;
	}
	

	
}
