import java.rmi.*;
/**
 * Remote Interface for the Chat class.
 */

public interface ServerInterface extends Remote{
	
	/**
	 * Remotely accessible methods
	 * @param userId
	 * @param message
	 */
	public void leaveChat(int userId)throws RemoteException;
	public void joinChat(int userId)throws RemoteException;
	public void showMessage(String message)throws RemoteException;
	
}
