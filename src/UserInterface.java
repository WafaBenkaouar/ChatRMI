import java.rmi.*;
import java.rmi.server.*;

public interface UserInterface extends Remote{

	
	
	
	/**
	 * Constructor
	 * @return 
	 */
	public void ChatServer()throws RemoteException;
}
