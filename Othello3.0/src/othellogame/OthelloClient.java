package othellogame;


import java.io.*;

import client.*;

public class OthelloClient extends AbstractClient{

	LobbyUI lobbyUI;
	LoginUI loginUI;
	GameUI gameUI;
		
	public OthelloClient(String host, int port) throws IOException{
	    super(host, port); //Call the superclass constructor
	    openConnection();
	  }

	/*
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
	*/
	
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
		
		lobbyUI = new LobbyUI(this);
		
	}

	@Override
	protected void handleMessageFromServer(Object msg) {
		if (msg.equals("gli")){
			this.showLobby();
			loginUI.setVisible(false);
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

	


}
