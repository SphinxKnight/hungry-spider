package hci;

import hci.frames.LabellerFrame;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Stroke;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 * Handles image editing panel
 * 
 */
public class ImagePanel extends JPanel implements MouseListener, MouseMotionListener {

	private static final long serialVersionUID = 1L;

	//coordinates of the last clicked point
	Point pressed;
	
	//if the last cursor position was a vertex
	boolean vertex = false;
	
	boolean allPoly = false;
	
	//image to be tagged
	BufferedImage image = null;
	
	//list of current polygon's vertices 
	private Polygon currentPolygon = null;
	
	//id attributed to the next polygon we create
	int currentId;
	
	//list of polygons
	ArrayList<Polygon> polygonsList = null;
	
	// default constructor, sets up the window properties
	public ImagePanel() {
		currentId = 0;
		this.currentPolygon = new Polygon(currentId);
		polygonsList = new ArrayList<Polygon>();
		this.setVisible(true);

		Dimension panelSize = new Dimension(800, 600);
		this.setSize(panelSize);
		this.setMinimumSize(panelSize);
		this.setPreferredSize(panelSize);
		this.setMaximumSize(panelSize);
		
		addMouseListener(this);
		addMouseMotionListener(this);
	}
	public ImagePanel(String imageName, ArrayList<Form> formList) throws IOException {
		this.polygonsList = new ArrayList<Polygon>();
		for (Form form : formList) {
			if(form instanceof Polygon){
				this.polygonsList.add((Polygon) form);
				LabellerFrame.addToPolyList(stringForPoly((Polygon) form));
			}
		}
		//currentId = polygonsList.size();
		this.currentPolygon = new Polygon(currentId);
		LabellerFrame.addToPolyList((currentPolygon.getName()));
		this.setVisible(true);
		
		Dimension panelSize = new Dimension(800, 600);
		this.setSize(panelSize);
		this.setMinimumSize(panelSize);
		this.setPreferredSize(panelSize);
		this.setMaximumSize(panelSize);
		
		addMouseListener(this);
		addMouseMotionListener(this);
		image = ImageIO.read(new File(imageName));
		if (image.getWidth() > 800 || image.getHeight() > 600) {
			int newWidth = image.getWidth() > 800 ? 800 : (image.getWidth() * 600)/image.getHeight();
			int newHeight = image.getHeight() > 600 ? 600 : (image.getHeight() * 800)/image.getWidth();
			Image scaledImage = image.getScaledInstance(newWidth, newHeight, Image.SCALE_FAST);
			image = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_RGB);
			image.getGraphics().drawImage(scaledImage,0,0,  this);
		}
	}
	
	/**
	 * extended constructor - loads image to be labeled
	 * @param imageName - path to image
	 * @throws Exception if error loading the image
	 */
	public ImagePanel(String imageName) throws Exception{
		this();
		image = ImageIO.read(new File(imageName));
		if (image.getWidth() > 800 || image.getHeight() > 600) {
			int newWidth = image.getWidth() > 800 ? 800 : (image.getWidth() * 600)/image.getHeight();
			int newHeight = image.getHeight() > 600 ? 600 : (image.getHeight() * 800)/image.getWidth();
			Image scaledImage = image.getScaledInstance(newWidth, newHeight, Image.SCALE_FAST);
			image = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_RGB);
			image.getGraphics().drawImage(scaledImage,0,0,  this);
		}
	}
	public ImagePanel(File imageF) throws Exception{
		this();
		image = ImageIO.read(imageF);
		if (image.getWidth() > 800 || image.getHeight() > 600) {
			int newWidth = image.getWidth() > 800 ? 800 : (image.getWidth() * 600)/image.getHeight();
			int newHeight = image.getHeight() > 600 ? 600 : (image.getHeight() * 800)/image.getWidth();
			Image scaledImage = image.getScaledInstance(newWidth, newHeight, Image.SCALE_FAST);
			image = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_RGB);
			image.getGraphics().drawImage(scaledImage,0,0,  this);
		}
	}

	/**
	 * Displays the image
	 */
	public void ShowImage() {
		Graphics g = this.getGraphics();
		
		if (image != null) {
			g.drawImage(image,0,0, this);
		}
	}
	
	@Override
	public void paint(Graphics g) {
		
		//display image
		ShowImage();
				
		//display all the completed polygons
		for(Polygon polygon : polygonsList) {
			drawPolygon(polygon);
			finishPolygon(polygon);
		}
		//display current polygon
		currentPolygon.drawPartPolygon(g);
	}
	
	/**
	 * displays a polygon without last stroke
	 * @param polygon to be displayed
	 */
	public void drawPolygon(Polygon polygon) {
		Graphics2D g = (Graphics2D)this.getGraphics();
		g.setColor(polygon.getColor());
		polygon.drawForm(g);
	}
	
	/**
	 * displays last stroke of the polygon (arch between the last and first vertices)
	 * @param polygon to be finished
	 */
	public void finishPolygon(Polygon polygon) {
		//if there are less than 3 vertices than nothing to be completed
		if (polygon.getListCoord().size() >= 2) {
			Point firstVertex = polygon.getListCoord().get(0);
			Point lastVertex = polygon.getListCoord().get(polygon.getListCoord().size() - 1);
		
			Graphics2D g = (Graphics2D)this.getGraphics();
			g.setColor(polygon.getColor());
			g.drawLine((int) firstVertex.getX(),(int) firstVertex.getY(), (int) lastVertex.getX(),(int) lastVertex.getY());
		}
	}
	
	/**
	 * moves current polygon to the list of polygons and makes pace for a new one
	 */
	public void addNewPolygon() {
		//finish the current polygon if any
		if (currentPolygon != null ) {
			finishPolygon(currentPolygon);
			polygonsList.add(currentPolygon);
			// 	refresh the polygon panel on the right side
			LabellerFrame.addToPolyList((currentPolygon.getName()));
		}
		currentId++;
		if(currentPolygon.getListCoord().size()>0){
			setCurrentPolygon(new Polygon(currentId));
			LabellerFrame.setEnableCurrPolyButtons(false);
		}
		
		
			LabellerFrame.setEnablePolyButtons(polygonsList.size()>0);
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		
		//check if the cursor within image area
		if (x > image.getWidth() || y > image.getHeight()) {
			//if not do nothing
			return;
		}
		
		Graphics2D g = (Graphics2D)this.getGraphics();
		
		//if the left button than we will add a vertex to poly
		if (e.getButton() == MouseEvent.BUTTON1) {
			g.setColor(currentPolygon.getColor());
			if (currentPolygon.isFirstVertex(new Point(x, y)) && currentPolygon.getSize()>2){
				addNewPolygon();
			}
			else{
				if (currentPolygon.getSize() != 0) {
					Point lastVertex = currentPolygon.getListCoord().get(currentPolygon.getSize() - 1);
					g.drawLine((int) lastVertex.getX(),(int) lastVertex.getY(),(int) x, y);
				}
				g.fillOval(x-5,y-5,10,10);
				
				currentPolygon.addPoint(new Point(x,y));
				LabellerFrame.setEnableCurrPolyButtons(true);
				//currentPolygon.drawForm(g);
			}
		} 
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
		pressed = e.getPoint();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}


	@Override
	public void mouseDragged(MouseEvent e) {
		Point p = e.getPoint();
		
		for(Polygon polygon : polygonsList){
			
			//if we clicked on a polygon's vertex
			int corner = polygon.isInPolygon(pressed);
			if (corner>=0){
				// if we are in the mode where the whole polygon is moved
				if (allPoly){
					ArrayList<Point> newCoord = new ArrayList<Point>();
					for (int i=0; i< polygon.getSize(); i++){
						int newX = (int) (polygon.getListCoord().get(i).getX() + p.getX() - pressed.getX()) ;
						int newY = (int) (polygon.getListCoord().get(i).getY() + p.getY() - pressed.getY()) ;
						newCoord.add(new Point(newX, newY));
						}
					polygon.setListCoord(newCoord);
					Graphics2D g = (Graphics2D)this.getGraphics();
					g.setColor(polygon.getColor());
					paint(g);
				}
				else{
					ArrayList<Point> newCoord = new ArrayList<Point>();
					for (int i=0; i< polygon.getSize(); i++){
						if (i!= corner){
							newCoord.add(polygon.getListCoord().get(i));
						}
						else{
							int newX = (int) (polygon.getListCoord().get(corner).getX() + p.getX() - pressed.getX()) ;
							int newY = (int) (polygon.getListCoord().get(corner).getY() + p.getY() - pressed.getY()) ;
							newCoord.add(new Point(newX, newY));
						}
					}
					polygon.setListCoord(newCoord);
					Graphics2D g = (Graphics2D)this.getGraphics();
					g.setColor(polygon.getColor());
					paint(g);
				}
			}
		}
		pressed = p;
	}


	@Override
	public void mouseMoved(MouseEvent e) {
		boolean oneOfVertex = false;
		// we deselect the previous polygon, if there was one
		if(vertex){
			paint(this.getGraphics());
		}
		
		for (Polygon polygon:polygonsList){
			if (polygon.isInPolygon(e.getPoint())>=0){
				drawThick(polygon);
				oneOfVertex = true;
				Graphics g = this.getGraphics();
				g.drawImage(textToImage(polygon.getName()), e.getX(), e.getY()-12, null);
				//g.drawImage(textToImage(stringForPoly(polygon)), e.getX(), e.getY()-12, null);
			}
		}
		vertex = oneOfVertex;
	}
	
	
	public String stringForPoly(Polygon polygon) {
		String listText;
		if (!polygon.getName().equals("")){
			listText = polygon.getName();
		}
		else{
			listText = "Polygon number "+polygon.getId();
		}
		return listText;
	}

	public Polygon getCurrentPolygon() {
		return currentPolygon;
	}


	public void setCurrentPolygon(Polygon currentPolygon) {
		this.currentPolygon = currentPolygon;
	}
	
	public void setAllPoly(boolean b){
		this.allPoly = b;
	}
	
	public int getNumberPolygon(){
		return polygonsList.size();
	}


	public ArrayList<Polygon> getPolygonsList() {
		return polygonsList;
	}
	
	public void drawThick(Polygon poly){
		
		Graphics g1 = this.getGraphics();
		g1.setColor(poly.getColor());

		paint(g1);
		
		Stroke stroke = new BasicStroke(3f);
		((Graphics2D) g1).setStroke(stroke);
		
		if (poly.getSize() != 0){
			int i;
			for(i=0;i<poly.getSize()-1;i++){
				g1.drawLine(poly.getListCoord().get(i).x ,poly.getListCoord().get(i).y ,poly.getListCoord().get(i+1).x, poly.getListCoord().get(i+1).y);
				g1.fillOval(poly.getListCoord().get(i).x -5,poly.getListCoord().get(i).y -5,10,10);
			}
			//And the final one
			g1.drawLine(poly.getListCoord().get(i).x,poly.getListCoord().get(i).y ,poly.getListCoord().get(0).x ,poly.getListCoord().get(0).y);	
			g1.fillOval(poly.getListCoord().get(i).x-5,poly.getListCoord().get(i).y -5,10,10);
		}
	}
	
	public void setPolyColor(int i, Color color){
		polygonsList.get(i).setColor(color);
	}
	
	
	public void setPolygonsList(ArrayList<Polygon> polygonsList) {
		this.polygonsList = polygonsList;
	}
	public BufferedImage textToImage(String text){
	       
        //create the font you wish to use
        Font font = new Font("Tahoma", Font.PLAIN, 11);
       
        //create the FontRenderContext object which helps us to measure the text
        FontRenderContext frc = new FontRenderContext(null, true, true);
        
        //get the height and width of the text
        Rectangle2D bounds = font.getStringBounds(text, frc);
        int w = (int) bounds.getWidth();
        int h = (int) bounds.getHeight();
       
        //create a BufferedImage object
        BufferedImage image = new BufferedImage(w, h,   BufferedImage.TYPE_INT_RGB);
       
        //calling createGraphics() to get the Graphics2D
        Graphics2D g = image.createGraphics();
       
        //set color and other parameters
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, w, h);
        g.setColor(Color.BLACK);
        g.setFont(font);
            
        g.drawString(text, (float) bounds.getX(), (float) -bounds.getY());
      
        //releasing resources
        g.dispose();
        
        return image;
	}


	
	
	
	
	
}
