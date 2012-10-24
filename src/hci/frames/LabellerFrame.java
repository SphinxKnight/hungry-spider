package hci.frames;
import hci.CollectionUtils;
import hci.Form;
import hci.ImagePanel;
import hci.Polygon;
import hci.XMLwriter;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComponent;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JToggleButton;
import javax.swing.JTree;
import javax.swing.LayoutStyle;
import javax.swing.ListModel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;


/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class LabellerFrame extends javax.swing.JFrame implements ActionListener {

	{
		//Set Look & Feel
		try {
			javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JScrollPane jScrollPane1;
	private JTree jTree1;
	private static JButton jButton1;
	private JPanel jPanel4;
	private JButton jButton5;
	private JButton jButton4;
	private JPanel jPanel3;
	private JPanel jPanel2;
	private JTabbedPane jTabbedPane1;
	private JButton jButton2;
	private JToggleButton jToggle1;
	private static JList polyList = new JList();
	private static JButton jButton10;
	private static JButton jButton9;
	private JButton jButton8;
	private JButton jButton7;
	private JButton jButton6;
	private JPanel jPanel1;
	private ImagePanel imagePanel;
	private String currentCollection = "CollecTest1";
	private String currentImage = "test.jpeg";
	private static boolean saveNeeded = false;
	private static int lastSelected = 0;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				LabellerFrame inst = new LabellerFrame();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public LabellerFrame() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setTitle("Labeller");
			{
				jScrollPane1 = new JScrollPane();
				getContentPane().add(jScrollPane1, BorderLayout.CENTER);
				jScrollPane1.setSize(1024, 768);
				jScrollPane1.setPreferredSize(new java.awt.Dimension(1397, 721));
				{
					jPanel1 = new JPanel();
					jScrollPane1.setViewportView(jPanel1);
					GroupLayout jPanel1Layout = new GroupLayout((JComponent)jPanel1);
					jPanel1.setLayout(jPanel1Layout);
					jPanel1.setPreferredSize(new java.awt.Dimension(1326, 702));
					{
						jButton4 = new JButton();
						jButton4.setText("<");
						jButton4.addActionListener(new SwitchImageListener("left",imagePanel,this));
					}
					{
						jButton2 = new JButton();
						jButton2.setText("Close this polygon");
						jButton2.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e){
				                imagePanel.addNewPolygon();
				                repaint();
				            }
				        });       
					}
					{
						jToggle1 = new JToggleButton();
						jToggle1.setText("Move whole Polygon");
						jToggle1.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e){
								imagePanel.setAllPoly(jToggle1.isSelected());
				            }
				        });       
					}
					{
						jPanel4 = new JPanel();
						BorderLayout jPanel4Layout = new BorderLayout();
						jPanel4.setLayout(jPanel4Layout);
						jPanel4.setSize(800, 600);
						{
							this.imagePanel = new ImagePanel("test.jpeg");
							jPanel4.add(imagePanel, BorderLayout.CENTER);
							imagePanel.setPreferredSize(new java.awt.Dimension(842, 554));
							FlowLayout imagePanelLayout = new FlowLayout();
							this.imagePanel.setLayout(imagePanelLayout);
							this.imagePanel.setOpaque(true);
						}
					}
					{
						jButton8 = new JButton();
						jButton8.setText("Color");
						jButton8.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e){
								Color newPolyColor = JColorChooser.showDialog(null, "Choose a new polygon's color", null);
								(imagePanel.getPolygonsList().get(lastSelected)).setColor(newPolyColor);
								Graphics2D g = (Graphics2D)imagePanel.getGraphics();
								g.setColor(newPolyColor);
								imagePanel.paint(g);
				            }
				        });   
					}
					{
						jTabbedPane1 = new JTabbedPane();
						{
							jPanel2 = new JPanel();
							jTabbedPane1.addTab("My Labels", null, jPanel2, null);
							BorderLayout jPanel2Layout = new BorderLayout();
							jPanel2.setLayout(jPanel2Layout);

							jPanel2.setLayout(new GridLayout(1, 1));
							jPanel2.setAutoscrolls(true);
							{
								ListModel jList1Model = 
										new DefaultComboBoxModel(new String[] { });
								polyList = new JList();
								jPanel2.add(polyList, "North");
								polyList.addMouseListener(new MouseListener(){
									
									@Override
									public void mouseClicked(MouseEvent e) {
										
										int index = polyList.getSelectedIndex();
										lastSelected = index;
										imagePanel.drawThick(imagePanel.getPolygonsList().get(index) , new Point(0,0));
									}
									public void mouseEntered(MouseEvent e) {}
									public void mouseExited(MouseEvent e) {}
									public void mousePressed(MouseEvent e) {}
									public void mouseReleased(MouseEvent e) {}
									
								});
								polyList.setModel(jList1Model);
								polyList.setPreferredSize(new java.awt.Dimension(270, 480));
								//polyList.setPreferredSize(new java.awt.Dimension(270, 38));
							}

						}
						{
							jPanel3 = new JPanel();
							jTabbedPane1.addTab("My Collection", null, jPanel3, null);
							BorderLayout jPanel3Layout = new BorderLayout();
							jPanel3.setLayout(jPanel3Layout);
							{
								jTree1 = new JTree();
								jTree1 = CollectionUtils.getTreeCollections();
								BorderLayout jTree1Layout = new BorderLayout();
								jTree1.setLayout(jTree1Layout);
								jPanel3.add(jTree1, BorderLayout.CENTER);
								jTree1.setPreferredSize(new java.awt.Dimension(166, 234));
							}
						}
					}
					{
						jButton10 = new JButton();
						jButton10.setText("Delete");
						jButton10.setEnabled(false);
						jButton10.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e){
								int n = JOptionPane.showConfirmDialog(
								    jPanel1,
								    "You are about to delete this polygon \n"
								    + "Continue ?",
								    "Polygon deletion",
								    JOptionPane.YES_NO_OPTION);
								if (n==0){
									removeFromPolyList(lastSelected);
									imagePanel.getPolygonsList().remove(lastSelected);
									Graphics2D g = (Graphics2D)imagePanel.getGraphics();
									imagePanel.paint(g);
									if (imagePanel.getNumberPolygon()==0){
										jButton9.setEnabled(false);
										jButton10.setEnabled(false);
									}
									lastSelected = Math.min(lastSelected, imagePanel.getNumberPolygon()-1);
									polyList.setSelectedIndex(lastSelected);
								}
							}
						});
					}
					{
						jButton9 = new JButton();
						jButton9.setText("Label");
						jButton9.setEnabled(false);
						jButton9.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e){
				                //TODO
								Object[] possibilities = null;
								String s = (String)JOptionPane.showInputDialog(
								                    jPanel1,
								                    "New polygon's label :",
								                    "Edit Label",
								                    JOptionPane.PLAIN_MESSAGE,
								                    null,
								                    possibilities,
								                    "");

								if ((s != null) && (s.length() > 0)) {
								    imagePanel.getPolygonsList().get(lastSelected).setName(s);
								    polyList.setSelectedIndex(lastSelected);
								    editPolyList(imagePanel.stringForPoly(imagePanel.getPolygonsList().get(lastSelected)));
								}
				            }
				        });       
					}
					{
						jButton6 = new JButton();
						jButton6.setText("+");
					}
					{
						jButton7 = new JButton();
						jButton7.setText("-");
					}
					{
						jButton5 = new JButton();
						jButton5.setOpaque(true);
						jButton5.setText(">");
						jButton5.addActionListener(new SwitchImageListener("right",imagePanel,this));

					}
					{
						jButton1 = new JButton();
						jButton1.setText("Cancel current");
						jButton1.setEnabled(false);
						jButton1.addActionListener(new ActionListener(){

							@Override
							public void actionPerformed(ActionEvent e) {
								if(imagePanel.getCurrentPolygon().getListCoord().size()>0){
									int id=polyList.getModel().getSize()-1;
									imagePanel.setCurrentPolygon(new Polygon(id));
								}
								else if(imagePanel.getCurrentPolygon().getListCoord().size()==0){
									jButton1.setEnabled(false);
								}
								Graphics2D g = (Graphics2D)imagePanel.getGraphics();
								imagePanel.paint(g);
								jButton1.setEnabled(false);
							}
							
						});
					}

					jPanel1Layout.setHorizontalGroup(jPanel1Layout.createSequentialGroup()
						.addContainerGap()
						.addComponent(jButton4, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(jPanel1Layout.createParallelGroup()
						    .addComponent(jPanel4, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 865, GroupLayout.PREFERRED_SIZE)
						    .addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
						        .addGap(156)
						        .addComponent(jButton2, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
						        .addGap(72)
						        .addComponent(jToggle1, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
						        .addGap(97)
						        .addComponent(jButton1, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
						        .addGap(125)))
						.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(jButton5, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(jPanel1Layout.createParallelGroup()
						    .addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
						        .addComponent(jButton10, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
						        .addGap(0, 11, Short.MAX_VALUE))
						    .addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
						        .addComponent(jButton9, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
						        .addGap(0, 11, Short.MAX_VALUE))
						    .addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
						        .addComponent(jButton8, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
						        .addGap(0, 11, Short.MAX_VALUE))
						    .addGroup(jPanel1Layout.createSequentialGroup()
						        .addGap(35)
						        .addGroup(jPanel1Layout.createParallelGroup()
						            .addGroup(jPanel1Layout.createSequentialGroup()
						                .addComponent(jButton6, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
						                .addGap(0, 0, Short.MAX_VALUE))
						            .addComponent(jButton7, GroupLayout.Alignment.LEADING, 0, 45, Short.MAX_VALUE))))
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jTabbedPane1, GroupLayout.PREFERRED_SIZE, 270, GroupLayout.PREFERRED_SIZE));
					jPanel1Layout.linkSize(SwingConstants.HORIZONTAL, new Component[] {jButton6, jButton7});
					jPanel1Layout.linkSize(SwingConstants.HORIZONTAL, new Component[] {jButton8, jButton9, jButton10});
					jPanel1Layout.linkSize(SwingConstants.HORIZONTAL, new Component[] {jButton5, jButton4});
					jPanel1Layout.setVerticalGroup(jPanel1Layout.createSequentialGroup()
						.addContainerGap(11, 11)
						.addGroup(jPanel1Layout.createParallelGroup()
						    .addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
						        .addComponent(jPanel4, GroupLayout.PREFERRED_SIZE, 603, GroupLayout.PREFERRED_SIZE)
						        .addGap(0, 39, Short.MAX_VALUE)
						        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						            .addComponent(jButton2, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
						            .addComponent(jToggle1, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
						            .addComponent(jButton1, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
						        .addGap(35))
						    .addGroup(jPanel1Layout.createSequentialGroup()
						        .addGap(155)
						        .addGroup(jPanel1Layout.createParallelGroup()
						            .addGroup(jPanel1Layout.createSequentialGroup()
						                .addGap(0, 0, Short.MAX_VALUE)
						                .addComponent(jTabbedPane1, GroupLayout.PREFERRED_SIZE, 549, GroupLayout.PREFERRED_SIZE))
						            .addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
						                .addGap(26)
						                .addComponent(jButton6, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						                .addGroup(jPanel1Layout.createParallelGroup()
						                    .addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						                        .addComponent(jButton5, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
						                        .addComponent(jButton7, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
						                    .addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
						                        .addGap(14)
						                        .addComponent(jButton4, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)))
						                .addComponent(jButton8, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						                .addComponent(jButton9, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
						                .addComponent(jButton10, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						                .addGap(0, 329, Short.MAX_VALUE))))));
					jPanel1Layout.linkSize(SwingConstants.VERTICAL, new Component[] {jButton6, jButton8, jButton9, jButton10});
					jPanel1Layout.linkSize(SwingConstants.VERTICAL, new Component[] {jButton5, jButton4});
				}
			}
			pack();
			this.setSize(1357, 751);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	public void paint(Graphics g) {
		
		super.paint(g);
		imagePanel.paint(g); //update image panel
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
	}
	
	public static void addToPolyList(String s){
		ListModel currentModel = polyList.getModel();
		((DefaultComboBoxModel) currentModel).addElement(s);
		jButton10.setEnabled(true);
		jButton9.setEnabled(true);
		saveNeeded = true;
	}
	
	public static void removeFromPolyList(int index){
		ListModel currentModel = polyList.getModel();
		((DefaultComboBoxModel) currentModel).removeElementAt(index);
		saveNeeded = true;
	}
	
	public void editPolyList(String s){
		//TODO pour l'instant ne fonctionne pas
		ListModel currentModel = polyList.getModel();
		((DefaultComboBoxModel) currentModel).setSelectedItem(s);
		saveNeeded = true;
	}
	
	public static void setEnablePolyButtons(boolean b){
		jButton9.setEnabled(b);
		jButton10.setEnabled(b);
	}
	public static void setEnableCurrPolyButtons(boolean b){
		jButton1.setEnabled(b);
	}

	public String getCurrentCollection() {
		return currentCollection;
	}

	public void setCurrentCollection(String currentCollection) {
		this.currentCollection = currentCollection;
	}

	public String getCurrentImage() {
		return currentImage;
	}

	public void setCurrentImage(String currentImage) {
		this.currentImage = currentImage;
	}

	public boolean isSaveNeeded() {
		return saveNeeded;
	}

	@SuppressWarnings("static-access")
	public void setSaveNeeded(boolean saveNeeded) {
		this.saveNeeded = saveNeeded;
	}
	
	public ImagePanel getImagePanel() {
		return imagePanel;
	}

	public void setImagePanel(ImagePanel imagePanel2,ArrayList<Form> listForm) throws Exception {
		this.imagePanel = imagePanel2;
		FlowLayout imagePanelLayout = new FlowLayout();
		this.imagePanel.setLayout(imagePanelLayout);
		jPanel4.remove(0);
		jPanel4.add(this.imagePanel);
		this.imagePanel.setOpaque(true);
		ListModel currentModel = polyList.getModel();
		((DefaultComboBoxModel) currentModel).removeAllElements();
		for (Form polygon : listForm) {
			((DefaultComboBoxModel) currentModel).addElement(polygon.getName());
		}
		polyList.repaint();
		imagePanel.repaint();
		this.repaint();
	}

	@SuppressWarnings("static-access")
	public void save(){
		ArrayList<Polygon> listPoly = imagePanel.getPolygonsList();
		File xmlSave=new File("./MyCollections/"+currentCollection+"/"+currentImage.split("\\.")[0]+".xml");
		if(xmlSave.isFile()){
			xmlSave.delete();
		}
		try {
			FileWriter w = new FileWriter(xmlSave);
			int nrows= Math.min(800,ImageIO.read(new File("./MyCollections/"+currentCollection+"/"+currentImage)).getWidth());
			int ncols= Math.min(600,ImageIO.read(new File("./MyCollections/"+currentCollection+"/"+currentImage)).getHeight());
			XMLwriter.writeHeader(w, currentImage.split("\\.")[0],currentCollection, nrows, ncols);
			for (Polygon polygon : listPoly) {
				XMLwriter.writePolygon(w, polygon);
			} 
			XMLwriter.writeFooter(w);
			w.close();
			this.saveNeeded = false;
		} catch (IOException e) {
			//POP UP error
			e.printStackTrace();
		}
	}


}
