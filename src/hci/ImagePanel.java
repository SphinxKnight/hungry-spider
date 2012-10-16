package hci;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
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
	
	boolean dragged = false;
	
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
		setCurrentPolygon(new Polygon(currentId));
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
			System.out.println("SCALING TO " + newWidth + "x" + newHeight );
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
			g.drawImage(
					image,0,0, this);
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
		drawPolygon(getCurrentPolygon());
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
		if (polygon.getListCoord().size() >= 3) {
			Point firstVertex = polygon.getListCoord().get(0);
			Point lastVertex = polygon.getListCoord().get(polygon.getListCoord().size() - 1);
		
			Graphics2D g = (Graphics2D)this.getGraphics();
			g.setColor(Color.GREEN);
			g.drawLine((int) firstVertex.getX(),(int) firstVertex.getY(), (int) lastVertex.getX(),(int) lastVertex.getY());
		}
	}
	
	/**
	 * moves current polygon to the list of polygons and makes pace for a new one
	 */
	public void addNewPolygon() {
		//finish the current polygon if any
		if (getCurrentPolygon() != null ) {
			finishPolygon(getCurrentPolygon());
			polygonsList.add(getCurrentPolygon());
		}
		
		currentId++;
		setCurrentPolygon(new Polygon(currentId));
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
			g.setColor(Color.GREEN);
			if (getCurrentPolygon().getSize() != 0) {
				Point lastVertex = getCurrentPolygon().getListCoord().get(getCurrentPolygon().getSize() - 1);
				g.drawLine((int) lastVertex.getX(),(int) lastVertex.getY(),(int) x, y);
			}
			g.fillOval(x-5,y-5,10,10);
			
			getCurrentPolygon().addPoint(new Point(x,y));
			//currentPolygon.drawForm(g);
			System.out.println(x + " " + y);
		} 
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
		System.out.println("pressed");
		pressed = e.getPoint();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if (dragged){
			Point p = e.getPoint();
			
			for(Polygon polygon : polygonsList){
				System.out.println("au moins 1");
				//if we clicked on a polygon's vertex
				if (polygon.isInPolygon(pressed)){
					System.out.println("is in");
					ArrayList<Point> newCoord = new ArrayList<Point>();
					System.out.println("1");
					for (int i=0; i< polygon.getSize(); i++){
						System.out.println("for1");
						int newX = (int) (polygon.getListCoord().get(i).getX() + p.getX() - pressed.getX()) ;
						System.out.println("2");
						int newY = (int) (polygon.getListCoord().get(i).getY() + p.getY() - pressed.getY()) ;
						System.out.println("3");
						newCoord.add(new Point(newX, newY));
						System.out.println("4");

					}
					polygon.setListCoord(newCoord);
					System.out.println("5");
					Graphics2D g = (Graphics2D)this.getGraphics();
					System.out.println("6");
					g.setColor(polygon.getColor());
					System.out.println("6");
					polygon.drawForm(g);
					System.out.println("7");
				}
				System.out.println("is out");
			}
		}
		dragged = false;
	}


	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("dragged");
		dragged = true;

	}


	@Override
	public void mouseMoved(MouseEvent arg0) {		
	}

	public Polygon getCurrentPolygon() {
		return currentPolygon;
	}


	public void setCurrentPolygon(Polygon currentPolygon) {
		this.currentPolygon = currentPolygon;
	}
	
}
