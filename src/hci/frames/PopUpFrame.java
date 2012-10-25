package hci.frames;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

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
@SuppressWarnings("serial")
public class PopUpFrame extends javax.swing.JFrame {

	{
		//Set Look & Feel
		try {
			javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	private JButton validButton;
	private JButton cancelButton;
	private JButton jButton1;
	private JLabel question;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				PopUpFrame inst = new PopUpFrame("Test",null);
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public PopUpFrame(String message, SwitchImageListener switchImageListener) {
		super();
		initGUI(message, switchImageListener);
	}
	
	private void initGUI(String message, final SwitchImageListener switchImageListener) {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				validButton = new JButton();
				getContentPane().add(validButton);
				validButton.setText("Yes");
				validButton.setBounds(305, 135, 60, 38);
				validButton.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
						dispose();
						switchImageListener.save();
						
						
					}
				});
			}
			{
				cancelButton = new JButton();
				getContentPane().add(cancelButton);
				cancelButton.setText("Cancel");
				cancelButton.setBounds(580, 135, 105, 38);
				cancelButton.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
						dispose();
					
						
						
					}
				});
			}
			{
				question = new JLabel();
				question.setText(message);
				getContentPane().add(question);
				question.setBounds(15, 17, 711, 106);
			}
			{
				jButton1 = new JButton();
				getContentPane().add(jButton1);
				jButton1.setText("Do not save");
				jButton1.setBounds(415, 135, 103, 38);
				jButton1.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
						dispose();
						switchImageListener.nosave();
						
						
					}
				});
			}
			pack();
			this.setSize(824, 234);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
}
