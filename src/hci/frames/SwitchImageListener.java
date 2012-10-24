package hci.frames;

import hci.Form;
import hci.ImagePanel;
import hci.XMLParser;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

public class SwitchImageListener implements ActionListener {

	private String direction;
	private String currentImage;
	private String currentCollection;
	private ImagePanel imagePanel;
	private boolean saveNeeded;
	private LabellerFrame lf;
	public SwitchImageListener(String direction, ImagePanel imagePanel, LabellerFrame lf) {
		this.direction = direction;
		this.currentImage = lf.getCurrentImage();
		this.currentCollection= lf.getCurrentCollection();
		this.imagePanel= imagePanel;
		this.saveNeeded=lf.isSaveNeeded();
		this.lf=lf;
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		this.currentImage = lf.getCurrentImage();
		this.currentCollection= lf.getCurrentCollection();
		this.imagePanel= lf.getImagePanel();
		this.saveNeeded= lf.isSaveNeeded();
		if(saveNeeded){
			PopUpFrame saveQuestion = new PopUpFrame("Do you want to save the current image and annotation?",this);
			saveQuestion.setLocationRelativeTo(null);
			saveQuestion.setAlwaysOnTop(true);
			saveQuestion.setVisible(true);
		}
		else{
			changeImage();
		}
	}
	public void save(){
		//save file 
		//name of image
		lf.save();
		//list of polygons 
		//write file
		changeImage();
	}
	public void changeImage(){
		File dir = new File("./MyCollections/"+currentCollection);
		ArrayList<String> listImageInCollec = new ArrayList<String>();
		String[] children = dir.list();
		if (children == null) {
		    // Either dir does not exist or is not a directory
		} else {
		    for (int i=0; i<children.length; i++) {
		        // Get filename of file or directory
		        String filename = children[i];
		        if(filename.endsWith("jpg")||filename.endsWith("jpeg")||filename.endsWith("JPG")||filename.endsWith("png")){
		        	listImageInCollec.add(filename);
		        }
		    }
		}
		int indexCurr=listImageInCollec.indexOf(currentImage);
		String newImage =null;
		if(direction.equals("left")){
			if(indexCurr==listImageInCollec.size()-1){
				newImage= listImageInCollec.get(0);
			}
			else{
				newImage = listImageInCollec.get(indexCurr+1);
			}
		}
		else if(direction.equals("right")){
			if(indexCurr==0){
				newImage = listImageInCollec.get(listImageInCollec.size()-1);
				
			}
			else{
				newImage = listImageInCollec.get(indexCurr-1);
			}
		}
		try {
			ArrayList<Form> xmlFormList = new ArrayList<Form>();
			//check if xml already exists
			File xmlFile = new File("./MyCollections/"+currentCollection+"/"+newImage.split("\\.")[0]+".xml");
			if(xmlFile.isFile()){
				XMLParser xp = new XMLParser();
				xp.interpretFile("./MyCollections/"+currentCollection+"/"+newImage.split("\\.")[0]+".xml");
				xmlFormList = xp.getListForm();
				
			}
			if(xmlFormList.size()>0){
				imagePanel = new ImagePanel("./MyCollections/"+currentCollection+"/"+newImage,xmlFormList);
			}
			else{
				imagePanel = new ImagePanel("./MyCollections/"+currentCollection+"/"+newImage);
			}
			lf.setImagePanel(imagePanel,xmlFormList);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		lf.setCurrentImage(newImage);
		
		
		return;
	}

	public String getCurrentImage() {
		return currentImage;
	}

	public void setCurrentImage(String currentImage) {
		this.currentImage = currentImage;
	}
	
}
