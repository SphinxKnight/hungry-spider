package hci.frames;
import hci.ImagePanel;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTree;
import javax.swing.LayoutStyle;
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
	private JButton jButton1;
	private JPanel jPanel4;
	private JButton jButton5;
	private JButton jButton4;
	private JPanel jPanel3;
	private JPanel jPanel2;
	private JTabbedPane jTabbedPane1;
	private JButton jButton3;
	private JButton jButton2;

	private JPanel jPanel1;
	ImagePanel imagePanel = null;

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
				jScrollPane1.setPreferredSize(new java.awt.Dimension(963, 711));
				{
					jPanel1 = new JPanel();
					jScrollPane1.setViewportView(jPanel1);
					GroupLayout jPanel1Layout = new GroupLayout((JComponent)jPanel1);
					jPanel1.setLayout(jPanel1Layout);
					jPanel1.setPreferredSize(new java.awt.Dimension(1144, 744));
					{
						jButton4 = new JButton();
						jButton4.setText("<");
					}
					{
						jButton2 = new JButton();
						jButton2.setText("Close this polygon");
						jButton2.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e){
				                imagePanel.addNewPolygon();
				            }
				        });       
					}
					{
						jButton3 = new JButton();
						jButton3.setText("jButton3");
					}
					{
						jPanel4 = new JPanel();
						FlowLayout jPanel4Layout = new FlowLayout();
						jPanel4.setLayout(jPanel4Layout);
						jPanel4.setSize(800, 600);
						{
							imagePanel = new ImagePanel("test.jpeg");
							FlowLayout imagePanelLayout = new FlowLayout();
							imagePanel.setLayout(imagePanelLayout);
							jPanel4.add(imagePanel);
							imagePanel.setOpaque(true);
						}
					}
					{
						jTabbedPane1 = new JTabbedPane();
						{
							jPanel2 = new JPanel();
							jTabbedPane1.addTab("My Annotation", null, jPanel2, null);
						}
						{
							jPanel3 = new JPanel();
							BorderLayout jPanel3Layout = new BorderLayout();
							jPanel3.setLayout(jPanel3Layout);
							jTabbedPane1.addTab("My Collection", null, jPanel3, null);
							{
								jTree1 = new JTree();
								BorderLayout jTree1Layout = new BorderLayout();
								jTree1.setLayout(jTree1Layout);
								jPanel3.add(jTree1, BorderLayout.CENTER);
								jTree1.setPreferredSize(new java.awt.Dimension(166, 234));
							}
						}
					}
					{
						jButton5 = new JButton(new ImageIcon("test.jpeg",
                                "move polygon/oval"));
						jButton5.setOpaque(true);

					}
					{
						jButton1 = new JButton();
						jButton1.setText("jButton1");
					}

					jPanel1Layout.setHorizontalGroup(jPanel1Layout.createSequentialGroup()
						.addContainerGap()
						.addComponent(jButton4, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(jPanel1Layout.createParallelGroup()
						    .addComponent(jPanel4, GroupLayout.Alignment.LEADING, 0, 894, Short.MAX_VALUE)
						    .addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
						        .addGap(78)
						        .addComponent(jButton2, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
						        .addGap(116)
						        .addComponent(jButton1, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
						        .addGap(90)
						        .addComponent(jButton3, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
						        .addGap(0, 367, Short.MAX_VALUE)))
						.addGroup(jPanel1Layout.createParallelGroup()
						    .addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
						        .addComponent(jButton5, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
						        .addGap(204))
						    .addComponent(jTabbedPane1, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 325, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(12, 12));
					jPanel1Layout.setVerticalGroup(jPanel1Layout.createSequentialGroup()
						.addContainerGap(70, 70)
						.addGroup(jPanel1Layout.createParallelGroup()
						    .addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
						        .addComponent(jButton5, 0, 88, Short.MAX_VALUE)
						        .addGap(49)
						        .addGroup(jPanel1Layout.createParallelGroup()
						            .addComponent(jTabbedPane1, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 537, GroupLayout.PREFERRED_SIZE)
						            .addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
						                .addGap(68)
						                .addComponent(jButton4, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
						                .addGap(442))))
						    .addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
						        .addComponent(jPanel4, 0, 622, Short.MAX_VALUE)
						        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						            .addComponent(jButton2, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
						            .addComponent(jButton1, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
						            .addComponent(jButton3, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
						        .addGap(25))));
				}
			}
			pack();
			this.setSize(1312, 777);
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
		// TODO Auto-generated method stub
		
	}

}
