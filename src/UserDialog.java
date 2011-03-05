import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class UserDialog extends JOptionPane{
	  	
		/*attributes*/
		private String typedText = null;
	    private JTextField textField;
	    private String btnString1 = "Enter";
	    private String btnString2 = "Cancel";
	    
	    /*Constructor*/
	    public UserDialog(){
	    	 textField = new JTextField(10);
	    	 
	    	 	typedText = this.showInputDialog(this,"Please enter a username : "
                    ,
                    "Welcome to Miaou",
                    JOptionPane.PLAIN_MESSAGE);
	    	 	
	    	 	this.add(textField);
	    	 	textField.requestFocusInWindow();
	            this.getValidatedText();

	 	       

	    }
	   
	    /*Methods*/
	    public String getValidatedText() {
	       
	        	return typedText;
	    }
	    public void actionPerformed(ActionEvent e) {
	        this.setValue(btnString1);
	    }
	    public void clearAndHide() {
	        textField.setText(null);
	        setVisible(false);
	    }


}
