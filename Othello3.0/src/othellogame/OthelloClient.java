package othellogame;

import java.io.*;

import client.*;

public class OthelloClient extends AbstractClient{

	LobbyUI lobbyUI;
	LoginUI loginUI;
	public static String clientnum;
	int limit=0;
	

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
	
	public OthelloClient(String host, int port, LoginUI loginUI) {
		super(host, port);
		this.loginUI = loginUI;
		try {
			openConnection();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void login(String name, String pw){
		try {
			sendToServer("log " + name + " " + pw);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void register(String name, String pw){
		try {
			sendToServer("reg " + name + " " + pw);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void showLobby(){
		
		
	}

/*Giri*/
	@Override
	protected void handleMessageFromServer(Object msg) {
		String reply = msg.toString(); // Takes the value as string
		if (reply.startsWith("client: ")) { // Verify the format of reply from
											// server
			clientnum = reply.substring(8); // Extracting the client number from
											// the reply
			System.out.println("client number is " + clientnum);
			limit = Integer.parseInt(clientnum); // converting to integer for
													// further operation

			if (limit >= 1 && limit <= 4) { // We can allow maximum 4 players so
											// verify the limit
				if (limit == 1) { // Only first and 3rd user can open the lobby
									// UI;second and fourth clients will join
									// the existing lobby
					OthelloAccess.launchUI(true);
				} else if (limit == 3) {
					OthelloAccess.launchUI(true);
				} else {
					OthelloAccess.launchUI(false);
				}
			}

		} else if (reply.equals("Connection Refused")) { // Connection refused
														// message generated
															// at the server
															// when more than 4
															// players try to
															// connect to the
															// server
			OthelloAccess.launchUI(false);

		}
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
