import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;


public class User extends UnicastRemoteObject implements UserInterface{

	protected User() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}



	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String username;
	private int userid;
	private String message;
	
	
	
	/**
	 * Remotely accessible by the Chat class
	 */
	public void sendMessage(String message){
		
	}



	@Override
	public void ChatServer() throws RemoteException {
		// TODO Auto-generated method stub
		
	}
	
}
