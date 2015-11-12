package othellogame;

import java.io.*;

import client.*;

public class OthelloClient extends AbstractClient{

	LobbyUI lobbyUI;
	
	public OthelloClient(String host, int port) throws IOException{
	    super(host, port); //Call the superclass constructor
	    openConnection();
	  }

	public OthelloClient(String host, int port, LobbyUI lobbyUI) {
		super(host, port);
		this.lobbyUI = lobbyUI;
		try {
			openConnection();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	protected void handleMessageFromServer(Object msg) {
		// TODO Auto-generated method stub
		
	}
	
	public void handleMessageFromClientUI(String msg){
		try {
			sendToServer(msg);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//accepts input from the console
	/*
	public void accept()
	{
		try
		{
			BufferedReader fromConsole =
					new BufferedReader(new InputStreamReader(System.in));
			String message;

			while (true)
			{
				message = fromConsole.readLine();
				//processmessage(message);
			}
		}
		catch (Exception ex)
		{
			System.out.println
					("Unexpected error while reading from console!");
		}


	}
	*/


}
