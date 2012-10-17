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
			g1.fillOval(listCoord.get(i).x-5,listCoord.get(i).y-5,10,10);
		}
	}
	
	// tests if p is a vertex of the polygon, with a margin of 5 pixels
	public int isInPolygon(Point p){
		if (listCoord.size() == 0)
			return -1;
		for(int i=0; i<listCoord.size(); i++){
			Point point = listCoord.get(i);
			if ( (p.getX()>point.getX()-5) && (p.getX()<point.getX()+5) && (p.getY()>point.getY()-5) && (p.getY()<point.getY()+5) )
				return i;
		}
		return -1;
	}
	
	public boolean isFirstVertex(Point p){
		if (listCoord.size() == 0)
			return false;
		Point point = listCoord.get(0);
		if ( (p.getX()>point.getX()-5) && (p.getX()<point.getX()+5) && (p.getY()>point.getY()-5) && (p.getY()<point.getY()+5) )
			return true;
		else
			return false;
	}
	
	public int getSize(){
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
