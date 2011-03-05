import java.io.*;
import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;


public class User extends UnicastRemoteObject {

	protected String username;
	protected User(String username) throws RemoteException {
        super();
        this.username = username;
   
    }
	protected User() throws RemoteException {
     this("Anonymus");
    }

    public static void displayMessage  (String message, String username) throws IOException {
// set text in the file text.txt
    	
    			  
    		  
    		   
    	//print the text in the Jtextfield
    	
    }
   
    /**
     * Remotely accessible by the Chat class
     */
   /* public void sendMessage(String message) {
        serverConn.showMessage(input.next());
    }
*/

   /* public static void main(String args[]) throws Exception {
    	try{
			System.setSecurityManager(new RMISecurityManager());
    	
    
        System.out.println("\n# you did not provide a server name");
     

    ServerInterface chatservice1 = (ServerInterface) Naming.lookup("rmi://localhost/ChatService");
    System.out.println(chatservice1.isON());

    Scanner dataIn = new Scanner (System.in);

    System.out.println("\n# pick your username please:");
    String username = dataIn.nextLine();

    for(;;) {
    	chatservice1.registerNewUser(username);
        System.out.println("\n# type /q to quit, or type your message: ");
        String line = dataIn.nextLine();

        if (line.compareTo("/q") ==0) {
        chatservice1.logout(username);
        return;
        }
        else {
        chatservice1.printMessage(username,line);
        }
    }}catch(Exception e){
		e.printStackTrace();
	}
    }

*/   
}