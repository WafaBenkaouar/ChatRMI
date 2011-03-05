import java.io.*;
import java.net.*;
import java.net.UnknownHostException;
import java.rmi.*;
import java.rmi.registry.*;
import java.rmi.server.*;
import java.util.*;



/**
 * Remote Class for the Chat.
 */

public class Server extends UnicastRemoteObject implements ServerInterface {
/*Server propieties*/
	 private String addressServer;
	    // Numero of the port.
	    private int portServer;
	   // Localization.
	    private Locale locale;
	    // Ressource associated to the localization.
	    private ResourceBundle ressources;
	
	/*
	
	
	/**
	 * Attributes
	 */
	protected int maxNbUserOnline = 0;
	protected int maxNbUserRegister = 0;
	protected Hashtable usersOnline;
	protected Hashtable usersRegister;
	protected int countUserResgistration;
	protected int countUserOnline;
	protected File text = new File("text.txt");
	protected boolean state;

	/**
	 * Constructor
	 * 
	 * @throws RemoteException
	 */
	protected Server() throws RemoteException {
		//super();
        /*try
        {
            addressServer = InetAddress.getLocalHost().getHostAddress();
        }
        catch(UnknownHostException e)
        {
            System.out.println(e);
        }*/
        portServer = 1099;
    	countUserOnline = 0;
		countUserResgistration = 0;
		usersOnline = new Hashtable(maxNbUserOnline);
		usersRegister = new Hashtable(maxNbUserRegister);
		state = false;
		if(!text.exists())
			try {
				text.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        
        //ressources = ResourceBundle.getBundle("rmichat.ressources.server", locale);
	}
	  public Server(String addressServer_, int portServer_) throws RemoteException
	  {
	      //  super();
	        addressServer = addressServer_;
	        portServer = portServer_;
	        usersOnline = new Hashtable(maxNbUserOnline);
			usersRegister = new Hashtable(maxNbUserRegister);
			if(!text.exists())
				try {
					text.createNewFile();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	  }
	  
	/**
	 * Remotely Accessible
	 * 
	 * @throws RemoteException
	 */
	@Override
	public void start() throws RemoteException{
		state = true;
	}

	@Override
	public void stop()throws RemoteException {
		usersOnline.clear();
		state = false;
	}

	@Override
	public void registerNewUser(String name) throws RemoteException {
		if (usersRegister.containsValue(name)) {
			System.out
					.println("This name is already used on the chat, please enter another name");
		} else {
			usersRegister.put(name, new User());
			countUserResgistration++;
		}

	}

	public void unregisterUser(String name) {
		usersRegister.remove(name);

	}

	// LEAVE CHAT
	public void logout(String name) throws RemoteException {
		usersOnline.remove(name);
		countUserOnline--;
	}

	// JOIN CHAT
	public void login(String name) throws RemoteException {
		if (countUserOnline == maxNbUserOnline) {
			System.out
					.println("Too many users are already connected to this chat, Sorry :(");
			return;
		} else {
			countUserOnline++;
			usersOnline.put(name, getUser(name));

		}
	}

	public String printMessage(String username, String message) throws RemoteException {
		  Calendar calendar = new GregorianCalendar();
		  
		    int hour = calendar.get(Calendar.HOUR_OF_DAY);
		    int minute = calendar.get(Calendar.MINUTE);
		    int second = calendar.get(Calendar.SECOND);
		   
		  		
		try {
			this.setContents(text, "["+hour+":"+minute+":"+second+"] | "+"<"+username+"> "+message+"\n");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return this.getContents(text);
	}

	public int getNbUserConnected()throws RemoteException {
		return this.countUserOnline;
	}

	public boolean existingUser(String name) {
		return this.usersRegister.containsKey(name);
	}

	public User getUser(String name) throws RemoteException{
		User user = null ;
		if (existingUser(name)) {
			user =  (User) usersRegister.get(name);
		}
		return user;
	}


	public boolean isON() throws RemoteException {
		return state;
	}

	

	  public static void main ( String args[] ) throws Exception
	    {
	        try{
	       
	          //  System.setSecurityManager ( new RMISecurityManager() );

	        Registry r = LocateRegistry.getRegistry();
	        
	        // ... and bind it with the RMI Registry
	        r.bind ("ChatService", new Server());

	        System.out.println ("Service bound....");
	        }catch (Exception e){
				e.printStackTrace();
			}
	    }

	/***************************************TO WRITE N READ THE TEXT FILE STORING THE MESSAGES ***********************************************/
		static public String getContents(File aFile) {
			// ...checks on aFile are elided
			StringBuilder contents = new StringBuilder();

			try {
				// use buffering, reading one line at a time
				// FileReader always assumes default encoding is OK!
				BufferedReader input = new BufferedReader(new FileReader(aFile));
				try {
					String line = null; // not declared within while loop
					/*
					 * readLine is a bit quirky : it returns the content of a line
					 * MINUS the newline. it returns null only for the END of the
					 * stream. it returns an empty String if two newlines appear in
					 * a row.
					 */
					while ((line = input.readLine()) != null) {
						contents.append(line);
						contents.append(System.getProperty("line.separator"));
					}
				} finally {
					input.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}

			return contents.toString();
		}

		static public void setContents(File aFile, String aContents)
				throws FileNotFoundException, IOException {
			if (aFile == null) {
				throw new IllegalArgumentException("File should not be null.");
			}
			if (!aFile.exists()) {
				throw new FileNotFoundException("File does not exist: " + aFile);
			}
			if (!aFile.isFile()) {
				throw new IllegalArgumentException("Should not be a directory: "
						+ aFile);
			}
			if (!aFile.canWrite()) {
				throw new IllegalArgumentException("File cannot be written: "
						+ aFile);
			}

			// use buffering
			Writer output = new BufferedWriter(new FileWriter(aFile,true));
			try {
				// FileWriter always assumes default encoding is OK!
				output.write(aContents);
			} finally {
				output.close();
			}
		}

}
