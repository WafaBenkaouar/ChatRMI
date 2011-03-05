import java.rmi.*;
import java.rmi.server.*;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.swing.JTextField;

public class UserInterface extends JFrame{

	
	
	
	
	private JPanel jContentPane = null;
	private JPanel jPanel = null;
	private JPanel jPanel1 = null;
	private JTextArea jTextArea = null;
	private JPanel jPanel2 = null;
	private JButton jButton = null;
	private JButton jButton1 = null;
	private JTextField jTextField = null;
	private UserDialog ud;

public UserInterface(){
super();
ud = new UserDialog();
this.add(ud);

try{
User user = new User(ud.getValidatedText());}catch(Exception e){e.getStackTrace();}

	this.setSize(new Dimension(344, 234));
	this.setTitle("Minou");
	this.setContentPane(getJContentPane());
	this.setLocationRelativeTo(null);
	this.setVisible(true);

}

	

public UserDialog getUserDialog(){
	return ud;
}
	/**
	 * This method initializes jContentPane	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			BorderLayout borderLayout = new BorderLayout();
			borderLayout.setHgap(10);
			borderLayout.setVgap(10);
			jContentPane = new JPanel();
			jContentPane.setLayout(borderLayout);
			jContentPane.add(getJPanel(), BorderLayout.CENTER);
			jContentPane.add(getJPanel1(), BorderLayout.SOUTH);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jPanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel() {
		if (jPanel == null) {
			BorderLayout borderLayout1 = new BorderLayout();
			borderLayout1.setHgap(10);
			borderLayout1.setVgap(10);
			jPanel = new JPanel();
			jPanel.setLayout(borderLayout1);
			jPanel.add(getJTextArea(), BorderLayout.CENTER);
			jPanel.add(getJPanel2(), BorderLayout.EAST);
		}
		return jPanel;
	}

	/**
	 * This method initializes jPanel1	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel1() {
		if (jPanel1 == null) {
			BorderLayout borderLayout2 = new BorderLayout();
			borderLayout2.setHgap(5);
			jPanel1 = new JPanel();
			jPanel1.setLayout(borderLayout2);
			jPanel1.add(getJTextField(), BorderLayout.NORTH);
		}
		return jPanel1;
	}

	/**
	 * This method initializes jTextArea	
	 * 	
	 * @return javax.swing.JTextArea	
	 */
	private JTextArea getJTextArea() {
		if (jTextArea == null) {
			jTextArea = new JTextArea();
			jTextArea.setEditable(false);
			jTextArea.setLineWrap(true);
			jTextArea.setWrapStyleWord(true);
			jTextArea.setFont(new Font("Ubuntu", Font.BOLD,12));
		}
		return jTextArea;
	}
public void setMessage(String allMessages) {
	
    
		    	  getJTextArea().setText(allMessages);
		    

	
}
	/**
	 * This method initializes jPanel2	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel2() {
		if (jPanel2 == null) {
			GridLayout gridLayout = new GridLayout();
			gridLayout.setRows(2);
			gridLayout.setVgap(5);
			gridLayout.setHgap(5);
			gridLayout.setColumns(1);
			jPanel2 = new JPanel();
			jPanel2.setLayout(gridLayout);
			jPanel2.add(getJButton(), null);
			jPanel2.add(getJButton1(), null);
		}
		return jPanel2;
	}

	/**
	 * This method initializes jButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton() {
		if (jButton == null) {
			jButton = new JButton();
			jButton.setText("Connexion");
		}
		return jButton;
	}

	/**
	 * This method initializes jButton1	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton1() {
		if (jButton1 == null) {
			jButton1 = new JButton();
			jButton1.setText("Change nom");
		}
		return jButton1;
	}

	/**
	 * This method initializes jTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	public JTextField getJTextField() {
		if (jTextField == null) {
			jTextField = new JTextField();
			jTextField.setPreferredSize(new Dimension(100, 19));
		}
		return jTextField;
	}
	
	
}