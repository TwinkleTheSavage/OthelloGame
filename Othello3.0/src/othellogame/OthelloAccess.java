package othellogame;

import java.io.IOException;
import othellogame.OthelloClient;

public class OthelloAccess {
	/**
	 * The default port to connect on.
	 */
	final public static int DEFAULT_PORT = 5555;
	
	OthelloClient client;
	
	
	public void ClientConsole(String host, int port) 
	{
		try 
		{
			client= new OthelloClient(host, port);
		} 
		catch(IOException exception) 
		{
			System.out.println("Error: Can't setup connection!"
					+ " Terminating client.");
			System.exit(1);
		}
	}



	//MAIN//
	public static void main(String[] args){

		LoginUI log = new LoginUI("localhost", 5555);
		log.setVisible(true);



	}


}
