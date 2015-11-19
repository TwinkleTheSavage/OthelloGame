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
	Game testGame = new Game();

	GameUI game = new GameUI();
    int [][] Board = testGame.board;

	static String name;			//stores login name for future use.
	static String storePass;			//stores password for future use
	  public static void loginPass(String login) throws IOException{
		  name = login;
	  }
	  public static void passwordPass(String pass) throws IOException{
		  storePass = pass;
	  }
	 //Should we save these in an array or a file?
	
	
	
	
	
	
	
	
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
 
 if (msg.equals("cg"))
	 this.createGame();
 
 else
	 this.joinGame(game);
}
 

public void createGame(){
	Player player1 = new Player("P1", Color.BLACK);
	player1.startTurn(true, Color.BLACK);
	GameUI game = new GameUI(); // I ADDED THIS TO CREATE A NEW WINDOW SINCE IT WOULD JUST OPEN THE OLD GAME WITH THE COLORS (but not values) FILLED IN. COOLBEANS RIGHT?
	game.setVisible(true);		
	Game.setBoardValues();
	

}

public void joinGame(GameUI game){
	Player player2 = new Player("P2", Color.WHITE);
	player2.startTurn(false, Color.WHITE);
	game.setVisible(true);
	
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
