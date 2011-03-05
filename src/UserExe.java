import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.util.Scanner;


public class UserExe {

	/**
	 * @param args
	 */
	  public static void main(String args[]) throws Exception {
		  
		  
			 UserInterface uintf = new UserInterface();
			 try{
					System.setSecurityManager(new RMISecurityManager());
		    	  

		    ServerInterface chatservice1 = (ServerInterface) Naming.lookup("rmi://localhost/ChatService");
		    

		 //    chatservice1.logout(username);
		    String username = uintf.getUserDialog().getValidatedText();
		    
		    chatservice1.registerNewUser(username);
String message;
		    {
		    	chatservice1.registerNewUser(username);
		    	message = uintf.getJTextField().getText();
		        
		       
		        
		        uintf.setMessage(chatservice1.printMessage(username,message));
		       
		    }}catch(Exception e){
				e.printStackTrace();
			}
			  
		
		    }

}
