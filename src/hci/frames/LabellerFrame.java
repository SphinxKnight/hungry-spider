package hci.frames;
import hci.ImagePanel;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;


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
public class LabellerFrame extends javax.swing.JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JScrollPane jScrollPane1;
	private JPanel jPanel2;
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
				{
					jPanel1 = new JPanel();
					GridBagLayout jPanel1Layout = new GridBagLayout();
					jScrollPane1.setViewportView(jPanel1);
					jPanel1.setPreferredSize(new java.awt.Dimension(997, 720));
					jPanel1Layout.rowWeights = new double[] {0.0, 0.1, 0.1, 0.1, 0.1};
					jPanel1Layout.rowHeights = new int[] {41, 20, 7, 7, 7};
					jPanel1Layout.columnWeights = new double[] {0.0, 0.1, 0.1, 0.0, 0.1};
					jPanel1Layout.columnWidths = new int[] {69, 7, 7, 93, 20};
					jPanel1.setLayout(jPanel1Layout);
					{
						jPanel2 = new JPanel();
						jPanel1.add(jPanel2, new GridBagConstraints(1, 1, 3, 3, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
					}
					imagePanel = new ImagePanel("folder.jpg");
					imagePanel.setOpaque(true); //content panes must be opaque
					
			        jPanel2.add(imagePanel);
				}
			}
			pack();
			this.setSize(1024, 768);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	public void paint(Graphics g) {
		super.paint(g);
		imagePanel.paint(g); //update image panel
	}

}
