package hci;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Form {
	private String name;
	private Color color;
	private int id;
	
	
	public Form(String name, int id,Color color) {
		super();
		this.name = name;
		this.id = id;
		this.color = color;
	}
	
	public Form(int id){
		super();
		this.name = "";
		this.id = id;
		Color col=new Color((int)(Math.random()*256),
				(int)(Math.random()*256),
				(int)(Math.random()*256));
		this.color = col;
	}
	
	public abstract void drawForm(Graphics g1);
	
	
	public String getName(){
		return name;
	}
	public Color getColor(){
		return color;
	}
	public int getId(){
		return id;
	}
	
}
