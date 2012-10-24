package hci.frames;
import hci.CollectionUtils;
import hci.CopyFile;
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
import javax.swing.JFileChooser;
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
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.text.Position;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreePath;
import java.awt.BasicStroke;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Stroke;
import java.awt.event.MouseMotionListener;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

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
	private JButton jButton13;
	private JButton jButton12;
	private JButton jButton11;
	private JButton jButton3;
	private JPanel jPanel5;
	private static JButton jButton10;
	private static JButton jButton9;
	private static JButton jButton8;
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
						jButton8.setEnabled(false);
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
						jTabbedPane1.addMouseListener(new MouseListener() {
							
							@Override
							public void mouseReleased(MouseEvent e) {
								Graphics2D g = (Graphics2D)imagePanel.getGraphics();
								
								if(g!=null){
									g.setColor(imagePanel.getCurrentPolygon().getColor());
									imagePanel.paint(g);
								}
								else{
									repaint();
									imagePanel.repaint();
								}
								
								
							}
							
							@Override
							public void mousePressed(MouseEvent e) {}
							
							@Override
							public void mouseExited(MouseEvent e) {}
							
							@Override
							public void mouseEntered(MouseEvent e) {}
							
							@Override
							public void mouseClicked(MouseEvent e) {
								Graphics2D g = (Graphics2D)imagePanel.getGraphics();
								
								if(g!=null){
									g.setColor(imagePanel.getCurrentPolygon().getColor());
									imagePanel.paint(g);
								}
								else{
									repaint();
									imagePanel.repaint();
								}
								
							}
						});
						jTabbedPane1.addChangeListener(new ChangeListener() {
							public void stateChanged(ChangeEvent evt) {
								Graphics2D g = (Graphics2D)imagePanel.getGraphics();
								
								if(g!=null){
									g.setColor(imagePanel.getCurrentPolygon().getColor());
									imagePanel.paint(g);
								}
								else{
									repaint();
									imagePanel.repaint();
								}
							}
						});
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
										Polygon polySelected = imagePanel.getPolygonsList().get(index);
										imagePanel.drawThick( polySelected);
										Point labelPoint = polySelected.getListCoord().get(0);
										Graphics g = imagePanel.getGraphics();
										g.drawImage((Image)imagePanel.textToImage(imagePanel.stringForPoly(polySelected)), (int)labelPoint.getX(), (int)labelPoint.getY()-12, null);
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
								jPanel5 = new JPanel();
								GridLayout jPanel5Layout = new GridLayout(1, 1);
								jPanel5Layout.setHgap(5);
								jPanel5Layout.setVgap(5);
								jPanel5Layout.setColumns(1);
								jPanel5.setLayout(jPanel5Layout);
								jPanel3.add(jPanel5, BorderLayout.NORTH);
								jPanel5.setPreferredSize(new java.awt.Dimension(270, 58));
								{
									//add an image
									jButton3 = new JButton();
									jPanel5.add(jButton3);
									jButton3.setLayout(null);
									jButton3.setText("+Im");
									jButton3.setToolTipText("Add an image");
									jButton3.setPreferredSize(new java.awt.Dimension(37, 25));
									jButton3.addActionListener(new ActionListener() {
										
										@Override
										public void actionPerformed(ActionEvent arg0) {
											final JFileChooser fc = new JFileChooser();
											int returnVal = fc.showOpenDialog(jPanel1);
											 if (returnVal == JFileChooser.APPROVE_OPTION) {
										            File file = fc.getSelectedFile();
										        	DefaultTreeModel d2 = (DefaultTreeModel) jTree1.getModel();
										            File dest = new File("./MyCollections/"+currentCollection+"/"+file.getName());
										            CopyFile.copyfile(file.getAbsolutePath(),dest.getAbsolutePath());
										            TreePath path = jTree1.getNextMatch(currentCollection, 0, Position.Bias.Forward);
										            MutableTreeNode node = (MutableTreeNode) path.getLastPathComponent();
										            d2.insertNodeInto(new DefaultMutableTreeNode(dest.getName()), node,node.getChildCount());
										            
										        } else {
										            
										        }
											
										}
									
									});
								}
								{	//delete an image
									jButton11 = new JButton();
									jPanel5.add(jButton11);
									jButton11.setText("-Im");
									jButton11.setToolTipText("Remove this image");
									jButton11.setPreferredSize(new java.awt.Dimension(109, 25));
									final SwitchImageListener s1 = new SwitchImageListener("right",imagePanel,this);

									jButton11.addActionListener(new ActionListener() {
										public void actionPerformed(ActionEvent evt) {
											//Image selected or current image ?
											DefaultTreeModel d2 = (DefaultTreeModel) jTree1.getModel();
//											if(jTree1.getSelectionPath()==null){
//												//Deleting current image
//												int n = JOptionPane.showConfirmDialog(
//													    jPanel1,
//													    "You are about to delete the image \n"
//													    +currentImage+"\n"
//													    + "Continue ?",
//													    "Polygon deletion",
//													    JOptionPane.YES_NO_OPTION);
//												if (n==0){
//													String imageToDelete = new String(currentImage);
//													s1.setCurrentImage(currentImage);
//													s1.changeImage();
//													
//													File f1 = new File("./MyCollections/"+currentCollection+"/"+imageToDelete);
//													f1.delete();
//													File f2 = new File("./MyCollections/"+currentCollection+"/"+imageToDelete.split("\\.")[0]+".xml");
//													if(f2.isFile()){
//														f2.delete();
//													}
//													DefaultMutableTreeNode root = new DefaultMutableTreeNode("root", true);
//													DefaultMutableTreeNode coll = new DefaultMutableTreeNode("MyCollections");
//													DefaultMutableTreeNode collCurr = new DefaultMutableTreeNode(currentCollection);
//													DefaultMutableTreeNode imgCurr = new DefaultMutableTreeNode(imageToDelete);
//													collCurr.add(imgCurr);
//													coll.add(collCurr);
//													root.add(coll);
//													jTree1.setSelectionPath(new TreePath(imgCurr.getPath()));
//													System.out.println(jTree1.getSelectionPath());
//													MutableTreeNode node1 =(MutableTreeNode) jTree1.getSelectionPath().getLastPathComponent();
//													System.out.println(jTree1);
//													d2.removeNodeFromParent(node1);
//													saveNeeded = false;
//												}
//											
//											}
											//Image selected
//											else{
												int n = JOptionPane.showConfirmDialog(
													    jPanel1,
													    "You are about to delete the image \n"
													    +jTree1.getSelectionPath().getLastPathComponent()+"\n"
													    + "Continue ?",
													    "Polygon deletion",
													    JOptionPane.YES_NO_OPTION);
												//If selection is currimage in currcollection
												System.out.println(jTree1.getSelectionPath());
												MutableTreeNode node1 =(MutableTreeNode) jTree1.getSelectionPath().getLastPathComponent();
												String node =jTree1.getSelectionPath().getLastPathComponent().toString();
												String collecTree = jTree1.getSelectionPath().getPathComponent(2).toString();
												if(n==0){
													if((currentImage.equals(node))&&(currentCollection.equals(collecTree))){
														s1.setCurrentImage(currentImage);
														s1.changeImage();
														File f1 = new File("./MyCollections/"+collecTree+"/"+node);
														f1.delete();
														File f2 = new File("./MyCollections/"+collecTree+"/"+node.split("\\.")[0]+".xml");
														if(f2.isFile()){
															f2.delete();
														}
														d2.removeNodeFromParent(node1);
														saveNeeded = false;
													}
													else{
														File f1 = new File("./MyCollections/"+collecTree+"/"+node);
														f1.delete();
														File f2 = new File("./MyCollections/"+collecTree+"/"+node.split("\\.")[0]+".xml");
														if(f2.isFile()){
															f2.delete();
														}
														d2.removeNodeFromParent(node1);
														
														
													}
													
												
												
												}
//											}
										//Update JTree
										d2.reload();
										
										
										jTree1.expandRow(0);
										}
									});
								}
								{	//add a collection
									jButton12 = new JButton();
									jPanel5.add(jButton12);
									jButton12.setText("+Col");
									jButton12.setToolTipText("Add a collection");
									jButton12.setPreferredSize(new java.awt.Dimension(37, 25));
									jButton12.addActionListener(new ActionListener() {
										 //TODO
										Object[] possibilities = null;
										

										
										@Override
										public void actionPerformed(ActionEvent arg0) {
											String s = (String)JOptionPane.showInputDialog(
								                    jPanel1,
								                    "New Collection:",
								                    "Create collection",
								                    JOptionPane.PLAIN_MESSAGE,
								                    null,
								                    possibilities,
								                    "");
												if(s==null){
													return;
												}
												if(!s.equals("")){
													DefaultTreeModel d2 = (DefaultTreeModel) jTree1.getModel();
													TreePath path = jTree1.getNextMatch("MyCollections", 0, Position.Bias.Forward);
										        	MutableTreeNode node = (MutableTreeNode) path.getLastPathComponent();
										        	d2.insertNodeInto(new DefaultMutableTreeNode(s), node,node.getChildCount());
										            File dir = new File("./MyCollections/"+s);
										            dir.mkdir();
										        } else {
										            
										        }
											
										}
									
									});
								}
								{	//remove a collection
									jButton13 = new JButton();
									jPanel5.add(jButton13);
									jButton13.setText("-Col");
									jButton13.setToolTipText("Remove this collection");
									jButton13.setPreferredSize(new java.awt.Dimension(37, 25));
									jButton13.addActionListener(new ActionListener() {
										
										@Override
										public void actionPerformed(ActionEvent arg0) {
											File origin = new File("./MyCollections/");
											File[] collecs = origin.listFiles();
											TreePath selcPath = jTree1.getSelectionPath();
											if(selcPath==null){
												return ;
											}
											String nameSel = selcPath.getLastPathComponent().toString();
											boolean isSelACollec = false;
											for(int i=0;i<collecs.length;i++){
												if(collecs[i].getName().equals(nameSel)){
													isSelACollec = true;
													break;
												}
											}
											if(!isSelACollec){
											//Something else has been selected
												return;
											}
											//In the current collection ? 
											if(currentCollection.equals(nameSel)){
												JOptionPane.showMessageDialog(jPanel1,
													    "You cannot delete the current collection",
													    "Warning",
													    JOptionPane.WARNING_MESSAGE);
												return;
											}
											//We can delete File and node 
											File collecSel = new File("./MyCollections/"+nameSel);
											deleteDirectory(collecSel);
											//Delete Node
											TreePath path =jTree1.getSelectionPath();
											DefaultTreeModel d2 = (DefaultTreeModel) jTree1.getModel();
											MutableTreeNode node = (MutableTreeNode) path.getLastPathComponent();
											d2.removeNodeFromParent(node);
										}
									});
								}
							}
							{
								jTree1 = new JTree();
								jTree1 = CollectionUtils.getTreeCollections();
								jPanel3.add(jTree1, BorderLayout.CENTER);
								BorderLayout jTree1Layout = new BorderLayout();
								jTree1.setLayout(jTree1Layout);
								jTree1.setPreferredSize(new java.awt.Dimension(270, 482));
								jTree1.addMouseListener(new MouseListener() {
									
									@Override
									public void mouseReleased(MouseEvent arg0) {
										Graphics2D g = (Graphics2D)imagePanel.getGraphics();
										
										if(g!=null){
											g.setColor(imagePanel.getCurrentPolygon().getColor());
											imagePanel.paint(g);
										}
										
									}
									
									@Override
									public void mousePressed(MouseEvent arg0) {
										Graphics2D g = (Graphics2D)imagePanel.getGraphics();
										
										if(g!=null){
											g.setColor(imagePanel.getCurrentPolygon().getColor());
											imagePanel.paint(g);
										}
										
									}
									
									@Override
									public void mouseExited(MouseEvent arg0) {}
									
									@Override
									public void mouseEntered(MouseEvent arg0) {
										Graphics2D g = (Graphics2D)imagePanel.getGraphics();
										
										if(g!=null){
											g.setColor(imagePanel.getCurrentPolygon().getColor());
											imagePanel.paint(g);
										}
										
									}
									
									@Override
									public void mouseClicked(MouseEvent arg0) {
										Graphics2D g = (Graphics2D)imagePanel.getGraphics();
										
										if(g!=null){
											g.setColor(imagePanel.getCurrentPolygon().getColor());
											imagePanel.paint(g);
										}
									}
								
								});

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
										jButton8.setEnabled(false);
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
						    .addComponent(jButton8, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
						    .addComponent(jButton9, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
						    .addComponent(jButton10, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(0, 17, Short.MAX_VALUE)
						.addComponent(jTabbedPane1, GroupLayout.PREFERRED_SIZE, 270, GroupLayout.PREFERRED_SIZE));
					jPanel1Layout.linkSize(SwingConstants.HORIZONTAL, new Component[] {jButton8, jButton9, jButton10});
					jPanel1Layout.linkSize(SwingConstants.HORIZONTAL, new Component[] {jButton5, jButton4});
					jPanel1Layout.setVerticalGroup(jPanel1Layout.createSequentialGroup()
						.addContainerGap(10, 10)
						.addGroup(jPanel1Layout.createParallelGroup()
						    .addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
						        .addComponent(jPanel4, GroupLayout.PREFERRED_SIZE, 603, GroupLayout.PREFERRED_SIZE)
						        .addGap(0, 40, Short.MAX_VALUE)
						        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						            .addComponent(jButton2, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
						            .addComponent(jToggle1, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
						            .addComponent(jButton1, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
						        .addGap(35))
						    .addGroup(jPanel1Layout.createSequentialGroup()
						        .addGap(156)
						        .addGroup(jPanel1Layout.createParallelGroup()
						            .addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
						                .addGap(0, 0, Short.MAX_VALUE)
						                .addComponent(jTabbedPane1, GroupLayout.PREFERRED_SIZE, 549, GroupLayout.PREFERRED_SIZE))
						            .addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
						                .addGap(59)
						                .addGroup(jPanel1Layout.createParallelGroup()
						                    .addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
						                        .addComponent(jButton5, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
						                        .addGap(14))
						                    .addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
						                        .addGap(14)
						                        .addComponent(jButton4, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)))
						                .addComponent(jButton8, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						                .addComponent(jButton9, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
						                .addComponent(jButton10, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						                .addGap(0, 329, Short.MAX_VALUE))))));
					jPanel1Layout.linkSize(SwingConstants.VERTICAL, new Component[] {jButton8, jButton9, jButton10});
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
	
	public static JList getPolyList(){
		return polyList;
	}
	
	public static void setEnablePolyButtons(boolean b){
		jButton8.setEnabled(b);
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

	 static public boolean deleteDirectory(File path) {
		    if( path.exists() ) {
		      File[] files = path.listFiles();
		      for(int i=0; i<files.length; i++) {
		         if(files[i].isDirectory()) {
		           deleteDirectory(files[i]);
		         }
		         else {
		           files[i].delete();
		         }
		      }
		    }
		    return( path.delete() );
		  }

}
