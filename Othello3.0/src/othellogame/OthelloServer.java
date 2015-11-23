package othellogame;

//This file contains material supporting section 3.7 of the textbook:
//"Object Oriented Software Engineering" and is issued under the open-source
//license found at www.lloseng.com 

import java.awt.Color;
import java.io.*;

import server.*;

/**
* This class overrides some of the methods in the abstract 
* superclass in order to give more functionality to the server.
*
* @author Dr Timothy C. Lethbridge
* @author Dr Robert Lagani&egrave;re
* @author Fran&ccedil;ois B&eacute;langer
* @author Paul Holden
* @version July 2000
*/
public class OthelloServer extends AbstractServer{
	
	//Game game;
	//Game game2;

	int gameCount = 0;
	

    //int to compare pw to username
    int playerCount = 0;
	static String name;			//stores login name for future use.
	
	//array of usernames
	String names[] = new String[20];
	
	static String storePass;			//stores password for future use
	
	//array of passwords
	String pws[] = new String[20];


	  public static void loginPass(String login) throws IOException{
		  name = login;
	  }
	  public static void passwordPass(String pass) throws IOException{
		  storePass = pass;
	  }
	 
	
	
	
	
	
	
	
	
//Class variables *************************************************

/**
* The default port to listen on.
*/
final public static int DEFAULT_PORT = 5555;

//Constructors ****************************************************

/**
* Constructs an instance of the echo server.
*
* @param port The port number to connect on.
*/
public OthelloServer(int port){
 super(port);
}


//Instance methods ************************************************

/**
* This method handles any messages received from the client.
*
* @param msg The message received from the client.
* @param client The connection from which the message originated.
*/
public void handleMessageFromClient(Object msg, ConnectionToClient client){
	//juicy feedback
 System.out.println("Message received: " + msg + " from " + client);
 String[] tokens = new String[3];
 
 if (msg.equals("cg"))
	 this.createGame();
 
 else if (msg.equals("jg")){}
	 //this.joinGame(game);
	 
	  //sending messages to server, "reg" should start this if clause
 else if (((String) msg).startsWith("r")){
	
	 //split the string and set each part to an index in this array
	tokens = ((String) msg).split(" ");
	
	//"reg RJB12 33343" should send RJB12 to names[] and 33343 to pws[] 
 	names[playerCount] = tokens[1];
 	pws[playerCount] = tokens[2];
 	
 	//increment playerCount to ensure the next registration puts their info in the next slot of array
 	playerCount++;
 	
 	System.out.println("Registration successful");
 }
 
 else if (((String) msg).startsWith("l")){
	 tokens = ((String) msg).split(" ");
	 for (int i = 0; i <= playerCount; i++){
		 
		 //debugging
		 System.out.println(names[i] + " " + pws[i]);
		 System.out.println(tokens[1] + " " + tokens[2]);
		 //
		 
		 if (tokens[1].equals(names[i])){
			 if (tokens[2].equals(pws[i])){
				 System.out.println("login successful");
				 
				 try {
					client.sendToClient("gli");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			 }
			 else System.out.println("invalid password, try again.");
			 	
		 }
				 
	 }
 }
 
 else return;
}
 

public void createGame(){


	//if (gameCount == 0){
		
		Player player1 = new Player("P1", Color.BLACK);
		player1.startTurn(true, Color.BLACK);
		
		//create a game named "game1"
		Game game = new Game("game1");
		game.showGameUICreator();
		//create a GameUI with argument game, which is a Game object 
		//gameUI = new GameUI(game); 
		//gameUI.setVisible(true);	
		
		//increment gameCount so we know how many games have been created
		gameCount++;
		
		//add a String to the LobbyUI list
		LobbyUI.addToList("Game 1");
	//}
	
		/*
	else if (gameCount == 1){
		Player player1 = new Player("P1", Color.BLACK);
		player1.startTurn(true, Color.BLACK);
		Game game2 = new Game("game2");
		//gameUI2 = new GameUI(game2); // I ADDED THIS TO CREATE A NEW WINDOW SINCE IT WOULD JUST OPEN THE OLD GAME WITH THE COLORS (but not values) FILLED IN. COOLBEANS RIGHT?
		//gameUI2.setVisible(true);
		gameCount++;
		LobbyUI.addToList("Game 2");
	}
	*/
	//else System.out.println("Sorry, max number of games created.");


}

public void joinGame(Game game){
	Player player2 = new Player("P2", Color.WHITE);
	player2.startTurn(false, Color.WHITE);
	
	if (gameCount == 0){
		//gameUI = new GameUI(game);
		//gameUI.setVisible(true);
	}
	else if (gameCount == 1){
		//gameUI2 = new GameUI(game2);
		//gameUI2.setVisible(true);
	}
	
	else return;
	
	
}



/**
* This method overrides the one in the superclass.  Called
* when the server starts listening for connections.
*/
protected void serverStarted(){
 System.out.println
   ("Server listening for connections on port " + getPort());
}

/**
* This method overrides the one in the superclass.  Called
* when the server stops listening for connections.
*/
protected void serverStopped(){
 System.out.println
   ("Server has stopped listening for connections.");
 
}

protected void clientConnected(ConnectionToClient client){					//Method overrides the one in the superclass.
	  System.out.println("A client has connected.");							//Called when a client connects.
}


synchronized protected void clientDisconnected(ConnectionToClient client){	//Method overrides the one in the superclass.
	  System.out.println("A client has disconnected.");		//Called when a client disconnects.
}

//This method will update the game board after a player makes a move
public void updateGameBoard(int[][] board){



    }

/**
* This method is responsible for the creation of 
* the server instance (there is no UI in this phase).
*
* @param args[0] The port number to listen on.  Defaults to 5555 
*          if no argument is entered.
*/
public static void main(String[] args) 
{
 int port = 0; //Port to listen on

 try
 {
   port = Integer.parseInt(args[0]); //Get port from command line
 }
 catch(Throwable t)
 {
   port = DEFAULT_PORT; //Set port to 5555
 }
	
 OthelloServer sv = new OthelloServer(port);
 
 try 
 {
   sv.listen(); //Start listening for connections
 } 
 catch (Exception ex) 
 {
   System.out.println("ERROR - Could not listen for clients!");
 }
}

}
//End of EchoServer class
