package hci;

import java.awt.Color;
import java.awt.Point;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class XMLParser {

	private ArrayList<Form> listForm=new ArrayList<Form>();
	private int[] sizeImage=new int[2];
	


	public  void interpretFile(String fileName) throws FileNotFoundException{
		Scanner scanFile = new Scanner(new File(fileName));
		//Assume that docs only have one line (such as labelMe)
		int nbRows = Integer.parseInt(scanFile.findInLine("(?<=<nrows>)[0-9]*(?=</nrows>)"));
		int nbCols = Integer.parseInt(scanFile.findInLine("(?<=<ncols>)[0-9]*(?=</ncols>)"));
		sizeImage[0]=nbRows;
		sizeImage[1]=nbCols;
		//Loop over objects
		String strObject =scanFile.findInLine("(?<=<object>)(.*?)(?=(</object>))");
		while(strObject!=null){
			
			Scanner scanObject = new Scanner(strObject);
			String nameObject = scanObject.findInLine("(?<=<name>)[a-zA-Z_0-9\\s]*(?=</name>)");
			String colString=scanObject.findInLine("(?<=<color>#)[A-F_0-9]*(?=</color>)");
			Color colorObject = null;
			if(colString.length()>0){
				colorObject = Color.decode("#"+colString);
			}
			int idObject =Integer.parseInt(scanObject.findInLine("(?<=<id>)[0-9]*(?=</id>)"));
			String typeObject= scanObject.findInLine("(?<=<)[a-zA-Z_0-9]*?(?=>)");
			if(typeObject.equals("polygon")){
				Polygon poly = new Polygon(nameObject,idObject,colorObject);
				String strPoint = scanObject.findInLine("(?<=<pt>)(.*?)(?=(</pt>))");
				while(strPoint!=null){
//					System.out.println(strPoint);
					Scanner scanObj = new Scanner(strPoint);
					Point pt = new Point(Integer.parseInt(scanObj.findInLine("(?<=<x>)[0-9]*(?=</x>)")),
								Integer.parseInt(scanObj.findInLine("(?<=<y>)[0-9]*(?=</y>)")));
					poly.addPoint(pt);
					strPoint = scanObject.findInLine("(?<=<pt>)(.*?)(?=(</pt>))");
				}
				listForm.add(poly);
			}
			else if(typeObject.equals("oval")){
				String strCenter = scanObject.findInLine("(?<=<center>)(.*?)(?=(</center>))");
				Scanner scanCenter = new Scanner(strCenter);
				Point center = new Point(Integer.parseInt(scanCenter.findInLine("(?<=<x>)[0-9]*(?=</x>)")),
						Integer.parseInt(scanCenter.findInLine("(?<=<y>)[0-9]*(?=</y>)")));
				int height =Integer.parseInt(scanObject.findInLine("(?<=<height>)[0-9]*(?=</height>)"));
				int width =Integer.parseInt(scanObject.findInLine("(?<=<width>)[0-9]*(?=</width>)"));
				Oval oval = new Oval(nameObject, idObject, colorObject,center,height, width);
				listForm.add(oval);
			}
			
			strObject = scanFile.findInLine("(?<=<object>)(.*?)(?=(</object>))");
		}

		
				
	}
	
	
	public ArrayList<Form> getListForm() {
		return listForm;
	}
	
	public int[] getSizeImage() {
		return sizeImage;
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		XMLParser xp = new XMLParser();
		xp.interpretFile("folder.xml");
	}
	
	
	
}
