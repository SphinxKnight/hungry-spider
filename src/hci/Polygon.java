package hci;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Stroke;
import java.util.ArrayList;

public class Polygon extends Form{
	
	public Polygon(String name, int id, Color color) {
		super(name, id, color);
		this.name = name;
		
		this.color = color;
		this.id = id;
		// TODO Auto-generated constructor stub
	}
	
	
	public Polygon(int id){
		super(id);
		this.name = "Polygon "+Integer.toString(id);
		Color col=new Color((int)(Math.random()*256),
				(int)(Math.random()*256),
				(int)(Math.random()*256));
		this.color = col;
		this.id = id;
	}
	
	private String name;
	private ArrayList<Point> listCoord=new ArrayList<Point>();
	private Color color;
	@SuppressWarnings("unused")
	private int id;

	@Override
	public void drawForm(Graphics g1) {
		g1.setColor(color);
		if (listCoord.size() != 0){
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
	
	public void drawThick2(Graphics g1, Point p){
		
		Stroke stroke = new BasicStroke(3f);
		((Graphics2D) g1).setStroke(stroke);
		g1.setColor(color);
		
		int decalX = p.x;
		int decalY = p.y;

		if (listCoord.size() != 0){
			int i;
			for(i=0;i<listCoord.size()-1;i++){
				g1.drawLine(listCoord.get(i).x + decalX,listCoord.get(i).y + decalY ,listCoord.get(i+1).x + decalX, listCoord.get(i+1).y + decalY);
				g1.fillOval(listCoord.get(i).x + decalX -5,listCoord.get(i).y + decalY -5,10,10);
			}
			//And the final one
			g1.drawLine(listCoord.get(i).x + decalX,listCoord.get(i).y + decalY ,listCoord.get(0).x + decalX, listCoord.get(0).y + decalY);	
			g1.fillOval(listCoord.get(i).x + decalX-5,listCoord.get(i).y + decalY-5,10,10);
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

	// if the polygon is not complete yet, we don't "close" it
	public void drawPartPolygon(Graphics g) {
		if (listCoord.size() != 0){
			int i;
			for(i=0;i<listCoord.size()-1;i++){
				g.drawLine(listCoord.get(i).x,listCoord.get(i).y ,listCoord.get(i+1).x, listCoord.get(i+1).y);
				g.fillOval(listCoord.get(i).x-5,listCoord.get(i).y-5,10,10);
			}
			//And the final vertex	
			g.fillOval(listCoord.get(i).x-5,listCoord.get(i).y-5,10,10);
		}
	}

	public void setName(String newName) {
		this.name=newName;
		
	}
	
	public String getName() {
		return name;
	}


	public void setColor(Color newColor) {
		this.color = newColor;
	}
	
	public Color getColor(){
		return color;
	}

	
}
