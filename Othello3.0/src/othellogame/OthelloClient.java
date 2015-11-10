package othellogame;

import java.io.*;
import client.*;

public class OthelloClient extends AbstractClient{

	public OthelloClient(String host, int port) throws IOException{
	    super(host, port); //Call the superclass constructor
	    openConnection();
	  }

	@Override
	protected void handleMessageFromServer(Object msg) {
		// TODO Auto-generated method stub
		
	}
	
}
