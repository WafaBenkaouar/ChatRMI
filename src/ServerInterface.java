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
	public void login(String name)throws RemoteException;
	public void logout(String name)throws RemoteException;
	public String printMessage(String username,String message)throws RemoteException;
	public boolean isON() throws RemoteException;
	public void registerNewUser(String name) throws RemoteException;
	public void start() throws RemoteException;
	public void stop()throws RemoteException;
	public void unregisterUser(String name)throws RemoteException;
	public int getNbUserConnected()throws RemoteException;
	 
	
}
