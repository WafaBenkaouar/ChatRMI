import java.rmi.*;
import java.rmi.server.*;

/**
 * Remote Class for the Chat.
 */

public class Server extends UnicastRemoteObject implements ServerInterface{

	/**
	 * Attributes
	 */
	protected int maxNbUser = 5;
	protected int[] usersOnline = new int[maxNbUser];
	protected int countUserOnline;
	/**
	 * Constructor
	 * @throws RemoteException
	 */
	protected Server() throws RemoteException {
		super();
		this.countUserOnline = 0;
	}

	
	/**
	 * Remotely Accessible 
	 */
	public void leaveChat(int userId)throws RemoteException{
		
	}
	public void joinChat(int userId)throws RemoteException{
		if(this.countUserOnline == this.maxNbUser){
			System.out.println("Too many users are already connected to this chat, Sorry :(");
			return;
		}
		else {
			this.countUserOnline ++;
			this.usersOnline[this.countUserOnline]= userId;
			
		}
	}
	public void showMessage(String message)throws RemoteException{
		
	}
	
}
