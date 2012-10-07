package hci;

import java.awt.Point;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class XMLwriter {
		
	public static void writeOval(FileWriter writer, Oval oval) throws IOException{
		writer.append("<object>");
			writer.append("<name>"+oval.getName()+"</name>");
			writer.append("<color>"+oval.getColor()+"</color>");
			writer.append("<deleted>0</deleted>");
			writer.append("<verified>0</verified>");
			SimpleDateFormat d1 = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
			writer.append("<date>"+d1.format(new Date())+"</date>");
			writer.append("<id>"+Integer.toString(oval.getId())+"</id>");
			writer.append("<oval>");
				writer.append("<username>Test</username>");
				writer.append("<center>");
					writer.append("<x>"+Integer.toString((int) oval.getCenter().getX())+"</x>");
					writer.append("<y>"+Integer.toString((int) oval.getCenter().getY())+"</y>");
				writer.append("</center>");
				writer.append("<width>"+Integer.toString(oval.getWidth())+"</width>");
				writer.append("<height>"+Integer.toString(oval.getWidth())+"</height>");
			writer.append("</oval>");
		writer.append("</object>");
	}
	
	public static void writePolygon(FileWriter writer, Polygon poly) throws IOException{
		writer.append("<object>");
		writer.append("<name>"+poly.getName()+"</name>");
		writer.append("<color>"+poly.getColor()+"</color>");
		writer.append("<deleted>0</deleted>");
		writer.append("<verified>0</verified>");
		SimpleDateFormat d1 = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
		writer.append("<date>"+d1.format(new Date())+"</date>");
		writer.append("<id>"+Integer.toString(poly.getId())+"</id>");
		writer.append("<polygon>");
			writer.append("<username>Test</username>");
			ArrayList<Point> listPoints = new ArrayList<Point>();
			listPoints = poly.getListCoord();
			for(int i=0;i<listPoints.size();i++){
				writer.append("<pt>");
					writer.append("<x>"+Integer.toString((int) listPoints.get(i).getX())+"</x>");
					writer.append("<y>"+Integer.toString((int) listPoints.get(i).getY())+"</y>");
				writer.append("</pt>");
			}
		writer.append("</polygon>");
	writer.append("</object>");
	}
	

}
