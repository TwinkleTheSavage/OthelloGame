package othellogame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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


		String host = "";
		int port = 0;
		
		try{
			host = args[0];
		}
		catch(ArrayIndexOutOfBoundsException e){
			host = "localhost";
		}

		try {
			port = Integer.parseInt(args[1]);
		}
		catch(ArrayIndexOutOfBoundsException e){
			port = DEFAULT_PORT;
		}

		OthelloClient chat= null;
		try {
			chat = new OthelloClient(host, port);
		} catch (IOException e) {
			//e.printStackTrace();
			System.out.println("Error: Can't setup connection!"
					+ " Terminating client.");
			System.exit(1);
		}


		LobbyUI log = new LobbyUI(); //THIS SHOULD BE LAUNCHING LoginUI BUT IT'S BROKE, SO WE'RE SKIPPING THAT STEP. FOR NOW.
		log.setVisible(true);



	}


}
